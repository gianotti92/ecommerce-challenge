package com.ecommerce.challenge.exception;

public class EcommerceException extends RuntimeException{
    private EcommerceError ecommerceError;

    public EcommerceException(String message, EcommerceError ecommerceError) {
        super(message);
        this.ecommerceError = ecommerceError;
    }

    public EcommerceError getEcommerceError() {
        return ecommerceError;
    }
}
