package edu.iu.p565.handler;

import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice

public class GlobalExceptionHandler {
    @ExceptionHandler(IllegalStateException.class)
    public ResponseEntity<?> handleException(IllegalStateException exception){
        return ResponseEntity.badRequest().body(exception.getMessage()); 
    }
    

@ExceptionHandler(MethodArgumentNotValidException.class)
public ResponseEntity<?> handleException(MethodArgumentNotValidException exception){
    String errorMessages=exception.getBindingResult().getFieldError()
    .stream().map(x->x.getDefaultMessage())
    .collect(Collectors.joining(","));
    return ResponseEntity.badRequest.body(errorMessages);
}

}
