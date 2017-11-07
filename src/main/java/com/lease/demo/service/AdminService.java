package com.lease.demo.service;

import com.lease.demo.dao.*;

import java.util.List;

public interface AdminService
{

    List<User> findUser(String userName);

    List<OrderStatus> getAllOrderStatus();

    List<Order> searchOrder(String oStatusId, String orderCode,
                            String userName, String startDate, String endDate);

    List<Category> getAllCategory();

    List<Product> searchProduct(String cateId, String productName);

    boolean addNewUser(User user);

    boolean addCate(String cateName, String pic);

    boolean addProduct(Product product);

    String getMaxProductId();

    boolean addProductPic(String maxProductId, String image);

    User findUserByUserId(String userId);

    boolean updateUser(User user);

    Category getCateByCateId(String cateId);

    boolean updateCate(String cateId, String cateName, String img);

    boolean delCateByCateId(String cateId);

    List<Order> findOrderByUserId(String userId);

    boolean delUserByUserId(String userId);
}
