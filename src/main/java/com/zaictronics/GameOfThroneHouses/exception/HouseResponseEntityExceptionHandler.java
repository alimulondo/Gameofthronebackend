package com.zaictronics.GameOfThroneHouses.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class HouseResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = RuntimeException.class)
     protected ResponseEntity<Object> exceptionHandler(RuntimeException ex, WebRequest req){
         String message = "No such house available";

         return handleExceptionInternal(ex, message, new HttpHeaders(), HttpStatus.CONFLICT, req);

     }
}
