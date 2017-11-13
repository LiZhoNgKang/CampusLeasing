package com.lease.demo.controller;

import com.lease.demo.dao.Category;
import com.lease.demo.dao.Pic;
import com.lease.demo.dao.Product;
import com.lease.demo.service.CateService;
import com.lease.demo.service.ProductService;
import com.lease.demo.util.UploadUtil;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.jws.WebParam;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Created by Administrator on 2017/10/30.
 */
@Controller
@RequestMapping("/campusleasing")
public class ProductController
{
    @Autowired
    ProductService productService;
    @Autowired
    CateService cateService;

    @Autowired
    UploadUtil uploadUtil;

    @RequestMapping("/publishProduct")
    public String addNewProduct(Model model)
    {
        List<Category> categoryList = cateService.findAllCate();
        model.addAttribute("categoryList", categoryList);
        return "/add_new_products";
    }

    @RequestMapping("/addProduct")
    public String addProduct(Product product, @RequestParam(required = false) MultipartFile productPic)
    {
        String image = uploadUtil.uploadImage(productPic);

        Boolean result = productService.addNewProduct(product);

        String productId = productService.getMaxProductId();
        System.out.println(productId);
        boolean picRel = productService.addPic(productId, image);
        return "personal_center";
    }

    @RequestMapping("/productDetails")
    public String productDetails(@RequestParam String productId, Model model)
    {

        List<Product> productDetailList = productService.getProductDetailsByProductId(productId);
        model.addAttribute("productDetailList", productDetailList);
        return "/product_details";
    }

    @RequestMapping("/searchProduct")
    public String getProductListByProductName(String productName, Model model)
    {
        System.out.println(productName);
        if (productName != "")
        {
            List<Product> searchProductList = productService.getProductListByProductName(productName);
            model.addAttribute("searchProductList", searchProductList);
            return "redirect:productByCateId?cateId=" + searchProductList.get(0).getCateId();
        } else
        {
            return "redirect:productByCateId?cateId=1";
        }
    }

    @RequestMapping("productByCateId")
    public String productByCateId(@RequestParam(required = true) String cateId, Model model)
    {
        System.out.println(cateId);
        List<Product> productList = productService.getProductByCateId(cateId);
        model.addAttribute("productList", productList);
        List<Category> cateList = cateService.findAllCate();
        model.addAttribute("cateDetailList", cateList);
        return "/cate_details";
    }


}
