package com.company;


import java.security.*;
import javax.crypto.*;


public class Main {
static String alg = "AES";
static Key key;
static Cipher ciper;
    public static void main(String[] args) throws NoSuchAlgorithmException, NoSuchPaddingException, BadPaddingException, InvalidKeyException, IllegalBlockSizeException {
	// write your code here
        String sKeyId = "001";
        String UserName ="Plabon";
        String sEncryptedPassword= "bola jabena";
        String sBankCode = "001";
        String sExtId = "001";
        String sUserID ="01";
        String sBankName = "Jamuna";
        String sEncryptedFullPAN ="yes";
        String sAmount = "1000";
        //key = KeyGenerator.getInstance(alg).generateKey();
        key = KeyGenerator.getInstance(alg).generateKey();
        ciper =Cipher.getInstance(alg);
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
        System.out.println("Original input : "+data);
        byte[] encryptedBytes = encryptData(data);
        System.out.println("The encrypted Text : "+encryptedBytes);


        System.out.println("The decrypted Text : "+decrypt(encryptedBytes));


    }

    public static byte[] encryptData(String input) throws InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
        ciper.init(Cipher.ENCRYPT_MODE,key);
        byte[] ibytes = input.getBytes();
        return ciper.doFinal(ibytes);
    }

    private static String decrypt(byte[] input) throws InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
        ciper.init(Cipher.DECRYPT_MODE,key);
        byte[] recover = ciper.doFinal(input);
        String originaltext = new String(recover);
        return originaltext;
    }


}
