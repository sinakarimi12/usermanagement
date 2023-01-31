package com.kia.usermanegment.controller;


import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

@RestController
public class fileManageController {

    @RequestMapping(value = "/upload",method = RequestMethod.GET,consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public String FileUpload(@RequestParam("file")MultipartFile file) throws IOException {
        File convertFile = new File("/desktop/myFile"+file.getOriginalFilename());
        convertFile.createNewFile();
        FileOutputStream fout =new FileOutputStream(convertFile);
        fout.write(file.getBytes());
        fout.close();
        return "file is upload successfully";
    }

}
