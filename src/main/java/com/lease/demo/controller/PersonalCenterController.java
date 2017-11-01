package com.lease.demo.controller;

import com.lease.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Administrator on 2017/11/1.
 */
@Controller
@RequestMapping("/campusleasing")
public class PersonalCenterController {

    @Autowired
    UserService userService;

    /**
     *个人中心
     * @return
     */
    @RequestMapping("/personalCenter")
    public String personalCenter(){
        return "/personal_center";
    }

    /**
     *个人中心-管理商品
     * @return
     */
    @RequestMapping("/personalCenterManagerProduct")
    public String personalCenterManagerProduct(){
        return "/personal_center_managerProduct";
    }
    /**
     *个人中心-管理商品-修改商品
     * @return
     */
    @RequestMapping("/personalCenterModifyProduct")
    public String personalCenterModifyProduct(){
        return "/manager_product_modifyProduct";
    }

    /**
     *个人中心-修改密码
     * @return
     */
    @RequestMapping("/personalCenterModifyPassword")
    public String personalCenterModifyPassword(){
        return "/personal_center_modifyPassword";
    }

    /**
     *个人中心-修改个人信息
     * @return
     */
    @RequestMapping("/personalCenterModifyPersonalInfo")
    public String personalCenterModifyPersonalInfo(){
        return "/personal_center_modifyPersonalInfo";
    }




}
