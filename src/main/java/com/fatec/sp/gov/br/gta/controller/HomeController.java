package com.fatec.sp.gov.br.gta.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@CrossOrigin
public class HomeController {
    @GetMapping
    public String welcome(){
        return "Hello World";
    }
}