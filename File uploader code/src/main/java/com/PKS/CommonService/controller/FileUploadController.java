package com.PKS.CommonService.controller;

import com.PKS.CommonService.Helper.FileUploadHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class FileUploadController {

    @Autowired
    private FileUploadHelper fileUploadHelper;

    @PostMapping("/upload-file")
    public ResponseEntity<String>uploadFile(@RequestParam("file") MultipartFile multipartFile){
        if(multipartFile.isEmpty()){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Must include an image");
        }
        else if(!multipartFile.getContentType().equals("image/jpeg")){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Only JPG");
        }else{
            //upload a file and save it
            System.out.println("get original name "+multipartFile.getOriginalFilename());
            System.out.println("get  Size "+multipartFile.getSize());
            try {
                boolean result = fileUploadHelper.uploadFile(multipartFile);
                if(result){
                    return ResponseEntity.ok("FIle uploaded");
                }else {
                    return ResponseEntity.ok("FIle failed to upload");
                }

            }catch (Exception e){
                e.printStackTrace();
            }
            return  ResponseEntity.ok("Working!");
        }

    }
}
