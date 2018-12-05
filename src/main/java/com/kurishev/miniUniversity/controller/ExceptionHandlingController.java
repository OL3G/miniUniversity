package com.kurishev.miniUniversity.controller;

import lombok.extern.slf4j.Slf4j;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@Slf4j
@ControllerAdvice
public class ExceptionHandlingController {
    @ExceptionHandler({ ConstraintViolationException.class })
    public ResponseEntity<Object> handleConstraintViolation(ConstraintViolationException ex) {
        String error = "ConstrainViolationException";
        return new ResponseEntity<>(
                error, new HttpHeaders(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({NullPointerException.class })
    public ResponseEntity<Object> handleNullPointerException(NullPointerException ex) {
        return new ResponseEntity<>(
               "Entity not found", new HttpHeaders(), HttpStatus.BAD_REQUEST);
    }
}
