package com.zerobase.fastlms;

import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;

@CrossOrigin("*")
@RestController
public class ImageController {
    @GetMapping("/showImage")
    public ResponseEntity<Resource> showImage(
            @RequestParam Map<String, String> param
    ){
        String imageRoot = "";
        imageRoot = imageRoot + String.valueOf(param.get("name"));

        Resource resource = new FileSystemResource(imageRoot);

        if(!resource.exists()){
            return new ResponseEntity<Resource>(HttpStatus.NOT_FOUND);
        }

        HttpHeaders header = new HttpHeaders();

        Path filePath = null;

        try{
            filePath = Paths.get(imageRoot);

            header.add("Content-Type", Files.probeContentType(filePath));
        } catch (Exception e){
            e.printStackTrace();
        }

        return new ResponseEntity<Resource>(resource, header, HttpStatus.OK);
    }
}
