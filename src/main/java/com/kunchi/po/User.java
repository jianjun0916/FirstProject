package com.kunchi.po;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;

@ApiModel(value="用户对象",description="包括用户名,密码等信息")
public class User implements Serializable {

    @ApiModelProperty(required = false, value = "自增ID", example = "1")
    private Integer ID;

    @ApiModelProperty(required = true, value = "用户名称", example = "admin")
    private String UserName;

    @ApiModelProperty(required = true, value = "密码", example = "123")
    private String Pwd;

    public Integer getID() {
        return ID;
    }

    public String getUserName() {
        return UserName;
    }

    public String getPwd() {
        return Pwd;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public void setUserName(String userName) {
        this.UserName = userName;
    }

    public void setPwd(String pwd) {
        this.Pwd = pwd;
    }

    @Override
    public String toString() {
        return getID() + "," + getUserName() + "," + getPwd();
    }
}
