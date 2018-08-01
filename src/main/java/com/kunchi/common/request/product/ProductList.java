package com.kunchi.common.request.product;

import com.kunchi.common.request.RequsetPager;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "商品分页查询参数")
public class ProductList extends RequsetPager {

    @ApiModelProperty(required = false, value = "商品编码")
    private String productCode;

    @ApiModelProperty(required = false, value = "商品名称")
    private String productName;

    @ApiModelProperty(required = false, value = "仓库编码")
    private String storeCode;

    @ApiModelProperty(required = false, value = "仓库名称")
    private String storeName;

    public String getProductCode() {
        return productCode;
    }

    public String getProductName() {
        return productName;
    }

    public String getStoreCode() {
        return storeCode;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setStoreCode(String storeCode) {
        this.storeCode = storeCode;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }
}
