package cn.echo.dao;

import cn.echo.pojo.Customer;

public interface CustomerDao {
    public Customer userLogin(Customer cus);
    public int insertCustomer(Customer cus);
    public int updateCustomer(Customer cus);
}