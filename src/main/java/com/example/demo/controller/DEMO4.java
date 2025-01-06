package com.example.demo.controller;

import com.example.demo.dto.Student;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DEMO4 {


    public static void main(String[] args) {
        CustomEvent customEvent = new CustomEvent(new Student("xiaoming",60,60,60),"111");
        System.out.println(customEvent);
    }

}
