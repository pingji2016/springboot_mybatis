package org.example.springboot.exception;

import org.example.springboot.po.vo.ResultInfo;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public ResultInfo exceptionResoler(Exception e) {
        ResultInfo resultInfo = new ResultInfo();
        resultInfo.setCode(300);
        resultInfo.setMsg("异常 miao miao");

        // 具体异常处理
        if (e instanceof ParamsException) {
            ParamsException p = (ParamsException) e;
            resultInfo.setMsg(p.getMsg());
            resultInfo.setCode(p.getCode());
        }
        return resultInfo;
    }

    @ExceptionHandler(value = BindException.class)
    @ResponseBody
    public ResultInfo bindExceptionResoler(BindException e) {
        ResultInfo resultInfo = new ResultInfo();
        resultInfo.setCode(300);
        resultInfo.setMsg(e.getBindingResult().getFieldError().getDefaultMessage());

        return resultInfo;
    }
}
