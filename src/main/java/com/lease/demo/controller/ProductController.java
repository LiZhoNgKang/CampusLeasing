package com.lease.demo.controller;

import com.lease.demo.dao.Category;
import com.lease.demo.dao.Product;
import com.lease.demo.service.CateService;
import com.lease.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Created by Administrator on 2017/10/30.
 */
@Controller
@RequestMapping("/campusleasing")
public class ProductController {
    @Autowired
    ProductService productService;
    @Autowired
    CateService cateService;
    @RequestMapping("/publishProduct")
    public String addNewProduct()
    {
        return "/add_new_products";
    }

    @RequestMapping("/getProductDetailsByProductId")
    public String productDetails(@RequestParam(required = true)String productId,Model model){
        List<Product> productDetailList=productService.getProductDetailsByProductId(productId);
        model.addAttribute("productDetailList",productDetailList);
        return  "/product_details";
    }

    @RequestMapping("productByCateId")
    public String productByCateId(@RequestParam(required = true)String cateId, Model model)
    {
        System.out.println(cateId);
        List<Product> productList = productService.getProductByCateId(cateId);
        model.addAttribute("productList",productList);
        List<Category> cateList=cateService.findAllCate();
        model.addAttribute("cateDetailList",cateList);
        return  "/cate_details";
    }


}
