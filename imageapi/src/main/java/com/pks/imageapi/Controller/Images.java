package com.pks.imageapi.Controller;

import org.apache.commons.io.FileUtils;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.Base64;

@RestController
@RequestMapping
public class Images {
    @GetMapping(value = "/api/{cat}/{name}",produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
    public HttpEntity<byte[]> getImage(@PathVariable("cat")String cat,@PathVariable("name")String name, HttpServletResponse response) throws IOException {
       // String imgPath = "src/main/resources/static/cata/A.jpg";
        String imgPath = "src/main/resources/static/"+cat+"/"+name+".jpg";

        File file = new File(imgPath);
        byte[] bytes = new byte[(int) file.length()];
        try(FileInputStream fis = new FileInputStream(file)){
            fis.read(bytes);
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.IMAGE_JPEG);
           // response.setHeader("Content-Description", "attachment; filename=abc.pdf");
            response.setHeader("Content-Description", "attachment; filename=a.jpg");
            return new HttpEntity<>(bytes, headers);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    @GetMapping(value = "/api2/{cat}/{name}",produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
    public String getImage2(@PathVariable("cat")String cat,@PathVariable("name")String name) throws IOException {
        String imgPath = "src/main/resources/static/"+cat+"/"+name+".jpg";
        return imgPath;
    }



    }
