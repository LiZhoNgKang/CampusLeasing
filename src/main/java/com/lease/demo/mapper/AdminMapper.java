package com.lease.demo.mapper;

import com.lease.demo.dao.*;
import org.apache.ibatis.annotations.*;

import java.util.List;


public interface AdminMapper
{

    @Select("select * from OrderStatus")
    List<OrderStatus> getAllOrderStatus();

    @Select("select * from category")
    List<Category> getAllCategory();

    @Select("select * from user where user_name like #{userName}")
    List<User> searchUser(String userName);





    @Select("SELECT o.order_code,u.user_name,os.ostatus_name,o.order_date \n" +
            "from `order` o ,`user` u, orderstatus os WHERE\n" +
            "o.user_id = u.user_id AND o.ostatus_id = os.ostatus_id\n" +
            "AND o.ostatus_id LIKE #{oStatusId} AND o.order_code LIKE #{orderCode}\n" +
            "AND u.user_name like #{userName} AND \n" +
            "o.order_date BETWEEN #{startDate} and #{endDate} ")
    @Results({
            @Result(id = true,column = "order_id",property = "orderId"),
            @Result(column = "order_code",property = "orderCode"),
            @Result(column = "orderDate",property = "orderDate"),
            @Result(column = "user_id",property = "user",one = @One(select = "com.lease.demo.mapper.AdminMapper.getUserById")),
            @Result(column = "ostatus_id",property = "orderStatuses",one = @One(select = "com.lease.demo.mapper.AdminMapper.getOrderStatusByOrderId"))
    })
    List<Order> searchOrder(@Param("oStatusId") String oStatusId, @Param("orderCode") String orderCode,
                            @Param("userName") String userName, @Param("startDate") String startDate,
                            @Param("endDate") String endDate);

    @Select("select user_name from user where user_id = #{userId}")
    @Results({
            @Result(id = true,column = "user_id",property = "userId"),
            @Result(column = "user_name",property = "userName")
    })
    User getUserById(String userId);

    @Select("select ostatus_name from orderstatus where order_id =#{orderId}")
    @Results({
            @Result(id = true,column = "ostatus_id",property = "ostatusId"),
            @Result(column = "ostatus_name",property = "ostatusName")
    })
    OrderStatus getOrderStatusByOrderId(String orderId);






    @Select("SELECT pd.product_name,pd.product_disc,pd.product_num,pd.product_price,p.pic_url,od.odetail_num \n" +
            "FROM product pd ,pic p,orderdetail od \n" +
            "WHERE pd.product_id=p.product_id AND od.product_id = pd.product_id\n" +
            "AND pd.product_name LIKE #{productName} AND pd.cate_id like #{productCate}\n")
//    @ResultMap(value = "productMap")
    List<Product> searchProduct(@Param("productCate") String productCate,
                                @Param("productName") String productName);
}
