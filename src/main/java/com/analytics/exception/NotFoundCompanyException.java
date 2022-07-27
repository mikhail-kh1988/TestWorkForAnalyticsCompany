package com.analytics.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class NotFoundCompanyException extends RuntimeException{
    public NotFoundCompanyException(String message) {
        super(message);
    }
}
