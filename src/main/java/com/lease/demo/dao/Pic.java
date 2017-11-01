package com.lease.demo.dao;

public class Pic
{
    private int picId;
    private String picUrl;
    private int productId;
    private Product product;


    public int getPicId()
    {
        return picId;
    }

    public void setPicId(int picId)
    {
        this.picId = picId;
    }

    public String getPicUrl()
    {
        return picUrl;
    }

    public void setPicUrl(String picUrl)
    {
        this.picUrl = picUrl;
    }

    public int getProductId()
    {
        return productId;
    }

    public void setProductId(int productId)
    {
        this.productId = productId;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public String toString() {
        return "Pic{" +
                "picId=" + picId +
                ", picUrl='" + picUrl + '\'' +
                ", productId=" + productId +
                ", product=" + product +
                '}';
    }
}
