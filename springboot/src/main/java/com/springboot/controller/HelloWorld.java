package com.springboot.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorld {

    @Value("${welcome.message}")
    String welcomeMessage;
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String hello() {
        return welcomeMessage;
    }
}
