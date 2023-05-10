package com.sda.demo.exception;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Set;
import java.util.stream.Collectors;

@RestControllerAdvice
public class ExceptionController {

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<Object> handleValidationException(ConstraintViolationException exception){
        return new ResponseEntity<>(getConstraintViolation(exception), HttpStatus.BAD_REQUEST);
    }

    private String getConstraintViolation(ConstraintViolationException exception) {
//        Set<ConstraintViolation<?>> constraintViolations = exception.getConstraintViolations();
//        StringBuilder stringBuilder = new StringBuilder();
//        for (ConstraintViolation<?> constraintViolation : constraintViolations) {
//            stringBuilder.append(constraintViolation.getMessage());
//            stringBuilder.append("\n");
//        }
//        return stringBuilder.toString();

        return exception.getConstraintViolations()
                .stream() // stream of ConstraintViolation objects
                .map(constraintViolation -> constraintViolation.getMessage())
                .collect(Collectors.joining("\n"));
    }
}
