package com.example.demo;

import org.apache.jena.rdf.model.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/home")
public class TestingControllers {

    public Model modelExample = ModelFactory.createDefaultModel();
    @GetMapping()
    public ResponseEntity<String> home(){
        return ResponseEntity.ok("Home endpoint is working good!");
    }

}
