package com.dougllas.dsstore.exceptions.handlers;

import com.dougllas.dsstore.exceptions.RegraValidacaoException;
import com.dougllas.dsstore.exceptions.ResourceNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;

@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(RegraValidacaoException.class)
    public ResponseEntity<ApiErrors> regraValidacao(RegraValidacaoException e, HttpServletRequest request){

        HttpStatus httpStatus = HttpStatus.UNPROCESSABLE_CONTENT;
        ApiErrors error = new ApiErrors(Instant.now(), httpStatus.value(), e.getMessage(), request.getRequestURI());

        return ResponseEntity.status(httpStatus).body(error);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiErrors> regraValidacao(ResourceNotFoundException e, HttpServletRequest request){

        HttpStatus httpStatus = HttpStatus.NOT_FOUND;
        ApiErrors error = new ApiErrors(Instant.now(), httpStatus.value(), e.getMessage(), request.getRequestURI());

        return ResponseEntity.status(httpStatus).body(error);
    }
}
