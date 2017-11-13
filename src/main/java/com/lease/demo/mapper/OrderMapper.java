package com.lease.demo.mapper;

import com.lease.demo.dao.Order;
import com.lease.demo.dao.Product;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by Administrator on 2017/11/8.
 */
public interface OrderMapper {

    @Insert("insert into `order`(user_id,order_code,order_date,order_addr,ostatus_id) values(#{userId},#{orderCode},now(),#{userAddr},2)")
    boolean addProductToShopCart(@Param("userId") Object userId,
                                 @Param("userAddr") String userAddr, @Param("orderCode") String orderCode);

    @Select("select max(order_id) from `order`")
    String findMaxOrderId();

    @Insert("insert into orderdetail(order_id,product_id,odetail_price,odetail_name,odetail_pic,odetail_num,odetail_day) " +
            "values(#{orderId},#{productId},#{price},#{productName},#{productPic},#{odetailNum},#{odetailDay})")
    boolean addShopCart(@Param("orderId") String orderId, @Param("productId") String productId,
                        @Param("price") Float price, @Param("productName") String productName,
                        @Param("productPic") String productPic, @Param("odetailNum") String odetailNum,
                        @Param("odetailDay") String odetailDay);

    @Insert("insert into `order`(user_id,order_code,order_date,order_addr,ostatus_id) values(#{userId},#{orderCode},now(),#{userAddr},3)")
    boolean addRent(@Param("userId") Object userId,
                    @Param("userAddr") String userAddr, @Param("orderCode") String orderCode);

    @Insert("insert into orderdetail(order_id,product_id,odetail_price,odetail_name,odetail_pic,odetail_num,odetail_day) " +
            "values(#{orderId},#{productId},#{price},#{productName},#{productPic},#{odetailNum},#{odetailDay})")
    boolean addRentToOrderDetail(@Param("orderId") String orderId, @Param("productId") String productId,
                                 @Param("price") Float price, @Param("productName") String productName,
                                 @Param("productPic") String productPic, @Param("odetailNum") String odetailNum,
                                 @Param("odetailDay") String odetailDay);
}
