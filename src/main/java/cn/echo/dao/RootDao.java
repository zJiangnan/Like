package cn.echo.dao;

import cn.echo.pojo.Root;

public interface RootDao {
    int deleteByPrimaryKey(Integer id);

    int insert(Root record);

    int insertSelective(Root record);

    Root selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Root record);

    int updateByPrimaryKey(Root record);
}