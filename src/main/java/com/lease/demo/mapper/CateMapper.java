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


    @Select("select pt.product_id,pt.product_name,pt.product_disc,pt.product_price,\n" +
            "pc.pic_id,pc.pic_url,o.order_id,od.odetail_id,od.odetail_num,c.cate_id,c.cate_name \n" +
            "from product pt,pic pc,`order` o,orderdetail od,category c \n" +
            "where pt.product_id=pc.product_id and \n" +
            "pt.product_id=od.product_id and \n" +
            "o.order_id=od.order_id and\n" +
            "pt.cate_id=c.cate_id order by od.odetail_num desc limit 4")
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
