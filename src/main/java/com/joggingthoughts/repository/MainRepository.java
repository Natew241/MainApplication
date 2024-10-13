package com.joggingthoughts.repository;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Component
public class MainRepository {
    public String getHelloMessage(){
        return "Hello World";
    }
}
