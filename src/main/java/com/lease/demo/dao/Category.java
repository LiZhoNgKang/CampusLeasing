package com.lease.demo.dao;

import org.springframework.web.multipart.MultipartFile;

public class Category
{
    private int cateId;
    private String cateName;
    private String catePic;
    private MultipartFile catePicFile;

    public Category()
    {
        super();
    }

    public Category(int cateId, String cateName, String catePic)
    {
        this.cateId = cateId;
        this.cateName = cateName;
        this.catePic = catePic;
    }

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

    public MultipartFile getCatePicFile()
    {
        return catePicFile;
    }

    public void setCatePicFile(MultipartFile catePicFile)
    {
        this.catePicFile = catePicFile;
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
