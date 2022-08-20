package com.digitalinnovation.parking.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/") //não necessário quando é / mas interessante para deixar explícito
public class HelloController {

    @GetMapping
    public String hello() {
        return "Hello DIO!";
    }

}
