package com.analytics.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ExceptionHandlerController extends ResponseEntityExceptionHandler {

    @Data
    @AllArgsConstructor
    private static class ExceptionMessage{
        private String error;
    }

    @ExceptionHandler(NotFoundCompanyException.class)
    protected ResponseEntity<ExceptionMessage> handleNotFoundCompanyException(){
        return new ResponseEntity<ExceptionMessage>(new ExceptionMessage("Company not found!"), HttpStatus.NOT_FOUND);
    }
}
