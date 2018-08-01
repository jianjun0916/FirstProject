package com.kunchi.common.request.user;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@ApiModel(description="登录方法参数")
public class UserLogin implements Serializable
{
    @NotEmpty(message = "登录名不能为空")
    @ApiModelProperty(required = true,value = "登录名")
    private String userName;

    @NotEmpty(message = "密码不能为空")
    @ApiModelProperty(required = true,value = "密码")
    private String pwd;

    public String getUserName() {
        return userName;
    }

    public String getPwd() {
        return pwd;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
}
