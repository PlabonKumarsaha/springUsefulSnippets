package com.era.privatepublic;

import javax.crypto.Cipher;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

public class EncryptionManager {
    private PublicKey publicKey;
    private static final String PUBLIC_KEY_STRING = "MIIBmTANBgkqhkiG9w0BAQEFAAOCAYYAMIIBgQKCAXgAyitW2DaRmqNmRc7H09VmSQcte1z+8WMYlCVNBvAlOFGKCM3nuQIVwlkx1Z++d1KCtLpySkM5mjEUkuoeOf2EDEMcoehzc3W0Umd69y7fF1+M4aIHYBxbUYk7O5a4miNYE7Ydlgi0AKwPi6AjU/s0SFCQDLTCQsAdPicOZhtLu+UKQMWqyp7Gj6tuFJxf8kuYDQBK4K8hz4UKxXp4Cz1TDSVAGGcAY+3L7hUDQeJ8vPCIdwEpQ1GCKW5r6Decw5N6xgQUcaXiCP6rt23K0+b38cjczhqFOGW1jZ6+1QXDIaDTGmR3AK9u6guCeCqOgTmwSHmndUgCs34iPsnU2qTH/VoSSRWIYFp+AQpDLhCxXPseaPUhuFO18EHwJTSQaLztRZDrBQou4SJNNoerYZXgz6ddzCq/KbDe4Cl/bo1o4DWu9VCzqGdlOnyjZRrt3qxrNdqblxX8lq7AP2MY58KlJQk/mmZ2M1m2/65+g5Cmuvc/HCfor6AdAgMBAAE=";

    public void initFromStrings(){
        try{
            X509EncodedKeySpec keySpecPublic = new X509EncodedKeySpec(decode(PUBLIC_KEY_STRING));
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            publicKey = keyFactory.generatePublic(keySpecPublic);
        }catch (Exception ignored){}
    }
    private static String encode(byte[] data) {
        return Base64.getEncoder().encodeToString(data);
    }
    private static byte[] decode(String data) {
        return Base64.getDecoder().decode(data);
    }

    public String encrypt(String message) throws Exception {
        byte[] messageToBytes = message.getBytes();
        Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        cipher.init(Cipher.ENCRYPT_MODE, publicKey);
        byte[] encryptedBytes = cipher.doFinal(messageToBytes);
        return encode(encryptedBytes);
    }
}
