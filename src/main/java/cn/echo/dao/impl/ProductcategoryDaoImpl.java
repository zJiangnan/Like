package cn.echo.dao.impl;

import cn.echo.dao.ProductcategoryDao;
import cn.echo.pojo.Productcategory;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Package: cn.echo.dao.impl
 * @Author: zhangjiangnan
 * @CreateTime: 2021/1/30 15:20
 * @Description:商品分类数据层实现类
 **/
@Repository
public class ProductcategoryDaoImpl implements ProductcategoryDao {

    @Autowired
    private SqlSessionTemplate sqlSessionTemplate;

    /**
     * 查询商品全部分类
     * @return
     */
    @Override
    public List<Productcategory> selectAll() {
        return sqlSessionTemplate.getMapper(ProductcategoryDao.class).selectAll();
    }
}
