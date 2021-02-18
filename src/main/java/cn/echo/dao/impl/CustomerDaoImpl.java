package cn.echo.dao.impl;

import cn.echo.dao.CustomerDao;
import cn.echo.pojo.Customer;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @Package: cn.echo.dao.impl
 * @Author: zhangjiangnan
 * @CreateTime: 2021/1/24 17:19
 * @Description:
 **/
@Repository
public class CustomerDaoImpl implements CustomerDao {

    @Autowired
    private SqlSessionTemplate sqlSessionTemplate;

    /**
     * 根据用户信息查询
     * @param cus
     * @return
     */
    @Override
    public Customer userLogin(Customer cus) {
//        Customer customer = sqlSessionTemplate.selectOne("customerDao.userLogin");
        CustomerDao mapper = sqlSessionTemplate.getMapper(CustomerDao.class);
        Customer customer = mapper.userLogin(cus);
//        测试dao层是否拿到数据库数据
//        System.out.println("dao层拿到数据库数据：" + customer);
        return customer;
    }

    /**
     * 新增用户
     * @param cus
     * @return
     */
    @Override
    public int insertCustomer(Customer cus) {
        CustomerDao mapper = sqlSessionTemplate.getMapper(CustomerDao.class);
        return mapper.insertCustomer(cus);
    }

    /**
     * 修改用户信息
     * @param cus
     * @return
     */
    @Override
    public int updateCustomer(Customer cus) {
        CustomerDao mapper = sqlSessionTemplate.getMapper(CustomerDao.class);
        return mapper.updateCustomer(cus);
    }
}
