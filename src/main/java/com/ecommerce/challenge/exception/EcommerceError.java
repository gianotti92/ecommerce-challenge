package com.ecommerce.challenge.exception;

public enum EcommerceError {
    GENERIC_ERROR("10000","Generic error");

    private String code;
    private String description;


    EcommerceError(String code, String description) {
        this.code = code;
        this.description = description;
    }

    public String getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }
}
