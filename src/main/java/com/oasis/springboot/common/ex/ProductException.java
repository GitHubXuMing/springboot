package com.oasis.springboot.common.ex;

import com.oasis.springboot.common.penum.ProductEnum;

public class ProductException extends RuntimeException {
    private int code;
    public ProductException(ProductEnum pe){
        super(pe.getMsg());
        this.code = pe.getCode();
    }
    public int getCode() {
        return code;
    }

    @Override
    public String toString() {
        return "ProductException{" +
                "code=" + code +
                '}';
    }
}
