package com.lease.demo.controller;

import com.lease.demo.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Administrator on 2017/11/6.
 */
@Controller
@RequestMapping("/campusleasing")
public class ShoppingCartController {

    @Autowired
    ShoppingCartService shoppingCartService;


}
