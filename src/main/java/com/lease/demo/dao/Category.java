package com.lease.demo.dao;


public class Category
{
    private int cateId;
    private String cateName;
    private String catePic;

    public int getCateId()
    {
        return cateId;
    }

    public void setCateId(int cateId)
    {
        this.cateId = cateId;
    }

    public String getCateName()
    {
        return cateName;
    }

    public void setCateName(String cateName)
    {
        this.cateName = cateName;
    }

    public String getCatePic()
    {
        return catePic;
    }

    public void setCatePic(String catePic)
    {
        this.catePic = catePic;
    }

    @Override
    public String toString()
    {
        return "Category{" +
                "cateId=" + cateId +
                ", cateName='" + cateName + '\'' +
                ", catePic='" + catePic + '\'' +
                '}';
    }
}
