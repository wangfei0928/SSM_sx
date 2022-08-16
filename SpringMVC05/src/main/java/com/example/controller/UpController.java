package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

@Controller
public class UpController {

    @RequestMapping("/up")
    public String upUp(){
        return "upFile";
    }

    @RequestMapping("/up01")
    public String up01(MultipartFile ff, HttpServletRequest request) throws IOException {
        String path = request.getServletContext().getRealPath("/img");
        String fPath = path + "/" + ff.getOriginalFilename();
        System.out.println(fPath);
        ff.transferTo(new File(fPath));
        return null;
    }

}
