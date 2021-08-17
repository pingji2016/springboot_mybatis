package org.example.springboot.po;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;

@ApiModel(description = "用户实体类")
public class User {
    @ApiModelProperty(value = "id", example = "0")
    private Integer id;

    @ApiModelProperty(value = "userName")
    @NotBlank(message = "用户名不能为空")
    private String userName;

    @ApiModelProperty(value = "userName")
    @NotBlank(message = "密码不能为空")
    @Length(min = 4,max =10, message = "密码不服务")
    private String userPwd;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }
}
