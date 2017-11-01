package com.lease.demo.service.impl;

import com.lease.demo.dao.*;
import com.lease.demo.mapper.AdminMapper;
import com.lease.demo.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@SuppressWarnings("all")
@Service
public class AdminServiceImpl implements AdminService
{
    @Autowired
    private AdminMapper adminMapper;


    @Override
    public List<User> findUser(String userName)
    {
        if (userName == null)
        {
            userName = "%%";
        }
        else
        {
            userName = "%" + userName + "%";
        }
        return adminMapper.searchUser(userName);
    }



    @Override
    public List<OrderStatus> getAllOrderStatus()
    {
        return adminMapper.getAllOrderStatus();
    }

    @Override
    public List<Order> searchOrder(String  oStatusId, String orderCode, String userName, String startDate, String endDate)
    {
        if (oStatusId.equals("0"))
        {
            oStatusId = "%%";
        }
        else
        {
            oStatusId = oStatusId;
        }

        if (orderCode == null)
        {
            orderCode = "%%";
        }
        else
        {
            orderCode = "%" + orderCode + "%";
        }

        if (userName == null)
        {
            userName = "%%";
        }
        else
        {
            userName = "%" + userName + "%";
        }
        return adminMapper.searchOrder(oStatusId,orderCode,userName,startDate,endDate);
    }

    @Override
    public List<Category> getAllCategory()
    {
        return adminMapper.getAllCategory();
    }

    @Override
    public List<Product> searchProduct(String productCate, String productName)
    {
        if (productCate == null)
        {
            productCate = "%%";
        }
        else
        {
            productCate = productCate;
        }


        if (productName == null)
        {
            productName = "%%";
        }
        else
        {
            productName = "%" + productName + "%";
        }
        return adminMapper.searchProduct(productCate,productName);
    }


}
