package cn.echo.controller;

import cn.echo.pojo.Productcategory;
import cn.echo.service.impl.ProductcategoryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @Package: cn.echo.controller
 * @Author: zhangjiangnan
 * @CreateTime: 2021/1/30 15:32
 * @Description:商品分类控制器
 **/
@Controller
public class ProductcategoryController {

    @Autowired
    private ProductcategoryServiceImpl productcategoryService;

    @RequestMapping("/users")
    public ModelAndView  getUsers(){
        System.out.println("进入商品分类控制器");
        ModelAndView modelAndView = new ModelAndView();
        List<Productcategory> productcategories = productcategoryService.selectAll();
        modelAndView.addObject(productcategories);
        modelAndView.setViewName("/user.jsp");
        return modelAndView;
    }

}
