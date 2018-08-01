package com.kunchi.dao;

import com.kunchi.common.request.product.ProductList;
import com.kunchi.po.Product;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ProductMapper {
        //新增实体
    @Insert("INSERT INTO product (productCode,ProductName,storeCode,storeName,inventory) Values (#{params.productCode},#{params.productName},#{params.storeCode},#{params.storeName},#{params.inventory})")
    Integer add(@Param("params") Product product);

    //根据id获取实体
    @Select("SELECT id,productCode,productName,storeCode,storeName,inventory,creatTime FROM product WHERE id = #{id}")
    Product getEntity(@Param("id") Long id);

    //更新实体
    @Update("Update product SET productCode=#{params.productCode},ProductName=#{params.productName},storeCode=#{params.storeCode},storeName=#{params.storeName},inventory=#{params.inventory} WHERE id = #{params.id}")
    Integer update(@Param("params") Product product);

    //根据id删除实体
    @Delete("DELETE FROM product WHERE id = #{id}")
    Integer delete(@Param("id") Long id);

    //根据id批量删除实体
    @Delete("DELETE FROM product WHERE id IN(#{ids})")
    Boolean deletebulk(@Param("ids") String ids);

    //xml配置查询
    public List<Product> getList(@Param("params") ProductList params);
}
