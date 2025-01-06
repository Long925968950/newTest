package com.example.demo.controller;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class CustomEventListener {

    @EventListener
    public void onCustomEvent(CustomEvent event) {
        System.out.println("Received custom event - " + event.getMessage());
    }

}
