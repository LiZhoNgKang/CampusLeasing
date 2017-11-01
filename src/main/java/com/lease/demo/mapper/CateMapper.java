package com.lease.demo.mapper;

import com.lease.demo.dao.Category;
import com.lease.demo.dao.OrderDetail;
import com.lease.demo.dao.Product;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by Administrator on 2017/10/30.
 */
public interface CateMapper {
    @Select("select * from category")
    List<Category> findAllCate();

    @Select("select * from category limit 5")
    List<Category> findFiveCate();


    @Select("select * from product,pic,`order`,orderdetail,category \n" +
            "where product.product_id=pic.product_id and \n" +
            "product.product_id=orderdetail.product_id and \n" +
            "`order`.order_id=orderdetail.order_id and\n" +
            "product.cate_id=category.cate_id order by odetail_num desc limit 4")
    @Results({
            @Result(id=true,column="product_id",property="productId"),
            @Result(column="product_name",property="productName"),
            @Result(column = "product_disc",property = "productDisc"),
            @Result(property="pics",column="pic_id",many=@Many(select="com.lease.demo.mapper.ProductMapper.getPicByProductId")),
            @Result(property="category",column="cate_id",many=@Many(select="com.lease.demo.mapper.CateMapper.getCateByProductId")),
            @Result(property="orderDetails",column="odetail_id",many=@Many(select="com.lease.demo.mapper.CateMapper.getOrderDetailByProductId"))

    })

    List<Product>  findLeaseRank();

    @Select("select * from category where cate_id=#{cateId}")
    @Results({
            @Result(id=true,column="cate_id",property="cateId"),
            @Result(column="cate_name",property="cateName"),
    })
    List<Category> getCateByProductId(String cateId);

    @Select("select * from orderDetail where product_id=#{productId}")
    @Results({
            @Result(id=true,column="odetail_id",property="odetailId"),
            @Result(column="odetail_num",property="odetailNum"),
    })
    List<OrderDetail> getOrderDetailByProductId(String productId);

}
