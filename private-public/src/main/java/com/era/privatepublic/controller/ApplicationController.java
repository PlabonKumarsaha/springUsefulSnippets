package com.era.privatepublic.controller;

import com.era.privatepublic.EncryptionManager;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApplicationController {

    @GetMapping("/getSecretMessage")
    public String getMessage() throws Exception {
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
        EncryptionManager encryptionManager = new EncryptionManager();
        encryptionManager.initFromStrings();
        String data2 = "hello";
        String results = encryptionManager.encrypt(data2);
        try{
            return encryptionManager.encrypt(data);
        }catch (Exception e){

        }
    return null;
    }
}
