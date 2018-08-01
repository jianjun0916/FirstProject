package com.kunchi.dao;

import com.kunchi.common.response.dropdown.Cangku;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface DropDownMapper {
    //根据仓库列表
    @Select("SELECT DISTINCT storeCode,storeName FROM product ORDER BY storeCode ASC")
    List<Cangku> getCangku();
}
