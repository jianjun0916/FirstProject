package com.kunchi;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.kunchi.common.request.product.ProductList;
import com.kunchi.common.request.user.UserLogin;
import com.kunchi.common.response.ResponsePager;
import com.kunchi.common.response.ResponseResult;
import com.kunchi.dao.ProductMapper;
import com.kunchi.dao.UserMapper;
import com.kunchi.po.Product;
import com.kunchi.po.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.security.PublicKey;
import java.util.List;

@Api(value = "商品服务")
@RestController
public class ProductServiceImpl {
    @Autowired
    private ProductMapper mapper;

    @ApiOperation(value = "获取商品", notes = "", produces = "application/json")
    @GetMapping("product/get/{id}")
    public ResponseResult<Product> getEntity(@ApiParam(value = "商品id" ,required = true, type = "Long") @PathVariable("id") Long id) {

        Product u = mapper.getEntity(id);

        if (u != null) {
            return new ResponseResult<Product>(true, "true", u);
        } else {
            return new ResponseResult<Product>(false, "false", u);
        }
    }

    @ApiOperation(value ="获取商品集合", notes = "", produces = "application/json")
    @GetMapping("product/getlist")
    public ResponseResult<ResponsePager<Product>> getList(ProductList params) {
        Page<Long> page=PageHelper.startPage(params.getIndex(),params.getSize(),true);

        PageHelper.orderBy("creatTime desc");

        ResponsePager<Product> res=new ResponsePager<>();

        res.setList(mapper.getList(params));

        res.setTotal(page.getTotal());

        return new ResponseResult<>(true,"ok",res);
    }

    @ApiOperation(value = "创建商品", notes = "", produces = "application/json")
    @PostMapping("product/add")
    public ResponseResult<Integer> add(@Valid @RequestBody Product entity, BindingResult bindingResult) {

        int res = mapper.add(entity);

        if (res == 0) {
            return new ResponseResult<Integer>(true, "", res);
        } else {
            return new ResponseResult<Integer>(true,"", res);
        }
    }

    @ApiOperation(value = "修改商品", notes = "", produces = "application/json")
    @PutMapping("product/update")
    public ResponseResult<Integer> update(@RequestBody Product entity) {

        int res = mapper.update(entity);

        if (res == 0) {
            return new ResponseResult<Integer>(true, "", res);
        } else {
            return new ResponseResult<Integer>(true,"", res);
        }
    }

    @ApiOperation(value = "删除商品", notes = "", produces = "application/json")
    @DeleteMapping("product/delete/{id}")
    public ResponseResult<Integer> delete(@ApiParam(value = "商品id" ,required = true, type = "Long") @PathVariable("id") Long id) {

        int u = mapper.delete(id);

        if (u >0) {
            return new ResponseResult<Integer>(true, "true", u);
        } else {
            return new ResponseResult<Integer>(false, "false", u);
        }
    }
}
