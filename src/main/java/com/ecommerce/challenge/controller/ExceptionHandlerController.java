package com.ecommerce.challenge.controller;

import com.ecommerce.challenge.dto.ErrorDto;
import com.ecommerce.challenge.exception.EcommerceException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ExceptionHandlerController extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = EcommerceException.class)
    public ResponseEntity<ErrorDto> handleError(EcommerceException ecommerceException) {
        var ecommerceError = ecommerceException.getEcommerceError();

        return ResponseEntity.status(ecommerceError.getHttpCode())
        .body(new ErrorDto(ecommerceError.getHttpCode(), ecommerceError.getCode(), ecommerceError.getDescription()));
    }
}
