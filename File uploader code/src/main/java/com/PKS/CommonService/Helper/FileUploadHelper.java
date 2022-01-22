package com.PKS.CommonService.Helper;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileOutputStream;
import java.io.InputStream;

@Component
public class FileUploadHelper {
    public final String UPLOAD_DIR = "C:\\Users\\pkuma\\Downloads\\CommonService\\src\\main\\resources\\static\\image";

    public boolean uploadFile(MultipartFile mf){
        boolean f = false;
        try{
            InputStream is = mf.getInputStream();
            byte[] data = new byte[is.available()];
            is.read(data);
            //write
            FileOutputStream fos = new FileOutputStream(UPLOAD_DIR+"\\"+mf.getOriginalFilename());
            fos.write(data);
            fos.flush();
            fos.close();
            f= true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return f;
    }
}
