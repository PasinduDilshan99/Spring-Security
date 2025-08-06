package com.example.spring_security.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/v0/test")
public class TestController {

    private static final Logger logger = LoggerFactory.getLogger(TestController.class);

    @GetMapping(path = "/hello")
    public String hello() {
        logger.info("Hello from TestController");
        return "Hello from TestController";
    }

    @GetMapping(path = "/greet")
    public String greet(HttpServletRequest httpServletRequest) {
        logger.info("Greet from TestController");
        logger.info("session : "+ httpServletRequest.getSession().toString());
        return "Session Key : " + httpServletRequest.getSession().getId();
    }

}
