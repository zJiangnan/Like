package cn.echo.service;

import cn.echo.pojo.Productcategory;

import java.util.List;

/**
 * @Package: cn.echo.service
 * @Author: zhangjiangnan
 * @CreateTime: 2021/1/30 15:17
 * @Description:商品分类业务逻辑层接口类
 **/
public interface ProductcategoryService {
    public List<Productcategory> selectAll();
}
