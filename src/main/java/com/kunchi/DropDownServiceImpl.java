package com.kunchi;

import com.kunchi.common.response.ResponseResult;
import com.kunchi.common.response.dropdown.Cangku;
import com.kunchi.dao.DropDownMapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(value = "dropdown服务",description = "为各类dropdown控件获取数据源")
@RestController
public class DropDownServiceImpl {

    @Autowired
    private DropDownMapper mapper;

    @ApiOperation(value = "获取仓库列表", notes = "", produces = "application/json")
    @GetMapping("cangku")
    public ResponseResult<List<Cangku>> getCangku() {

        List<Cangku> list = mapper.getCangku();

        if (list.size() > 0) {
            return new ResponseResult<List<Cangku>>(true, "", list);
        } else {
            return new ResponseResult<List<Cangku>>(false,"", list);
        }
    }
}
