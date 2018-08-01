package com.kunchi.common.response;

import io.swagger.annotations.ApiModelProperty;
import java.util.List;

public class ResponsePager<T> {
    @ApiModelProperty(value = "数据总条数")
    private Long total;

    @ApiModelProperty(value = "当前请求返回集合")
    private List<T> list;

    public List<T> getList() {
        return list;
    }

    public Long getTotal() {
        return total;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public void setTotal(Long total) {
        this.total = total;
    }
}