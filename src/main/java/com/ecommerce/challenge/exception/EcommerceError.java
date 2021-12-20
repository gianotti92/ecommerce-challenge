package com.ecommerce.challenge.exception;

import org.springframework.http.HttpStatus;

public enum EcommerceError {
    GENERIC_ERROR("10000","Generic error", HttpStatus.BAD_REQUEST.value());

    private String code;
    private String description;
    private Integer httpCode;


    EcommerceError(String code, String description, Integer httpCode) {
        this.code = code;
        this.description = description;
        this.httpCode = httpCode;
    }

    public String getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

    public Integer getHttpCode() {
        return httpCode;
    }
}
