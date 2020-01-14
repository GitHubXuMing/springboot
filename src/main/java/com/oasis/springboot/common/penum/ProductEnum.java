package com.oasis.springboot.common.penum;

public enum ProductEnum {
    PROCUT_NOT_FOUND(101,"product not found"),
    TOO_EXPENSIVE(102,"too expensive"),
    TOO_CHEAP(103,"too cheap");
    private int code;
    private String msg;

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    ProductEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
