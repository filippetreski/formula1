package com.example.demo.controllers;

import org.apache.http.HttpStatus;
import org.apache.jena.shared.NotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ErrorHandler {

    @ExceptionHandler(value = {NotFoundException.class})
    protected ResponseEntity<String> handleNotFoundExceptions(NotFoundException ex) {
        return ResponseEntity.status(HttpStatus.SC_NOT_FOUND).body(ex.getMessage());
    }

    @ExceptionHandler(value = {NullPointerException.class})
    protected ResponseEntity<String> handleNotFoundExceptions(NullPointerException ex) {
        return ResponseEntity.status(HttpStatus.SC_NOT_FOUND).body(ex.getMessage());
    }
}
