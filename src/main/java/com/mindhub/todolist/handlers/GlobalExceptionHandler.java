package com.mindhub.todolist.handlers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(UserNotFound.class)
    public ResponseEntity<String> userNotFoundExceptionHandler( UserNotFound userNotFound ){
        return ResponseEntity.badRequest().body(userNotFound.getMessage());
    }
}
