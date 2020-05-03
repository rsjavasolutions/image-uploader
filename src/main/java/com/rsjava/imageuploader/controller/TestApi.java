package com.rsjava.imageuploader.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestApi {

    @GetMapping("/test1")
    public String getTest1() {
        return "Test1";
    }

    @GetMapping("/test2")
    public String getTest2() {
        return "Test2";
    }

    @GetMapping("/test3")
    public String getTest3() {
        return "Test3";
    }
}
