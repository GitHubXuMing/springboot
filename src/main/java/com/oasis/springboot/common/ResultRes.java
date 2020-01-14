package com.oasis.springboot.common;

import com.oasis.springboot.common.penum.CommEnum;

public class ResultRes<T> {
    private int code;
    private String msg;
    private T data;

    //使用静态方法提供工具方法
    public static<T> ResultRes<T> success(T data){
        return new ResultRes<T>(CommEnum.RESULT_SUCCESS.getCode(),CommEnum.RESULT_SUCCESS.getMsg(),data);
    }
    public static ResultRes success(){
        return success(null);
    }
    public static ResultRes error(CommEnum ce){
        return new ResultRes(ce.getCode(),ce.getMsg(),null);
    }
    public static ResultRes error(int code,String msg){
        return new ResultRes(code,msg,null);
    }


    private ResultRes(int code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public T getData() {
        return data;
    }
}
