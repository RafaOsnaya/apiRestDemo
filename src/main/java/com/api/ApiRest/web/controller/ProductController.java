package com.api.ApiRest.web.controller;

import com.api.ApiRest.domain.Product;
import com.api.ApiRest.domain.services.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductoService service;

    /*
    Respuesta sencilla
    @GetMapping("/all")
    public List<Product> getAll(){
        return service.getAll();
    }
    */


    //Respuesta con un estatus
    @GetMapping("/all")
    public ResponseEntity<List<Product>> getAll(){
        return new ResponseEntity<>(service.getAll(), HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<Product> save(@RequestBody Product product){
        return new ResponseEntity<>(service.save(product), HttpStatus.CREATED);
    }
}