package com.example.demo.controller;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class EventPublisherBean {

    @Resource
    private ApplicationEventPublisher publisher;

    public void publish(String message) {
        CustomEvent event = new CustomEvent(this, message);
        publisher.publishEvent(event);
    }

}
