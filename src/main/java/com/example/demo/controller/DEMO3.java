package com.example.demo.controller;

import com.example.demo.dto.SingletonStudent;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DEMO3 {

    @GetMapping("Hello")
    public String hello() {
        return "Hello World";
    }


    public static void main(String[] args) {
        //双重检查的线程安全单例
        SingletonStudent instance = SingletonStudent.getInstance();
        System.out.println(instance);
    }

}
