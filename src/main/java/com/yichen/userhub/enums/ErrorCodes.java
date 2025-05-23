package com.yichen.userhub.enums;

import com.yichen.userhub.exception.ErrorCodeDict;

public enum ErrorCodes implements ErrorCodeDict {
    EOUTGW001("001", "系統繁忙，請稍後再試");

    public static final String SUCCESS = "0000";
    public static final String MODULE_ID = "1613910";
    private String code;
    private String message;

    private ErrorCodes(String code, String message) {
        this.code = "1613910" + code;
        this.message = message;
    }

    public String getCode() {
        return this.code;
    }

    public String getMessage() {
        return this.message;
    }
}
