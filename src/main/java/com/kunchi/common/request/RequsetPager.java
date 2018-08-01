package com.kunchi.common.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Min;
import java.io.Serializable;
import java.util.Date;

@ApiModel(description="分页方法公共参数")
public class RequsetPager implements Serializable {

    @ApiModelProperty(required = false,value = "查询关键字")
    private String keyWord;

    @Min(value = 1,message = "起始页必须大于0")
    @ApiModelProperty(required = true,value = "分页Index")
    private Integer index;

    @Min(value = 1,message = "每页容量必须大于0")
    @ApiModelProperty(required = true,value = "分页页容")
    private Integer size;

    @ApiModelProperty(required = false,value = "查询起始时间")
    private Date startDate;

    @ApiModelProperty(required = false,value = "查询结束时间")
    private Date endDate;

    public String getKeyWord() {
        return keyWord;
    }

    public Integer getIndex() {
        return index;
    }

    public Integer getSize() {
        return size;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setKeyWord(String keyWord) {
        this.keyWord = keyWord;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
}

