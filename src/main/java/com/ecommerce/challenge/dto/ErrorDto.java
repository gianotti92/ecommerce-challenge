package com.ecommerce.challenge.dto;

public class ErrorDto {
    private Integer httpCode;
    private String code;
    private String description;

    public ErrorDto(Integer httpCode, String code, String description) {
        this.httpCode = httpCode;
        this.code = code;
        this.description = description;
    }

    public Integer getHttpCode() {
        return httpCode;
    }

    public String getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }
}
