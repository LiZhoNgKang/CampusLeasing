package com.lease.demo.controller;


import com.lease.demo.dao.*;
import com.lease.demo.service.AdminService;
import com.lease.demo.util.UploadUtil;
import com.sun.org.apache.xpath.internal.operations.Mod;
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
    public String product(String cateId,String productName, Model model)
    {
        System.out.println(cateId);
        List<Category> categoryList = adminService.getAllCategory();
        List<Product> productList = adminService.searchProduct(cateId,productName);
        model.addAttribute("productList",productList);
        model.addAttribute("cateList", categoryList);
        return "admin/product_admin";
    }

    @RequestMapping("/category")
    public String category(Model model)
    {
        List<Category> categoryList = adminService.getAllCategory();
        model.addAttribute("cateList", categoryList);
        return "admin/category_admin";
    }

    @RequestMapping("/userSearch")
    public String user(@RequestParam(required = false)
                               String userName, Model model)
    {
        List<User> userList = adminService.findUser(userName);
        model.addAttribute("userList", userList);

        return "admin/user_admin";
    }

    @RequestMapping("/orderSearch")
    public String order(@RequestParam(value = "oStatusId", required = false) String oStatusId, @RequestParam(required = false) String userName,
                        @RequestParam(required = false) String orderCode, @RequestParam(required = false) String startDate,
                        @RequestParam(required = false) String endDate, Model model)
    {
        List<OrderStatus> orderStatuses = adminService.getAllOrderStatus();
//        List<Order> orderList = adminService.searchOrder(oStatusId,orderCode,userName,startDate,endDate);
//        model.addAttribute("orderList",orderList);
        model.addAttribute("orderStatuses", orderStatuses);
//        System.out.println(orderList);
        return "admin/order_admin";
    }

    @RequestMapping("/toAddUser")
    public String handleUser()
    {
        return "admin/add_user";
    }

    @RequestMapping("/addUser")
    public String addUser(User user, Model model)
    {
        String msg;
        String href;
        boolean rel = adminService.addNewUser(user);
        if (rel)
        {
            msg = "添加用户成功！";
            href = "userSearch";
        } else
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
        model.addAttribute("cateList", categoryList);
        return "admin/add_product";
    }

    @RequestMapping("/addProduct")
    public String addProduct(Product product, @RequestParam MultipartFile productPic, Model model)
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
                boolean picRel = adminService.addProductPic(maxProductId, image);
                if (picRel)
                {
                    msg = "添加商品成功！";
                    href = "productSearch";
                } else
                {
                    msg = "添加商品图片失败！";
                    href = "toAddProducts";
                }
            } catch (Exception e)
            {
                msg = "添加商品图片失败！" + "\n" + "异常信息为:" + e.getMessage();
                href = "toAddProducts";
            }
        } else
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
    public String addCate(@RequestParam String cateName,
                          @RequestParam MultipartFile catePic, Model model)

    {
        String msg;
        String href;
        String pic = uploadUtil.uploadImage(catePic);
        boolean rel = adminService.addCate(cateName, pic);
        if (rel)
        {
            msg = "添加分类成功！";
            href = "category";
        } else
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
    public String editProductCate(@RequestParam String cateId, Model model)
    {
        Category cate = adminService.getCateByCateId(cateId);
        model.addAttribute("cate", cate);
        return "admin/edit_product_cate";
    }

    @RequestMapping("/updateCate")
    public String updateCate(@RequestParam String cateId, @RequestParam MultipartFile catePic,
                             @RequestParam String cateName, Model model)
    {
        String msg;
        String href;
        String img = uploadUtil.uploadImage(catePic);
        boolean cateRel = adminService.updateCate(cateId, cateName, img);
        if (cateRel)
        {
            msg = "修改商品分类成功。";
            href = "category";
        } else
        {
            msg = "修改商品分类失败！";
            href = "editProductCate?cateId" + cateId;
        }
        model.addAttribute("msg", msg);
        model.addAttribute("href", href);
        return "result";
    }

    @RequestMapping("/delProductCate")
    public String delProductCate(@RequestParam String cateId, Model model)
    {
        String msg;
        String href;

        boolean delRel = adminService.delCateByCateId(cateId);
        if (delRel)
        {
            msg = "删除商品分类成功";
            href = "category";
        }
        else
        {
            msg = "删除商品分类失败";
            href = "category";
        }

        model.addAttribute("msg", msg);
        model.addAttribute("href", href);
        return "result";
    }

    @RequestMapping("/editUser")
    public String editUser(@RequestParam String userId, Model model)
    {
        User user = adminService.findUserByUserId(userId);
        model.addAttribute("user", user);
        return "admin/edit_user";
    }

    @RequestMapping("/updateUser")
    public String updateUser(User user, Model model)
    {
        String msg;
        String href;
        boolean upRel = adminService.updateUser(user);
        if (upRel)
        {
            msg = "修改用户信息成功。";
            href = "userSearch";
        } else
        {
            msg = "修改用户信息失败！";
            href = "editUser?userId=" + user.getUserId();
        }
        model.addAttribute("msg", msg);
        model.addAttribute("href", href);
        return "result";
    }

    @RequestMapping("/delUser")
    public String delUser(@RequestParam String userId, Model model)
    {
        String msg;
        String href;
        List<Order> userOrder = adminService.findOrderByUserId(userId);
        if (userOrder.size() > 0)
        {
            msg = "目前仍有这个用户的订单，无法删除该用户";
            href = "userSearch";
        } else
        {

            boolean delRel = adminService.delUserByUserId(userId);
            if (delRel)
            {
                msg = "删除用户成功";
                href = "userSearch";
            } else
            {
                msg = "删除用户失败";
                href = "userSearch";
            }

        }
        model.addAttribute("msg", msg);
        model.addAttribute("href", href);
        return "result";

    }

}
