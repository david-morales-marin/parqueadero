package com.example.parqueadero.excepciones;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.NoSuchElementException;

@ControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(value = NoSuchElementException.class )
    public ResponseEntity<String> handlerNotValueException(){
        System.out.println("controle la exception. ");
        return ResponseEntity.ok("Error controlador del usuario");
    }

}
