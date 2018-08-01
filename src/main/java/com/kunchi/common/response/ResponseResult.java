package com.kunchi.common.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "接口返回类")
public class ResponseResult<T> {
    public ResponseResult(Boolean suc, String msg, T t) {
        setSuc(suc);

        setMsg(msg);

        setObj(t);
    }

    @ApiModelProperty(value = "接口请求结果", example = "true/false")
    private Boolean suc;

    @ApiModelProperty(value = "异常时返回的错误信息", example = "")
    private String msg;

    @ApiModelProperty(value = "接口请求类", example = "")
    private T obj;


    public Boolean getSuc() { return suc; }

    public String getMsg() {
        return msg;
    }

    public T getObj() {
        return obj;
    }

    public void setSuc(Boolean suc) {
        this.suc = suc;
    }

    public void setObj(T obj) {
        this.obj = obj;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
