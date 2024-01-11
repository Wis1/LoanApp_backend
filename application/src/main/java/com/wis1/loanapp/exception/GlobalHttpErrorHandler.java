package com.wis1.loanapp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalHttpErrorHandler extends ResponseEntityExceptionHandler {

        @ExceptionHandler(ClientNotFoundException.class)
        public ResponseEntity<Object> handleClientNotFoundException(ClientNotFoundException exception) {
            return  new ResponseEntity<>("Client with given id doesn't exist", HttpStatus.BAD_REQUEST);
        }

        @ExceptionHandler(CalculateNotFoundException.class)
        public ResponseEntity<Object> handleCalculateNotFoundException(CalculateNotFoundException exception) {
            return new ResponseEntity<>("Calculate with given id doesn't exist", HttpStatus.BAD_REQUEST);
        }
}
