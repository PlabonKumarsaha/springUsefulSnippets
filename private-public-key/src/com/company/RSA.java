package com.company;

import javax.crypto.Cipher;
import java.security.*;
import java.util.Base64;

public class RSA {

    public  PrivateKey privateKey;
    public  PublicKey publicKey;

    public RSA() {

    }

    public void init()  {
        try {
            KeyPairGenerator generator = KeyPairGenerator.getInstance("RSA");
            generator.initialize(3000);
            KeyPair pair = generator.generateKeyPair();
            privateKey = pair.getPrivate();
            publicKey = pair.getPublic();
        } catch (Exception ignored) {
        }

    }

    public String encrypt(String message) throws Exception{
        byte[] messageToBytes = message.getBytes();
        Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        cipher.init(Cipher.ENCRYPT_MODE,publicKey);
        byte[] encryptedBytes = cipher.doFinal(messageToBytes);
        return encode(encryptedBytes);
    }
    private String encode(byte[] data){
        return Base64.getEncoder().encodeToString(data);
    }

    public String decrypt(String encryptedMessage) throws Exception{
        byte[] encryptedBytes = decode(encryptedMessage);
        Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        cipher.init(Cipher.DECRYPT_MODE,privateKey);
        byte[] decryptedMessage = cipher.doFinal(encryptedBytes);
        return new String(decryptedMessage,"UTF8");
    }
    private byte[] decode(String data){
        return Base64.getDecoder().decode(data);
    }

    public static void main(String[] args)  {
        RSA rsa = new RSA();
        rsa.init();
        try{
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
            System.out.println("data : "+data);


            String encryptedMessage = rsa.encrypt(data);
            String decryptedMessage = rsa.decrypt(encryptedMessage);

            System.err.println("Encrypted:\n"+encryptedMessage);
            System.out.println("Decrypted:\n"+decryptedMessage);
        }catch (Exception ingored){}
    }
}
