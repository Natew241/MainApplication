package com.joggingthoughts.controller;

import com.joggingthoughts.service.MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    @Autowired
    private MainService mainService;

    @GetMapping("/home")
    public String returnMessage(){
       return mainService.returnMessage();
    }
}
