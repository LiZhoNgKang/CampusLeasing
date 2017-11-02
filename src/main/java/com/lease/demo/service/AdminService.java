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

    boolean addCate(String cateName, String cateImage);
}
