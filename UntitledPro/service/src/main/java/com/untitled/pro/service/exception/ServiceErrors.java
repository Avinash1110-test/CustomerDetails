package com.untitled.pro.service.exception;

import lombok.ToString;

@ToString
public enum ServiceErrors {

    INSUFFICIENT_FUNDS("ERR-100", "Insufficient funds in your account."),
    WRONG_PASSWORD("ERR-101", "Your password is incorrect."),
    VALID_AMOUNT("ERR-102", "Please enter valid amount (decimals not allowed)"),
    CUSTOMER_ID_NOT_EXIST("ERR-103", "Customer Id does not exist. Please enter valid Id");

    public final String CODE;
    public final String KEY;

    ServiceErrors(String code, String key) {
        this.CODE = code;
        this.KEY = key;
    }

}
