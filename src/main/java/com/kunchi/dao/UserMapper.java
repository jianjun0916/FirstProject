package com.kunchi.dao;
import com.kunchi.common.request.user.UserLogin;
import com.kunchi.po.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {

    //登录接口
    @Select("SELECT ID, UserName FROM User WHERE UserName = #{user.userName} AND Pwd = #{user.pwd}")
    User login(@Param("user") UserLogin params);
}