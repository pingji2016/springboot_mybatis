package org.example.springboot.exception;


public class ParamsException extends RuntimeException {
    private Integer code = 300;
    private String msg = "参数错误";

    public ParamsException(String msg) {
        this.msg = msg;
    }

    public ParamsException(String s, String msg) {
        super(s);
        this.msg = msg;
    }

    public ParamsException(String s, Throwable throwable, String msg) {
        super(s, throwable);
        this.msg = msg;
    }

    public ParamsException(Throwable throwable, String msg) {
        super(throwable);
        this.msg = msg;
    }

    public ParamsException(String s, Throwable throwable, boolean b, boolean b1, String msg) {
        super(s, throwable, b, b1);
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
