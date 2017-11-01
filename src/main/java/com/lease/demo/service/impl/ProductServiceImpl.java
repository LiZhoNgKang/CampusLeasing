package com.lease.demo.service.impl;

import com.lease.demo.dao.Product;
import com.lease.demo.mapper.ProductMapper;
import com.lease.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2017/10/31.
 */
@SuppressWarnings("all")
@Service
public class ProductServiceImpl implements ProductService{
    @Autowired
    private ProductMapper productMapper;


    @Override
    public List<Product> findAllProductByCateId() {

        return productMapper.findAllProduct();

    }

    @Override
    public List<Product> getProductByCateId(String cateId) {
        return productMapper.getProductByCateId(cateId);
    }

//    @Override
//    public Boolean addNewProduct(Product product) {
//        return productMapper.addNewProduct(product);
//    }

}
