package com.lease.demo.controller;

import com.lease.demo.dao.Order;
import com.lease.demo.dao.Product;
import com.lease.demo.service.OrderService;
import com.lease.demo.service.UserService;
import com.lease.demo.util.UploadUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * Created by Administrator on 2017/11/6.
 */
@Controller
@SuppressWarnings("ALL")
@RequestMapping("/campusleasing")
public class ShoppingCartController {
    @Autowired
    UploadUtil uploadUtil;
    @Autowired
    UserService userService;
    @Autowired
    HttpServletRequest request;
    @Autowired
    OrderService orderService;

    @RequestMapping("/shoppingCart")
    public String shoppingCart(){
        return "/shopping_cart";
    }

    @RequestMapping("/addToCart")
    public String addToCart(Model model, String productId,String productPic,int odetailNum,String productName,String productPrice,int odetailDay)
    {
        HttpSession session = request.getSession();
        String msg;
        String href;
        System.out.println(productPrice);

        if (session.getAttribute("userName") != null)
        {
            String userId= (String) session.getAttribute("userId");
            String userAddr=userService.getUserAddrByUserId(userId);

            Date d=new Date();
            SimpleDateFormat sf=new SimpleDateFormat("yyyyMMdd");
            String str=sf.format(d);
            Random r=new Random();
            int i=r.nextInt(100);
            String s="";
            if(i<10)
                s="00"+i;
            else if(i>=10&&i<=99)
                s="0"+i;
            String orderCode=str+s;

            boolean res = orderService.addProductToShopCart(userId,userAddr,orderCode);

            if (res)
            {
                String orderId = orderService.findMaxOrderId();
                float price = odetailNum*odetailDay*Float.parseFloat(productPrice);
                boolean res1 = orderService.addShopCart(orderId,productId,price,productName,productPic,odetailNum,odetailDay);
                if (res1)
                {
                    msg = "成功添加到购物车";
                    href = "productDetails?productId=" + productId;
                }
                else
                {
                    msg = "添加购物车失败";
                    href = "productDetails?productId=" + productId;
                }
            }
            else
            {
                msg = "添加购物车失败";
                href = "productDetails?productId=" + productId;
            }

        } else
        {
            msg = "未登录,请登录！！";
            href = "login";
        }
        model.addAttribute("msg", msg);
        model.addAttribute("href", href);
        return "result";
    }

}
