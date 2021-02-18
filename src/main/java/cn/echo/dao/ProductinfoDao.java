package cn.echo.dao;

import cn.echo.pojo.Productinfo;

import java.util.List;

public interface ProductinfoDao {
    public List<Productinfo> selectProductinfo(int id);
    public List<Productinfo> selectProductinfoHots();
}