package com.lease.demo.dao;

import java.util.Date;
import java.util.List;

public class Order
{
    private int orderId;
    private int userId;
    private String orderCode;
    private Date orderDate;
    private String orderAddr;
    private Integer oStatusId;
    private List<OrderDetail> orderDetails;
    private OrderStatus orderStatuses;
    private List<Product> products;
    private User user;

    public int getOrderId()
    {
        return orderId;
    }

    public void setOrderId(int orderId)
    {
        this.orderId = orderId;
    }

    public int getUserId()
    {
        return userId;
    }

    public void setUserId(int userId)
    {
        this.userId = userId;
    }

    public String getOrderCode()
    {
        return orderCode;
    }

    public void setOrderCode(String orderCode)
    {
        this.orderCode = orderCode;
    }

    public Date getOrderDate()
    {
        return orderDate;
    }

    public void setOrderDate(Date orderDate)
    {
        this.orderDate = orderDate;
    }

    public String getOrderAddr()
    {
        return orderAddr;
    }

    public void setOrderAddr(String orderAddr)
    {
        this.orderAddr = orderAddr;
    }

    public Integer getoStatusId()
    {
        return oStatusId;
    }

    public void setoStatusId(Integer oStatusId)
    {
        this.oStatusId = oStatusId;
    }

    public List<OrderDetail> getOrderDetails()
    {
        return orderDetails;
    }

    public void setOrderDetails(List<OrderDetail> orderDetails)
    {
        this.orderDetails = orderDetails;
    }

    public OrderStatus getOrderStatuses()
    {
        return orderStatuses;
    }

    public void setOrderStatuses(OrderStatus orderStatuses)
    {
        this.orderStatuses = orderStatuses;
    }

    public User getUser()
    {
        return user;
    }

    public void setUser(User user)
    {
        this.user = user;
    }

    public List<Product> getProducts()
    {
        return products;
    }

    public void setProducts(List<Product> products)
    {
        this.products = products;
    }

    @Override
    public String toString()
    {
        return "Order{" +
                "orderId=" + orderId +
                ", userId=" + userId +
                ", orderCode='" + orderCode + '\'' +
                ", orderDate=" + orderDate +
                ", orderAddr='" + orderAddr + '\'' +
                ", oStatusId=" + oStatusId +
                ", orderDetails=" + orderDetails +
                ", orderStatuses=" + orderStatuses +
                ", products=" + products +
                ", user=" + user +
                '}';
    }
}
