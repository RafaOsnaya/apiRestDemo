package com.api.ApiRest.web.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")

public class HolaController {

    @GetMapping("/saludar")
    public String saludar(){
        return "Hola Spring";
    }

}
