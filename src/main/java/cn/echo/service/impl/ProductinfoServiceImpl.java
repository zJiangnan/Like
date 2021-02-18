package cn.echo.service.impl;

import cn.echo.dao.ProductinfoDao;
import cn.echo.pojo.Productcategory;
import cn.echo.pojo.Productinfo;
import cn.echo.service.ProductinfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Package: cn.echo.service.impl
 * @Author: zhangjiangnan
 * @CreateTime: 2021/1/31 10:22
 * @Description:商品信息的业务逻辑层-实现类
 **/
@Service
public class ProductinfoServiceImpl implements ProductinfoService {

    @Autowired
    private ProductinfoDao productinfoDao;

    /**
     * 根据分类ID查询这个分类的所有商品
     * @return
     */
    @Override
    public List<Productinfo> selectinfo(int id) {
        return productinfoDao.selectProductinfo(id);
    }

    /**
     * 查询推荐商品信息
     * @return
     */
    @Override
    public List<Productinfo> selectProductinfoHot() {
//        查看是否进入此层
        System.out.println("进入service层：");
        return productinfoDao.selectProductinfoHots();
    }
}
