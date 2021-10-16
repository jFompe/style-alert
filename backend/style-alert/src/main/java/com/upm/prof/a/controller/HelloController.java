package com.upm.prof.a.controller;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class HelloController {



    @GetMapping("/")
    String hello() {
        return "Hello World!";
    }

}
