package com.lease.demo.service;

/**
 * Created by Administrator on 2017/11/8.
 */
public interface OrderService {


    boolean  addProductToShopCart(Object userId, String userAddr, String orderCode);

    String findMaxOrderId();

    boolean addShopCart(String orderId, String productId, Float price, String productName, String productPic, String odetailNum, String odetailDay);

    boolean addRent(Object userId, String userAddr, String orderCode);

    boolean addRentToOrderDetail(String orderId, String productId, Float price, String productName, String productPic, String odetailNum, String odetailDay);
}
