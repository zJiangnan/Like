package cn.echo.service;

import cn.echo.pojo.Productcategory;
import cn.echo.pojo.Productinfo;

import java.util.List;

/**
 * @Package: cn.echo.service
 * @Author: zhangjiangnan
 * @CreateTime: 2021/1/31 10:21
 * @Description:商品信息的业务逻辑层-接口类
 **/
public interface ProductinfoService {
    public List<Productinfo> selectinfo(int id);
    public List<Productinfo> selectProductinfoHot();
}
