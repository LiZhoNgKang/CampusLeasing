package com.lease.demo.controller;

import com.lease.demo.dao.Category;
import com.lease.demo.dao.Product;
import com.lease.demo.dao.User;
import com.lease.demo.service.CateService;
import com.lease.demo.service.ProductService;
import com.lease.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/campusleasing")
public class UserController
{
    @Autowired
    private CateService cateService;
    @Autowired
    private ProductService productService;
    @Autowired
    private UserService userService;

    @RequestMapping("/home")
    public String home(Model model){
        List<Category> findFiveCate=cateService.findFiveCate();
        model.addAttribute("cateFiveList",findFiveCate);
        List<Product> findLeaseRank=cateService.findLeaseRank();
        model.addAttribute("rankList",findLeaseRank);
        return "/home";
    }
    @RequestMapping("/login")
    public String userLogin(){
        return "/login";
    }

    @RequestMapping("/register")
    public String userRegister(){

        return "/register";
    }

    @RequestMapping("addNewUser")
    public String AddNewUser(Model model,User user)
    {
        String msg;
        String href = null;
        System.out.println(user);
        try
        {
            Boolean result = userService.addNewUser(user);
            if (result)
            {
                msg = "添加成功";
                href = "login";
            } else
            {
                msg = "添加失败";
            }
        } catch (Exception e)
        {
            msg = "用户名已存在";
            href = "register";
        }
        model.addAttribute("msg",msg);
        model.addAttribute("href",href);
        return "result";
    }

    @RequestMapping("/shoppingCart")
    public String shoppingCart(){
        return "/shopping_cart";
    }

    @RequestMapping("/myOrder")
    public String myOrder(){
        return "/my_order";
    }

    @RequestMapping("/moreCates")
    public String moreCates(Model model){
        List<Category> findAllCate=cateService.findAllCate();
        model.addAttribute("cateAllList",findAllCate);
        return "/more_products_cate";
    }


}
