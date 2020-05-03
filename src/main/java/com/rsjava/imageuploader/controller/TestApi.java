package com.rsjava.imageuploader.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestApi {

    @GetMapping("/test1")
    public String getTest1() {
        return "Hello You are Admin or User";
    }

    @GetMapping("/test2")
    public String getTest2() {
        return "Hello User";
    }

    @GetMapping("/test3")
    public String getTest3() {
        return "Hello Admin";
    }
    @GetMapping("/test4")
    public String getTest4() {
        return "Hello World";
    }



}
