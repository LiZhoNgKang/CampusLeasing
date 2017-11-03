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
            @Result(column = "ostatus_id",property = "orderStatuses",one = @One(select = "com.lease.demo.mapper.AdminMapper.getOrderStatusByOrderStatusId"))
    })
    List<Order> searchOrder(@Param("oStatusId") String oStatusId, @Param("orderCode") String orderCode,
                            @Param("userName") String userName, @Param("startDate") String startDate,
                            @Param("endDate") String endDate);

    @Select("select user_name from user where user_id=#{userId}")
    User getUserById(String userId);

    @Select("select ostatus_name from OrderStatus where ostatus_id=#{oStatusId}")
    OrderStatus getOrderStatusByOrderStatusId(String oStatusId);






    @Select("SELECT pd.product_name,pd.product_disc,pd.product_num,pd.product_price,p.pic_url,od.odetail_num \n" +
            "FROM product pd ,pic p,orderdetail od \n" +
            "WHERE pd.product_id=p.product_id AND od.product_id = pd.product_id\n" +
            "AND pd.product_name LIKE #{productName} AND pd.cate_id like #{productCate}\n")
    @Results({
            @Result(id = true,column = "product_id",property = "productId"),
            @Result(column = "product_name",property = "productName"),
            @Result(column = "product_disc",property = "productDisc"),
            @Result(column = "product_num",property = "productNum"),
            @Result(column = "product_price",property = "productPrice"),
            @Result(column = "product_id",property = "productId",many = @Many(select = "com.lease.demo.mapper.AdminMapper.getPicByProductId")),
            @Result(column = "product_id",property = "orderDetails",many = @Many(select = "com.lease.demo.mapper.AdminMapper.getOrderDetailByProductId"))
    })
    List<Product> searchProduct(@Param("productCate") String productCate,
                                @Param("productName") String productName);


    @Select("select pic_url from pic where product_id=#{productId}")
    Pic getPicByProductId(String productId);

    @Select("select odetail_num from orderdetail where product_id=#{productId}")
    List<OrderDetail> getOrderDetailByProductId(String productId);

    @Insert("insert into user(user_name,password,user_sex,mobile,rank) " +
            "values(#{userName},#{password},#{userSex},#{mobile},1)")
    boolean addNewUser(User user);

    @Insert("insert into Category(cate_name,cate_pic) values(#{cateName},#{pic})")
    boolean addCate(@Param("cateName") String cateName, @Param("pic") String pic);

    @Insert("insert into product(cate_id,product_name,product_price,product_num,product_disc,product_date)" +
            " values(#{cateId},#{productName},#{productPrice},#{productNum},#{productDisc},#{productDate})")
    boolean addProduct(Product product);

    @Select("select max(product_id) from product")
    String getMaxProductId();

    @Insert("insert into pic(product_id,pic_url) values(#{maxProductId},#{image})")
    boolean addProductPic(@Param("maxProductId") String maxProductId, @Param("image") String image);
}
