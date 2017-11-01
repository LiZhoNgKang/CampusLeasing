package com.lease.demo.service;

import com.lease.demo.dao.Category;
import com.lease.demo.dao.Product;

import java.util.List;

/**
 * Created by Administrator on 2017/10/30.
 */
public interface CateService {
    List<Category> findAllCate();

    List<Category> findFiveCate();

    List<Product>  findLeaseRank();


    List<Product> findAllProductByCateId();
}
