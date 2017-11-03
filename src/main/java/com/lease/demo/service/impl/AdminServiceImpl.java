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
        System.out.println(oStatusId+"222"+orderCode);
        return adminMapper.searchOrder(oStatusId,orderCode,userName,startDate,endDate);
    }

    @Override
    public List<Category> getAllCategory()
    {
        return adminMapper.getAllCategory();
    }

    @Override
    public List<Product> searchProduct(String cateId, String productName)
    {
        if (cateId.equals("0"))
        {
            cateId = "%%";
        }
        else
        {
            cateId = cateId;
        }


        if (productName == null)
        {
            productName = "%%";
        }
        else
        {
            productName = "%" + productName + "%";
        }
        return adminMapper.searchProduct(cateId,productName);
    }

    @Override
    public boolean addNewUser(User user)
    {
        return adminMapper.addNewUser(user);
    }

    @Override
    public boolean addCate(String cateName, String pic)
    {
        return adminMapper.addCate(cateName,pic);
    }

    @Override
    public boolean addProduct(Product product)
    {
        return adminMapper.addProduct(product);
    }

    @Override
    public String getMaxProductId()
    {
        return adminMapper.getMaxProductId();
    }

    @Override
    public boolean addProductPic(String maxProductId, String image)
    {
        return adminMapper.addProductPic(maxProductId,image);
    }


}
