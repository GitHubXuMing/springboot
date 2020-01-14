package com.oasis.springboot.aop;

import com.oasis.springboot.common.ResultRes;
import com.oasis.springboot.common.ex.ProductException;
import com.oasis.springboot.common.penum.CommEnum;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ActionExHandler {

    @ExceptionHandler(value = Exception.class)
    public ResultRes exHandler(Exception e){
        if(e instanceof ProductException){
            ProductException pe = (ProductException) e;
            return ResultRes.error(pe.getCode(),pe.getMessage());
        }
        return ResultRes.error(CommEnum.RESULT_UNKNOWN_ERROR);
    }
}
