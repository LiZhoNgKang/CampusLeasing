package com.lease.demo.service.impl;

import com.lease.demo.dao.Category;
import com.lease.demo.dao.Product;
import com.lease.demo.mapper.CateMapper;
import com.lease.demo.service.CateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2017/10/30.
 */
@Service
public class CateServiceImpl implements CateService {
    @Autowired
    private CateMapper cateMapper;
    @Override
    public List<Category> findAllCate() {
        return cateMapper.findAllCate();
    }

    @Override
    public List<Category> findFiveCate() {
        return cateMapper.findFiveCate();
    }

    @Override
    public List<Product>  findLeaseRank() {
        return cateMapper.findLeaseRank();
    }

    @Override
    public List<Product> findAllProductByCateId() {
        return null;
    }


}
