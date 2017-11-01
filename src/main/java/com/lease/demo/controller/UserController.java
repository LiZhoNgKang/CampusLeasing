package com.lease.demo.controller;

import com.lease.demo.dao.Category;
import com.lease.demo.dao.Order;
import com.lease.demo.dao.OrderDetail;
import com.lease.demo.dao.Product;
import com.lease.demo.service.CateService;
import com.lease.demo.service.ProductService;
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

    @RequestMapping("/home")
    public String home(Model model){
        List<Category> findFiveCate=cateService.findFiveCate();
        model.addAttribute("cateFiveList",findFiveCate);
        List<OrderDetail> findLeaseRank=cateService.findLeaseRank();
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

    @RequestMapping("/shoppingCart")
    public String shoppingCart(){
        return "/shopping_cart";
    }

    @RequestMapping("/moreCates")
    public String moreCates(Model model){
        List<Category> findAllCate=cateService.findAllCate();
        model.addAttribute("cateAllList",findAllCate);
        return "/more_products_cate";
    }


}
