package com.lease.demo.dao;

public class OrderDetail
{
    private int odetailId;
    private int orderId;
    private int productId;
    private float odetailPrice;
    private int odetailNum;
    private String odetailName;
    private String odetailPic;
    private String odetailDay;
    private Order order;
    private Product product;


    public int getOdetailId()
    {
        return odetailId;
    }

    public void setOdetailId(int odetailId)
    {
        this.odetailId = odetailId;
    }

    public int getOrderId()
    {
        return orderId;
    }

    public void setOrderId(int orderId)
    {
        this.orderId = orderId;
    }

    public int getProductId()
    {
        return productId;
    }

    public void setProductId(int productId)
    {
        this.productId = productId;
    }

    public float getOdetailPrice()
    {
        return odetailPrice;
    }

    public void setOdetailPrice(float odetailPrice)
    {
        this.odetailPrice = odetailPrice;
    }

    public int getOdetailNum()
    {
        return odetailNum;
    }

    public void setOdetailNum(int odetailNum)
    {
        this.odetailNum = odetailNum;
    }

    public String getOdetailName()
    {
        return odetailName;
    }

    public void setOdetailName(String odetailName)
    {
        this.odetailName = odetailName;
    }

    public String getOdetailPic()
    {
        return odetailPic;
    }

    public void setOdetailPic(String odetailPic)
    {
        this.odetailPic = odetailPic;
    }

    public String getOdetailDay()
    {
        return odetailDay;
    }

    public void setOdetailDay(String odetailDay)
    {
        this.odetailDay = odetailDay;
    }

    public Order getOrder()
    {
        return order;
    }

    public void setOrder(Order order)
    {
        this.order = order;
    }

    public Product getProduct()
    {
        return product;
    }

    public void setProduct(Product product)
    {
        this.product = product;
    }

    @Override
    public String toString()
    {
        return "OrderDetail{" +
                "odetailId=" + odetailId +
                ", orderId=" + orderId +
                ", productId=" + productId +
                ", odetailPrice=" + odetailPrice +
                ", odetailNum=" + odetailNum +
                ", odetailName='" + odetailName + '\'' +
                ", odetailPic='" + odetailPic + '\'' +
                ", odetailDay='" + odetailDay + '\'' +
                ", order=" + order +
                ", product=" + product +
                '}';
    }
}
