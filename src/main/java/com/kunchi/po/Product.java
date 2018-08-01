package com.kunchi.po;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import net.sf.jsqlparser.expression.DateTimeLiteralExpression;

import javax.validation.constraints.Max;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDateTime;

@ApiModel(value = "商品对象",description = "包括商品及所属仓库的信息")
public class Product implements Serializable {

    @ApiModelProperty(required = true,value = "主键ID",example = "1")
    private Integer id;

    @Size(max = 4,min = 1,message = "商品编码的长度为1~4位")
    @ApiModelProperty(required = true,value = "商品编码",example = "0001")
    private String productCode;

    @Size(max = 50,min = 1,message = "商品名称的长度为1~50位")
    @ApiModelProperty(required = true,value = "商品名称",example = "商品A")
    private String productName;

    @Size(max = 4,min = 1,message = "仓库编码的长度为1~4位")
    @ApiModelProperty(required = true,value = "仓库编码",example = "0001")
    private String storeCode;

    @Size(max = 50,min = 1,message = "仓库名称的长度为1~50位")
    @ApiModelProperty(required = true,value = "仓库名称",example = "北京仓库")
    private String storeName;

    @Max(value = 10000,message = "已超出库存范围")
    @ApiModelProperty(required = true,value = "库存",example = "1")
    private Integer inventory;

    @ApiModelProperty(required = true,value = "创建时间",example = "2018-07-23 06:05:17")
    private LocalDateTime creatTime;

    public Integer getId() {
        return id;
    }

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

    public Integer getInventory() { return inventory; }

    public LocalDateTime getCreateTime() { return creatTime; }

    public void setId(Integer id) {
        this.id = id;
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

    public void setInventory(Integer inventory) { this.inventory = inventory; }

    public void setCreateTime(LocalDateTime createTime) { this.creatTime = creatTime; }

    @Override
    public String toString() {
        return getId() + "," + getProductCode() + "," + getProductName() + "," + getStoreCode() + "," + getStoreName() + "," + getInventory() + "," + getCreateTime();
    }
}

