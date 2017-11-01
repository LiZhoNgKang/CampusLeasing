package com.lease.demo.dao;

import java.util.List;

public class User
{
    private int userId;
    private String userName;
    private String passWord;
    private String address;
    private String mobile;
    private Integer userAge;
    private int userSex;
    private int rank;
    private List<Order> orders;

    public int getUserId()
    {
        return userId;
    }

    public void setUserId(int userId)
    {
        this.userId = userId;
    }

    public String getUserName()
    {
        return userName;
    }

    public void setUserName(String userName)
    {
        this.userName = userName;
    }

    public String getPassWord()
    {
        return passWord;
    }

    public void setPassWord(String passWord)
    {
        this.passWord = passWord;
    }

    public String getAddress()
    {
        return address;
    }

    public void setAddress(String address)
    {
        this.address = address;
    }

    public String getMobile()
    {
        return mobile;
    }

    public void setMobile(String mobile)
    {
        this.mobile = mobile;
    }

    public int getUserSex()
    {
        return userSex;
    }

    public void setUserSex(int userSex)
    {
        this.userSex = userSex;
    }

    public int getRank()
    {
        return rank;
    }

    public void setRank(int rank)
    {
        this.rank = rank;
    }

    public void setUserAge(Integer userAge)
    {
        this.userAge = userAge;
    }

    public List<Order> getOrders()
    {
        return orders;
    }

    public void setOrders(List<Order> orders)
    {
        this.orders = orders;
    }

    @Override
    public String toString()
    {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", passWord='" + passWord + '\'' +
                ", address='" + address + '\'' +
                ", mobile='" + mobile + '\'' +
                ", userAge=" + userAge +
                ", userSex=" + userSex +
                ", rank=" + rank +
                ", orders=" + orders +
                '}';
    }
}
