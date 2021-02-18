package cn.echo.service;

import cn.echo.pojo.Customer;

/**
 * @Package: cn.echo.service
 * @Author: zhangjiangnan
 * @CreateTime: 2021/1/24 17:17
 * @Description:
 **/
public interface CustomerService {
    public Customer userLogin(String username, String password);
    public int insertCustomer(Customer cus);
    public int updateCustomer(Customer cus, Customer yuan);
}
