package com.kunchi;

import com.kunchi.common.request.user.UserLogin;
import com.kunchi.common.response.ResponseResult;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import com.kunchi.dao.UserMapper;
import com.kunchi.po.User;
import io.swagger.annotations.ApiOperation;

@Api(value = "User用户服务")
@RestController
public class UserServiceImpl {

    @Autowired
    private UserMapper mapper;

    @ApiOperation(value = "用户登录接口", notes = "", produces = "application/json")
    @PostMapping("login")
    public ResponseResult<User> get(@RequestBody UserLogin user) {
        User u = mapper.login(user);

        if (u != null) {
            return new ResponseResult<User>(true, "登录成功!", u);
        } else {
            return new ResponseResult<User>(false, "登录失败", u);
        }
    }
}