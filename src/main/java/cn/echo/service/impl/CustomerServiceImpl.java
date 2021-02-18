package cn.echo.service.impl;

import cn.echo.dao.CustomerDao;
import cn.echo.dao.impl.CustomerDaoImpl;
import cn.echo.pojo.Customer;
import cn.echo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Package: cn.echo.service.impl
 * @Author: zhangjiangnan
 * @CreateTime: 2021/1/24 17:18
 * @Description:
 **/
@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerDao customerDao;

    /**
     * 查询-登陆
     * @param username
     * @param password
     * @return
     */
    @Override
    public Customer userLogin(String username, String password) {
//        System.out.println("Service层的参数：" + username + password);
        Customer customer = new Customer();
        customer.setUsername(username);
        customer.setPassword(password);
        Customer cus = customerDao.userLogin(customer);
//        测试逻辑处理层是否拿到数据库数据
//        System.out.println("Service层拿到数据库：" + customer);
        return cus;
    }

    /**
     * 新增-注册
     * @param cus
     * @return
     */
    @Override
    public int insertCustomer(Customer cus) {
        int i = customerDao.insertCustomer(cus);
//        测试数据是否成功录入
//        System.out.println("新增数据成功" + i);
        return i;
    }

    /**
     * 修改-修改个人信息
     * @param cus   修改用户信息对象，来自表单提交时用户需要修改的数据
     * @param yuan  源用户对象-来自登陆或注册时保存在Session中的用户对象
     * @return
     */
    @Override
    public int updateCustomer(Customer cus, Customer yuan) {
//        判断新用户对象的每一个属性值是否为空，如果为空不加入源用户对象
//        如果用户修改了某一个值时就将那个值给源用户对象
//        判断用户是否修改了密码，如果修改了将修改的数据给源对象
        if (cus.getPassword() != null && cus.getPassword() != "") {
            yuan.setPassword(cus.getPassword());
        }
//        真实姓名
        if(cus.getRealname() != null && cus.getRealname() != "") {
            yuan.setRealname(cus.getRealname());
        }
//        地址
        if(cus.getAddress() != null && cus.getAddress() != "") {
            yuan.setAddress(cus.getAddress());
        }
//        邮箱
        if (cus.getEmail() != null && cus.getEmail() != "") {
            yuan.setEmail(cus.getEmail());
        }
//        手机号
        if (cus.getMobile() != null && cus.getMobile() != "") {
            yuan.setMobile(cus.getMobile());
        }
//        将源数据给数据库访问层进行数据库操作
        return customerDao.updateCustomer(yuan);
    }

}
