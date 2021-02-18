package cn.echo.service.impl;

import cn.echo.dao.ProductcategoryDao;
import cn.echo.pojo.Productcategory;
import cn.echo.service.ProductcategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Package: cn.echo.service.impl
 * @Author: zhangjiangnan
 * @CreateTime: 2021/1/30 15:18
 * @Description:商品分类业务逻辑层实现类
 **/
@Service
public class ProductcategoryServiceImpl implements ProductcategoryService {

//    根据类型自动注入商品分类数据访问层
    @Autowired
    private ProductcategoryDao productcategoryDao;

    /**
     * 获取商品分类的全部分类
     * @return
     */
    @Override
    public List<Productcategory> selectAll() {
        List<Productcategory> productcategories = productcategoryDao.selectAll();
//        测试是否获取到
        /*for (Productcategory productcategory : productcategories) {
            System.out.println(productcategory);
        }*/
        return productcategories;
    }

}
