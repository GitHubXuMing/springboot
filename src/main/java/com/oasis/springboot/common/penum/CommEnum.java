package com.oasis.springboot.common.penum;

public enum CommEnum {
    RESULT_SUCCESS(200,"success"),
    RESULT_UNKNOWN_ERROR(250,"unknown error"),
    RESULT_DB_ERROR(249,"database can not connect");
    private int code;
    private String msg;

    CommEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
