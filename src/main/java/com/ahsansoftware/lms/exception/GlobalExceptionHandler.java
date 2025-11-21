package com.ahsansoftware.lms.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.ahsansoftware.lms.dto.ErrorResponseDTO;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ErrorResponseDTO> handleRuntimeException(RuntimeException ex){
        ErrorResponseDTO errorResponse = new ErrorResponseDTO(
            404,
            "Not Found",
            ex.getMessage()
        );
        return new ResponseEntity<>(errorResponse , HttpStatus.NOT_FOUND);
    }


    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponseDTO> handleValidationExceptions(MethodArgumentNotValidException ex){
        Map<String , String> errors = new HashMap<>();

        ex.getBindingResult().getFieldErrors().forEach(error -> {
            errors.put(error.getField() , error.getDefaultMessage());
        });

        ErrorResponseDTO errorResponse = new ErrorResponseDTO(
            400,
            "Validation Failed",
            errors
        );

        return new ResponseEntity<>(errorResponse , HttpStatus.BAD_REQUEST);
    }
}
