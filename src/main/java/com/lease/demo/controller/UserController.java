package com.lease.demo.controller;

import com.lease.demo.dao.Category;
import com.lease.demo.dao.Product;
import com.lease.demo.dao.User;
import com.lease.demo.service.CateService;
import com.lease.demo.service.ProductService;
import com.lease.demo.service.UserService;
import com.sun.org

        .apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/campusleasing")
public class UserController
{
    @Autowired
    HttpServletRequest request;
    @Autowired
    HttpServletResponse response;
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

    @RequestMapping("/loginSession")
    public String loginSession(Model model,User user){
        User users=userService.getUserByUserNameAndPassword(user);
        HttpSession session=request.getSession();

        String msg;
        String href;
        try
        {
            //判断是否有这个用户
            if (users.getUserName() != null)
            {

                //登录以后的名字
                session.setAttribute("userName", users.getUserName());
                session.setAttribute("userId",users.getUserId());
                msg = "登录成功";
                href = "home";

                //每次登录成功都给用户一个Cookie
                Cookie cookie = new Cookie("LoginSession", users.getUserName());
                cookie.setMaxAge(30 * 24 * 3600);
                cookie.setPath("/campusleasing");
                response.addCookie(cookie);
            }
            else
            {
                msg = "该用户不存在，请输入正确的用户名！";
                model.addAttribute("msg",msg);
                return "login";
            }
        } catch (NullPointerException e)
        {
            msg = e.getMessage();
            href = "login";
        }
        model.addAttribute("msg",msg);
        model.addAttribute("href",href);
        return "result";
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


    @RequestMapping("removeUser")
    public String RemoveUser()
    {
        HttpSession session = request.getSession();
        session.removeAttribute("userName");
        return "redirect:home";
    }

}
