package cn.echo.dao;

import cn.echo.pojo.Shoppingcar;

public interface ShoppingcarDao {
    int deleteByPrimaryKey(Integer id);

    int insert(Shoppingcar record);

    int insertSelective(Shoppingcar record);

    Shoppingcar selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Shoppingcar record);

    int updateByPrimaryKey(Shoppingcar record);
}