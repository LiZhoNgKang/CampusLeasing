package com.lease.demo.service;

import com.lease.demo.dao.Product;

import java.util.List;

/**
 * Created by Administrator on 2017/10/31.
 */
public interface ProductService {


    List<Product> findAllProductByCateId();

    List<Product> getProductByCateId(String cateId);

    List<Product> getProductDetailsByProductId(String productId);

    Boolean addNewProduct(Product product);

    String getMaxProductId();



    boolean addPic(String productId, String image);

    List<Product> getProductListByProductName(String productName);
}
