package cn.echo.controller;

import cn.echo.pojo.Productinfo;
import cn.echo.service.impl.ProductinfoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @Package: cn.echo.controller
 * @Author: zhangjiangnan
 * @CreateTime: 2021/1/31 10:26
 * @Description:商品信息的控制器
 **/
@Controller
public class ProductinfoController {

    @Autowired
    private ProductinfoServiceImpl productinfoService;

    /**
     * 根据商品分类ID查询此分类的所有商品
     * @param id    商品分类ID
     * @return
     */
    @RequestMapping("/productcategoryinfo")
    public ModelAndView productcategoryinfo(@RequestParam int id) {
        List<Productinfo> selectinfo = productinfoService.selectinfo(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("proinfo", selectinfo);
        modelAndView.setViewName("commodity");
        return modelAndView;
    }

    @RequestMapping("/productcategoryinfohot")
    public ModelAndView productcategoryinfohot() {
        System.out.println("Controller层");
//        获取数据
        List<Productinfo> productinfos = productinfoService.selectProductinfoHot();
        System.out.println("获取到数据，数据为：");
        for (Productinfo productinfo : productinfos) {
            System.out.println(productinfo);
        }
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("proinfo", productinfos);
        modelAndView.setViewName("commodity");
        return modelAndView;
    }
}
