package com.example.miitnavigation.exception;

import com.example.miitnavigation.dto.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<Object> handleResourceNotFoundException(ResourceNotFoundException ex) {
        ApiResponse apiResponse = new ApiResponse(HttpStatus.NOT_FOUND, ex.getMessage(), null);
        return new ResponseEntity<>(apiResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(AuditoriumException.class)
    public ResponseEntity<Object> handleAuditoriumException(AuditoriumException ex) {
        ApiResponse apiResponse = new ApiResponse(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage(), null);
        return new ResponseEntity<>(apiResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(GroupException.class)
    public ResponseEntity<Object> handleGroupException(GroupException ex) {
        ApiResponse apiResponse = new ApiResponse(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage(), null);
        return new ResponseEntity<>(apiResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(SubjectException.class)
    public ResponseEntity<Object> handleSubjectException(SubjectException ex) {
        ApiResponse apiResponse = new ApiResponse(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage(), null);
        return new ResponseEntity<>(apiResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
