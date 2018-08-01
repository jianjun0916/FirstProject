package com.kunchi.common.response.dropdown;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "仓库列表")
public class Cangku {
    @ApiModelProperty(required = false, value = "仓库编码")
    private String storeCode;

    @ApiModelProperty(required = false, value = "仓库名称")
    private String storeName;

    public String getStoreCode() {
        return storeCode;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreCode(String storeCode) {
        this.storeCode = storeCode;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }
}
