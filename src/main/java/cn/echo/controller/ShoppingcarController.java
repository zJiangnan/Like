package cn.echo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @Package: cn.echo.controller
 * @Author: zhangjiangnan
 * @CreateTime: 2021/2/15 09:47
 * @Description:购物车的控制器
 **/
@Controller
public class ShoppingcarController {

    @RequestMapping("/usershoppingcarinfo")
    public ModelAndView userShoppingCarInfo() {
        System.out.println("进入购物车控制器");
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("usershoppingcar");
        return modelAndView;
    }

}
