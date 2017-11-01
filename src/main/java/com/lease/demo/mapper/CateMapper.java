package com.lease.demo.mapper;

import com.lease.demo.dao.Category;
import com.lease.demo.dao.Order;
import com.lease.demo.dao.OrderDetail;
import com.lease.demo.dao.Product;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Created by Administrator on 2017/10/30.
 */
public interface CateMapper {
    @Select("select * from category")
    List<Category> findAllCate();

    @Select("select * from category limit 5")
    List<Category> findFiveCate();

    @Results({
            @Result(id=true, column = "odetail_id",property = "odetailId"),
            @Result(column = "product_id",property = "productId",one =@One(select = "com.lease.demo.mapper.findAllProduct") ),
            @Result(column = "order_id",property = "orderId",many=@Many(select = "com.lease.demo.mapper.findAllOrder"))
    })
    @Select("select * from product,pic,`order`,orderdetail,category \n" +
            "where product.product_id=pic.product_id and \n" +
            "product.product_id=orderdetail.product_id and \n" +
            "`order`.order_id=orderdetail.order_id and\n" +
            "product.cate_id=category.cate_id")
    List<OrderDetail>  findLeaseRank();


    @Select("select * from product")
    List<Product> ll();
}
