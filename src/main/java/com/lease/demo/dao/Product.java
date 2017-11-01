package com.lease.demo.dao;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;
import java.util.List;

public class Product
{
    private int productId;
    private int cateId;
    private String productName;
    @NumberFormat(pattern="##.#")
    private float productPrice;
    private String productNum;
    private String productDisc;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date productDate;
    private MultipartFile productPicFile;
    private Pic pics;
    private List<Order> orders;
    private OrderDetail orderDetails;


    public int getProductId()
    {
        return productId;
    }

    public void setProductId(int productId)
    {
        this.productId = productId;
    }

    public int getCateId()
    {
        return cateId;
    }

    public void setCateId(int cateId)
    {
        this.cateId = cateId;
    }

    public String getProductName()
    {
        return productName;
    }

    public void setProductName(String productName)
    {
        this.productName = productName;
    }

    public float getProductPrice()
    {
        return productPrice;
    }

    public void setProductPrice(float productPrice)
    {
        this.productPrice = productPrice;
    }

    public String getProductNum()
    {
        return productNum;
    }

    public void setProductNum(String productNum)
    {
        this.productNum = productNum;
    }

    public String getProductDisc()
    {
        return productDisc;
    }

    public void setProductDisc(String productDisc)
    {
        this.productDisc = productDisc;
    }

    public Date getProductDate()
    {
        return productDate;
    }

    public void setProductDate(Date productDate)
    {
        this.productDate = productDate;
    }

    public Pic getPics()
    {
        return pics;
    }

    public void setPics(Pic pics)
    {
        this.pics = pics;
    }

    public MultipartFile getProductPicFile()
    {
        return productPicFile;
    }

    public void setProductPicFile(MultipartFile productPicFile)
    {
        this.productPicFile = productPicFile;
    }

    public List<Order> getOrders()
    {
        return orders;
    }

    public void setOrders(List<Order> orders)
    {
        this.orders = orders;
    }

   public OrderDetail getOrderDetails()
   {
       return orderDetails;
   }

    public void setOrderDetails(OrderDetail orderDetails)
    {
        this.orderDetails = orderDetails;
    }


    @Override
    public String toString()
    {
        return "Product{" +
                "productId=" + productId +
                ", cateId=" + cateId +
                ", productName='" + productName + '\'' +
                ", productPrice=" + productPrice +
                ", productNum='" + productNum + '\'' +
                ", productDisc='" + productDisc + '\'' +
                ", productDate=" + productDate +
                ", productPicFile=" + productPicFile +
                ", pics=" + pics +
                ", orders=" + orders +
                ", orderDetails=" + orderDetails +
                '}';
    }
}
