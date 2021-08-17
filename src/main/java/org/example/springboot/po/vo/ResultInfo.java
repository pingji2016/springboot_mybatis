package org.example.springboot.po.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "返回结果类")
public class ResultInfo {
    @ApiModelProperty(value = "code", example = "200")
    private Integer code = 200;

    @ApiModelProperty(value = "msg")
    private String msg = "成功";

    @ApiModelProperty(value = "obj")
    private Object obj;

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

    public Object getObj() {
        return obj;
    }

    public void setObj(Object obj) {
        this.obj = obj;
    }
}
