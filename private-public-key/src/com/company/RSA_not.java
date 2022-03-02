package com.company;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.io.UnsupportedEncodingException;
import java.security.*;
import java.util.Base64;

public class RSA_not {
    public static PrivateKey privateKey;
    public static PublicKey publicKey;

    public static void main(String[] args) throws NoSuchAlgorithmException, IllegalBlockSizeException, InvalidKeyException, BadPaddingException, NoSuchPaddingException {

        String sKeyId = "001";
        String UserName ="Plabon";
        String sEncryptedPassword= "bola jabena";
        String sBankCode = "001";
        String sExtId = "001";
        String sUserID ="01";
        String sBankName = "Jamuna";
        String sEncryptedFullPAN ="yes";
        String sAmount = "1000";
        String data =  "<PanDebitCreateRequest>"
                + "<InputParameter>"
                + "<KeyID>"+sKeyId+"</KeyID>"
                + "<UserName>"+UserName+"</UserName>"
                + "<Password>"+sEncryptedPassword+"</Password>"
                + "<BankCode>"+sBankCode+"</BankCode>"
                + "<ExtID>"+sExtId+"</ExtID>"
                + "<UserID>"+sUserID+"</UserID>"
                +"<BankName>"+sBankName+"</BankName>"
                + "<FullPAN>"+sEncryptedFullPAN+"</FullPAN>"
                + "<Amount>"+sAmount+"</Amount>"
                + "<Currency>50</Currency>"
                + "<TermName>BALIB</TermName>"
                + "<Comment>PPO</Comment>"
                + "</InputParameter>"
                + "</PanDebitCreateRequest>";

        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
        keyPairGenerator.initialize(1024);
        KeyPair keyPair = keyPairGenerator.generateKeyPair();
        privateKey = keyPair.getPrivate();
        System.out.println("Private key : "+privateKey);
        publicKey = keyPair.getPublic();
        System.out.println("publicKey key : "+publicKey);
        System.out.println(" original data "+data);
        String encyp = encrypt(data);
        System.out.println("encryp the data : "+ encyp);
        String decap = encrypt(encyp);
        System.out.println("decrypt the data : "+ decap);


    }

    public static String encrypt(String input) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
        byte[] messeageToByte = input.getBytes();
        Cipher cipher =Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE,publicKey);
        byte[] encryptedBytes = cipher.doFinal(messeageToByte);
        return Base64.getEncoder().encodeToString(encryptedBytes);
    }
    public static String decrypt(String input) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException, UnsupportedEncodingException {
        byte[] encryptedBytes = Base64.getDecoder().decode(input);
        Cipher cipher =Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(Cipher.DECRYPT_MODE,privateKey);
        byte[] decryptedMessage = cipher.doFinal(encryptedBytes);
        return new String(decryptedMessage,"UTF8");
    }
}
