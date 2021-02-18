package cn.echo.dao.impl;

import cn.echo.dao.ProductinfoDao;
import cn.echo.pojo.Productinfo;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Package: cn.echo.dao.impl
 * @Author: zhangjiangnan
 * @CreateTime: 2021/1/30 19:25
 * @Description:商品的数据访问层实现类
 **/
@Repository
public class ProductinfoDaoImpl implements ProductinfoDao {

    @Autowired
    private SqlSessionTemplate sqlSessionTemplate;

    /**
     * 根据商品分类ID查询这个分类的所有商品
     * @param id    分类的ID
     * @return
     */
    @Override
    public List<Productinfo> selectProductinfo(int id) {
        return sqlSessionTemplate.getMapper(ProductinfoDao.class).selectProductinfo(id);
    }

    /**
     * 查询推荐商品信息
     * @return
     */
    @Override
    public List<Productinfo> selectProductinfoHots() {
//        查看是否进入此层
        System.out.println("进入dao层");
        return sqlSessionTemplate.getMapper(ProductinfoDao.class).selectProductinfoHots();
    }
}
