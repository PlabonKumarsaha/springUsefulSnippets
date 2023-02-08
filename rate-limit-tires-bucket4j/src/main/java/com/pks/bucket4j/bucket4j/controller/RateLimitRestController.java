package com.pks.bucket4j.bucket4j.controller;

import com.pks.bucket4j.bucket4j.Servce.RateLimitPriceService;
import io.github.bucket4j.Bandwidth;
import io.github.bucket4j.Bucket;
import io.github.bucket4j.Refill;
import java.time.Duration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rate-limit")
public class RateLimitRestController {

  private Bucket bucket;
  private RateLimitPriceService rateLimitPriceService;

  public RateLimitRestController(RateLimitPriceService rateLimitPriceService) {
    this.rateLimitPriceService = rateLimitPriceService;
  }


  /**
   * Generate token using api
   * This gets automatically filled after each minute.
   */
  @GetMapping("/token-generate/{client-token}")
  public ResponseEntity<String>generateTokenBypackage(@PathVariable("client-token") String clientToken){
    bucket = rateLimitPriceService.getPlanServiceBucket(clientToken);
    return new ResponseEntity<String>("Generated successfully", HttpStatus.OK);
  }

  /**
   * Generate token using api
   * This gets automatically filled after each minute.
   */
  @GetMapping("/token-generate")
  public ResponseEntity<String>generateToken(){
    //initiate refill
    Refill refill = Refill.of(5, Duration.ofMinutes(1));
    //bucket
    bucket = Bucket.builder()
        .addLimit(Bandwidth.classic(5,refill))
        .build();
    return new ResponseEntity<String>("Generated successfully", HttpStatus.OK);
  }
  /**
   * Generate token using api
   */
  @GetMapping("/test")
  public ResponseEntity<String>demo(){
    if(bucket.tryConsume(1)){
      System.out.println("working okay");
      return new ResponseEntity<String>("Suceess",HttpStatus.OK);
    }
    System.out.println("token use maximised!");
    return new ResponseEntity<>("Too many hits.",HttpStatus.TOO_MANY_REQUESTS);
  }
}
