package com.lease.demo.dao;

public class Pic
{
    private int picId;
    private String picUrl;
    private int productId;

    public Pic()
    {
        super();
    }

    public Pic(int picId, String picUrl, int productId)
    {
        this.picId = picId;
        this.picUrl = picUrl;
        this.productId = productId;
    }

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

    @Override
    public String toString()
    {
        return "Pic{" +
                "picId=" + picId +
                ", picUrl='" + picUrl + '\'' +
                ", productId=" + productId +
                '}';
    }
}
