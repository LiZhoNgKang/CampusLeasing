package com.lease.demo.controller;


import com.lease.demo.dao.*;
import com.lease.demo.service.AdminService;
import com.lease.demo.util.UploadUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController
{
    @Autowired
    private AdminService adminService;
    @Autowired
     UploadUtil uploadUtil;

    @RequestMapping("")
    public String loginView()
    {
        return "admin/login";
    }

    @RequestMapping("/home")
    public String home()
    {
       return "/admin/home";
    }

    @RequestMapping("/productSearch")
    public String product(@RequestParam(required = false) String cateId,
                          @RequestParam(required = false) String productName, Model model)
    {
        System.out.println(cateId);
        List<Category> categoryList = adminService.getAllCategory();
//        List<Product> productList = adminService.searchProduct(cateId,productName);
//        model.addAttribute("productList",productList);
        model.addAttribute("cateList",categoryList);
        return "admin/product_admin";
    }

    @RequestMapping("/category")
    public String category(Model model)
    {
        List<Category> categoryList = adminService.getAllCategory();
        model.addAttribute("cateList",categoryList);
        return "admin/category_admin";
    }

    @RequestMapping("/userSearch")
    public String user(@RequestParam(required = false)
                                   String userName,Model model)
    {
        List<User> userList = adminService.findUser(userName);
        model.addAttribute("userList",userList);

        return "admin/user_admin";
    }

    @RequestMapping("/orderSearch")
    public String order(@RequestParam(value = "oStatusId",required = false) String oStatusId, @RequestParam(required = false) String userName,
                        @RequestParam(required = false) String orderCode, @RequestParam(required = false) String startDate,
                        @RequestParam(required = false) String endDate, Model model)
    {
        List<OrderStatus> orderStatuses = adminService.getAllOrderStatus();
//        List<Order> orderList = adminService.searchOrder(oStatusId,orderCode,userName,startDate,endDate);
//        model.addAttribute("orderList",orderList);
        model.addAttribute("orderStatuses",orderStatuses);
//        System.out.println(orderList);
        return "admin/order_admin";
    }

    @RequestMapping("/toAddUser")
    public String handleUser()
    {
        return "admin/add_user";
    }

    @RequestMapping("/addUser")
    public String addUser(User user,Model model)
    {
        String msg;
        String href;
        boolean rel = adminService.addNewUser(user);
        if (rel)
        {
            msg = "添加用户成功！";
            href = "userSearch";
        }
        else
        {
            msg = "添加用户失败，请重新添加！";
            href = "toAddUser";
        }
        model.addAttribute("msg", msg);
        model.addAttribute("href", href);
        return "result";
    }

    @RequestMapping("/toAddProducts")
    public String handleProducts(Model model)
    {
        List<Category> categoryList = adminService.getAllCategory();
        model.addAttribute("cateList",categoryList);
        return "admin/add_product";
    }

    @RequestMapping("/addProduct")
    public String addProduct(Product product,@RequestParam MultipartFile productPic, Model model)
    {
        String msg;
        String href;
        String image = uploadUtil.uploadImage(productPic);
        boolean addRel = adminService.addProduct(product);
        if (addRel)
        {
            String maxProductId = adminService.getMaxProductId();
            try
            {
                boolean picRel = adminService.addProductPic(maxProductId,image);
                if (picRel)
                {
                    msg = "添加商品成功！";
                    href = "productSearch";
                }
                else
                {
                    msg = "添加商品图片失败！";
                    href = "toAddProducts";
                }
            }
            catch (Exception e)
            {
                msg = "添加商品图片失败！" + "\n" + "异常信息为:" + e.getMessage();
                href = "toAddProducts";
            }
        }
        else
        {
            msg = "添加商品失败！请重新添加！";
            href = "toAddProducts";
        }
        model.addAttribute("msg", msg);
        model.addAttribute("href", href);
        return "result";
    }

    @RequestMapping("/toAddProductCate")
    public String handleProductCate()
    {
        return "admin/add_product_cate";
    }

    @RequestMapping("/addCate")
    public String addCate(@RequestParam String cateName ,
                          @RequestParam MultipartFile catePic,Model model)

    {
        String msg;
        String href;
        String pic = uploadUtil.uploadImage(catePic);
        boolean rel = adminService.addCate(cateName,pic);
        if (rel)
        {
            msg = "添加分类成功！";
            href = "category";
        }
        else
        {
            msg = "添加分类失败，请重新添加！";
            href = "toAddProductCate";
        }
        model.addAttribute("msg", msg);
        model.addAttribute("href", href);
        return "result";

    }


    @RequestMapping("/editProduct")
    public String editProduct()
    {
        return "admin/edit_product";
    }

    @RequestMapping("/editProductCate")
    public String editProductCate()
    {
        return "admin/edit_product_cate";
    }

    @RequestMapping("/editUser")
    public String editUser()
    {
        return "admin/edit_user";
    }

}
