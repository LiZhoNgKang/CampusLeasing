package com.lease.demo.service;

import com.lease.demo.dao.Product;

import java.util.List;

/**
 * Created by Administrator on 2017/10/31.
 */
public interface ProductService {


    List<Product> findAllProductByCateId();

    List<Product> getProductByCateId(String cateId);

//    Boolean addNewProduct(Product product);
}
