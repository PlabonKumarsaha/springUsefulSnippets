package com.era.privatepublic.key;

import javax.crypto.Cipher;
import java.io.UnsupportedEncodingException;
import java.security.*;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

public class RSA {

    public  PrivateKey privateKey;
    public  PublicKey publicKey;
    public static final String PRIVATE_KEY_STRING ="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";
    public static final String PUBLIC_KEY_STRING ="MIIBmTANBgkqhkiG9w0BAQEFAAOCAYYAMIIBgQKCAXgAyitW2DaRmqNmRc7H09VmSQcte1z+8WMYlCVNBvAlOFGKCM3nuQIVwlkx1Z++d1KCtLpySkM5mjEUkuoeOf2EDEMcoehzc3W0Umd69y7fF1+M4aIHYBxbUYk7O5a4miNYE7Ydlgi0AKwPi6AjU/s0SFCQDLTCQsAdPicOZhtLu+UKQMWqyp7Gj6tuFJxf8kuYDQBK4K8hz4UKxXp4Cz1TDSVAGGcAY+3L7hUDQeJ8vPCIdwEpQ1GCKW5r6Decw5N6xgQUcaXiCP6rt23K0+b38cjczhqFOGW1jZ6+1QXDIaDTGmR3AK9u6guCeCqOgTmwSHmndUgCs34iPsnU2qTH/VoSSRWIYFp+AQpDLhCxXPseaPUhuFO18EHwJTSQaLztRZDrBQou4SJNNoerYZXgz6ddzCq/KbDe4Cl/bo1o4DWu9VCzqGdlOnyjZRrt3qxrNdqblxX8lq7AP2MY58KlJQk/mmZ2M1m2/65+g5Cmuvc/HCfor6AdAgMBAAE=";
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

    public void printKeys(){
        System.err.println("Public key\n"+ encode(publicKey.getEncoded()));
        System.err.println("Private key\n"+ encode(privateKey.getEncoded()));
    }

    public String encrypt(String message) throws Exception{
        byte[] encryptedBytes =null;
        try{
        byte[] messageToBytes = message.getBytes();
        Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        cipher.init(Cipher.ENCRYPT_MODE,publicKey);
         encryptedBytes = cipher.doFinal(messageToBytes);
        return encode(encryptedBytes);}
        catch (Exception e){
            System.out.println("exception "+e);
        }
        return encode(encryptedBytes);
    }
    private String encode(byte[] data){
        return Base64.getEncoder().encodeToString(data);
    }

    public String decrypt(String encryptedMessage) throws UnsupportedEncodingException {
        byte[] decryptedMessage =null;
        try{
            byte[] encryptedBytes = decode(encryptedMessage);
            Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
            cipher.init(Cipher.DECRYPT_MODE,privateKey);
            decryptedMessage = cipher.doFinal(encryptedBytes);
        }
        catch (Exception e){
            System.out.println("excep : "+e);
        }

        return new String(decryptedMessage,"UTF8");
    }
    private byte[] decode(String data){
        return Base64.getDecoder().decode(data);
    }

    public void initFromStrings(){
        try{
            X509EncodedKeySpec keySpecPublic = new X509EncodedKeySpec(decode(PUBLIC_KEY_STRING));
            PKCS8EncodedKeySpec keySpecPrivate = new PKCS8EncodedKeySpec(decode(PRIVATE_KEY_STRING));

            KeyFactory keyFactory = KeyFactory.getInstance("RSA");

            publicKey = keyFactory.generatePublic(keySpecPublic);
            privateKey = keyFactory.generatePrivate(keySpecPrivate);
        }catch (Exception ignored){}
    }

    public static void main(String[] args)  {
        RSA rsa = new RSA();
        // rsa.init();

        rsa.initFromStrings();
        rsa.printKeys();
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

