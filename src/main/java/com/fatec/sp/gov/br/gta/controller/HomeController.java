package com.fatec.sp.gov.br.gta.controller;

import org.springframework.web.bind.annotation.*;

@RestController
public class HomeController {
    @GetMapping
    public String welcome(){
        return "Hello World";
    }
}