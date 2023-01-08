package com.bracits.fingerprint.controller;

import com.bracits.fingerprint.dto.DecryptRequestDto;
import com.bracits.fingerprint.exception.ResourceNotFoundException;
import io.swagger.annotations.ApiOperation;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.concurrent.TimeUnit;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.validation.Valid;
import org.ehcache.Cache;
import org.ehcache.CacheManager;
import org.ehcache.config.builders.CacheConfigurationBuilder;
import org.ehcache.config.builders.ResourcePoolsBuilder;
import org.ehcache.expiry.Duration;
import org.ehcache.expiry.Expirations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DataSecurityRestController {

  private final CacheManager cacheManager;

  public DataSecurityRestController(CacheManager cacheManager) {
    this.cacheManager = cacheManager;
  }

  /**
   * Generate key pair.
   */
  @PostMapping("/generate-keys")
  @ApiOperation(value = "Generate key pair", response = HttpStatus.class)
  public HttpStatus generateKey() throws NoSuchAlgorithmException {
    KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA");
    KeyPair pair = keyGen.generateKeyPair();
    cacheManager.removeCache("keyPairCache");
    Cache<String, KeyPair> myCache = cacheManager.createCache("keyPairCache",
        CacheConfigurationBuilder.newCacheConfigurationBuilder(String.class, KeyPair.class,
            ResourcePoolsBuilder.heap(10))
            .withExpiry(Expirations.timeToLiveExpiration(Duration.of(30, TimeUnit.MINUTES)))
            .build());
    myCache.put("pair", pair);
    return HttpStatus.OK;
  }


  /**
   * Get public key.
   */
  @GetMapping("/public-key")
  @ApiOperation(value = "get public key",
      response = String.class)
  public ResponseEntity<String> requestForPublicKey() {
    Cache<String, KeyPair> cacheValue =
        cacheManager.getCache("keyPairCache", String.class, KeyPair.class);
    KeyPair keyPair = cacheValue.get("pair");
    return new ResponseEntity<>(
        Base64.getEncoder().encodeToString(keyPair.getPublic().getEncoded()), HttpStatus.OK);
  }

  /**
   * Decrypt message.
   */
  @PostMapping("/decryption")
  @ApiOperation(value = "Decrypt message",
      response = String.class)
  public ResponseEntity<String> requestForDecryption(
      @Valid @RequestBody DecryptRequestDto decryptRequestDto)
      throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException,
      BadPaddingException, IllegalBlockSizeException {
    KeyPair keyPair =
        cacheManager.getCache("keyPairCache", String.class, KeyPair.class).get("pair");
    if (keyPair == null) {
      throw new ResourceNotFoundException("key pair has expired");
    }
    Cipher decryptCipher = Cipher.getInstance("RSA");
    decryptCipher.init(Cipher.DECRYPT_MODE, keyPair.getPrivate());
    byte[] decryptedMessageBytes =
        decryptCipher.doFinal(Base64.getDecoder().decode(decryptRequestDto.getEncryptedMessage()));
    String decryptedMessage = new String(decryptedMessageBytes, StandardCharsets.UTF_8);
    return new ResponseEntity<>(decryptedMessage, HttpStatus.OK);
  }
}
