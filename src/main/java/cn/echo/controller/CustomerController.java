package cn.echo.controller;

import cn.echo.pojo.Customer;
import cn.echo.pojo.Productcategory;
import cn.echo.service.impl.CustomerServiceImpl;
import cn.echo.service.impl.ProductcategoryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @Package: cn.echo.controller
 * @Author: zhangjiangnan
 * @CreateTime: 2021/1/24 16:19
 * @Description:用户操作控制器
 **/
@Controller
public class CustomerController {

    @Autowired
    private CustomerServiceImpl customerService;
//    页面加载时加载商品分类信息
    @Autowired
    private ProductcategoryServiceImpl productcategoryService;

    /**
     * 页面加载时数据
     * @param req
     * @param resp
     * @return
     */
    @RequestMapping("/indexs")
    public ModelAndView index(HttpServletRequest req, HttpServletResponse resp) {
        ModelAndView modelAndView = new ModelAndView();
        //        查新商品分类，在用户登陆之后加载
        List<Productcategory> productcategories = productcategoryService.selectAll();
        req.getSession().setAttribute("listpro", productcategories);
        modelAndView.setViewName("user");
        return modelAndView;
    }

    /**
     * 登陆控制器
     * @param req       请求对象
     * @param resp      响应对象
     * @param username  前台传递用户名
     * @param password  前台传递密码
     * @return          返回用户对象
     * @throws IOException
     */
    @RequestMapping("/userlogin")
    @ResponseBody
    public Customer userLogin(HttpServletRequest req, HttpServletResponse resp,
                                  @RequestParam String username, @RequestParam String password) throws IOException {
//        测试后台是否拿到前台数据
//        System.out.println("控制层拿到的值：用户名：" + username + "，密码：" + password);
//        得到处理好的数据
        Customer customer = customerService.userLogin(username, password);
//        System.out.println("控制层返回的数据：" + customer);
//        将用户信息存入Session域中
        req.getSession().setAttribute("uname", customer);
        return customer;
    }

    /**
     * 注册控制器
     * @param req   请求对象
     * @param resp  响应对象
     * @param username  用户名
     * @param password
     * @param realname
     * @param address
     * @param email
     * @param mobile
     * @return
     * @throws IOException
     */
    @RequestMapping("/getRegister")
    @ResponseBody
    public String getRegister(HttpServletRequest req, HttpServletResponse resp,
                              @RequestParam String username, @RequestParam String password,
                              @RequestParam String realname, @RequestParam String address,
                              @RequestParam String email, @RequestParam String mobile
    ) throws IOException {
//        获取前台数据存入一个用户对象中
        Customer cus = new Customer(null, username, password, realname, address, email, mobile);
        if (customerService.insertCustomer(cus) > 0) {
//            注册后直接跳用户界面，跳时需要将用户信息存入Session域中
            Customer customer = customerService.userLogin(username, password);
//            查新商品分类，在用户登陆之后加载
//            List<Productcategory> productcategories = selectAllProducts();
            req.getSession().setAttribute("uname", customer);
//            req.getSession().setAttribute("listpro", productcategories);
            return "ok";
        }else {
            return "no";
        }
    }

    /**
     * 查看个人信息
     * @return
     */
    @RequestMapping("/userinfos")
    public ModelAndView getUserInfo() {
//        通过模型视图对象直接跳转到个人信息页面，用户对象已在Session中
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("userinfo");
        return modelAndView;
    }

    /**
     * 修改个人信息
     * @param req
     * @param resp
     * @param cus   用户对象
     * @return
     */
    @RequestMapping("/updateuserinfo")
    @ResponseBody
    public String updateUserInfo(HttpServletRequest req, HttpServletResponse resp, Customer cus) {
//        获取用户原有的用户对象信息
        Customer user = (Customer) req.getSession().getAttribute("uname");
        if (customerService.updateCustomer(cus, user) > 0) {
            return "ok";
        } else {
            return "no";
        }
    }
}
