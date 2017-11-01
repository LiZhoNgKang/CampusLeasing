package com.lease.demo.dao;

public class OrderStatus
{
    private Integer oStatusId;
    private String oStatusName;


    public Integer getoStatusId()
    {
        return oStatusId;
    }

    public void setoStatusId(Integer oStatusId)
    {
        this.oStatusId = oStatusId;
    }

    public String getoStatusName()
    {
        return oStatusName;
    }

    public void setoStatusName(String oStatusName)
    {
        this.oStatusName = oStatusName;
    }

    @Override
    public String toString()
    {
        return "OrderStatus{" +
                "oStatusId=" + oStatusId +
                ", oStatusName='" + oStatusName + '\'' +
                '}';
    }
}
