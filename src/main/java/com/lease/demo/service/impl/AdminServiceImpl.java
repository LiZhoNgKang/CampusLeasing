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
        } else
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
    public List<Order> searchOrder(String oStatusId, String orderCode, String userName, String startDate, String endDate)
    {
        if (orderCode == null)
        {
            orderCode = "%%";
        } else
        {
            orderCode = "%" + orderCode + "%";
        }

        if (userName == null)
        {
            userName = "%%";
        } else
        {
            userName = "%" + userName + "%";
        }
        System.out.println(adminMapper.searchOrder(oStatusId, orderCode, userName, startDate, endDate).toString());
        return adminMapper.searchOrder(oStatusId, orderCode, userName, startDate, endDate);
    }

    @Override
    public List<Category> getAllCategory()
    {
        return adminMapper.getAllCategory();
    }

    @Override
    public boolean addNewUser(User user)
    {
        return adminMapper.addNewUser(user);
    }

    @Override
    public boolean addCate(String cateName, String pic)
    {
        return adminMapper.addCate(cateName, pic);
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
        return adminMapper.addProductPic(maxProductId, image);
    }

    @Override
    public User findUserByUserId(String userId)
    {
        return adminMapper.findUserByUserId(userId);
    }

    @Override
    public boolean updateUser(User user)
    {
        return adminMapper.updateUser(user);
    }

    @Override
    public Category getCateByCateId(String cateId)
    {
        return adminMapper.getCateByCateId(cateId);
    }

    @Override
    public boolean updateCate(String cateId, String cateName, String img)
    {
        return adminMapper.updateCate(cateId, cateName, img);
    }

    @Override
    public boolean delCateByCateId(String cateId)
    {
//        得到要删除的商品图片的商品Id
        List<String> productId = adminMapper.getProductIdByCateId(cateId);

        if (productId.size() > 0)
        {
//            批量删除...
            for (String o : productId)
            {
                adminMapper.delPicByProductId(o);
            }
            adminMapper.delProductByCateId(cateId);
            adminMapper.delCateByCateId(cateId);
        } else
        {
            adminMapper.delProductByCateId(cateId);
            adminMapper.delCateByCateId(cateId);
        }
        return true;

    }

    @Override
    public List<Order> findOrderByUserId(String userId)
    {
        return adminMapper.findOrderByUserId(userId);
    }

    @Override
    public boolean delUserByUserId(String userId)
    {

        return adminMapper.delUserByUserId(userId);
    }

    @Override
    public List<Product> searchProduct(String cateId, String productName)
    {
        if (productName == null)
        {
            productName = "%%";
        } else
        {
            productName = "%" + productName + "%";
        }
        return adminMapper.searchProduct(cateId, productName);
    }

    @Override
    public Product findProductByProduct(String productId)
    {
        return adminMapper.findProductByProduct(productId);
    }

    @Override
    public boolean updateProduct(Product product)
    {
        return adminMapper.updateProduct(product);
    }

    @Override
    public boolean updatePicByProductId(Integer productId, String img)
    {
        return adminMapper.updatePicByProductId(productId, img);
    }

    @Override
    public boolean delProductByProductId(String productId)
    {
        return adminMapper.delProductByProductId(productId);
    }

    @Override
    public boolean delOrderByOrderId(String orderId)
    {
        adminMapper.delOrderDetailsByOrderId(orderId);
        boolean res = adminMapper.delOrderByOrderId(orderId);
        if (res)
        {
            return true;
        } else
        {
            return false;
        }

    }


}
