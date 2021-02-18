package cn.echo.dao;

import cn.echo.pojo.Productcategory;

import java.util.List;

public interface ProductcategoryDao {
    public List<Productcategory> selectAll();
}