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





    @Select("<script>SELECT o.order_id,o.order_code,u.user_name,u.user_id,os.ostatus_name,os.ostatus_id,o.order_date \n" +
            "from `order` o ,`user` u, orderstatus os WHERE \n" +
            "o.user_id = u.user_id AND o.ostatus_id = os.ostatus_id \n" +
            "AND o.order_code LIKE #{orderCode} \n" +
            "AND u.user_name like #{userName} AND \n" +
            "o.order_date BETWEEN #{startDate} and #{endDate} \n" +
            "<if test=\"oStatusId != 0\">\n" +
            "    AND o.ostatus_id =#{oStatusId}\n" +
            "  </if></script> ")
    @Results({
            @Result(id = true,column = "order_id",property = "orderId"),
            @Result(column = "order_code",property = "orderCode"),
            @Result(column = "order_date",property = "orderDate"),
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






//    动态SQL需要加个<script></script>
    @Select("<script>select pt.product_id,pt.product_name,pt.product_disc,pt.product_price,\n" +
            "pc.pic_id,pc.pic_url,o.order_id,od.odetail_id,od.odetail_num \n" +
            "from product pt,pic pc,`order` o,orderdetail od \n" +
            "where pt.product_id=pc.product_id and \n" +
            "pt.product_id=od.product_id and \n" +
            "o.order_id=od.order_id \n" +
            "AND pt.product_name like #{productName} \n" +
            "<if test=\"cateId != 0\">\n" +
            "    AND pt.cate_id =#{cateId}\n" +
            "  </if></script>")
    @Results({
            @Result(id = true,column = "product_id",property = "productId"),
            @Result(column = "product_name",property = "productName"),
            @Result(column = "product_disc",property = "productDisc"),
            @Result(column = "product_num",property = "productNum"),
            @Result(column = "product_price",property = "productPrice"),
            @Result(column = "pic_id",property = "pics",many = @Many(select = "com.lease.demo.mapper.AdminMapper.getPicByProductId")),
            @Result(column = "odetail_id",property = "orderDetails",many = @Many(select = "com.lease.demo.mapper.AdminMapper.getOrderDetailByProductId"))
    })
//    搜索商品，显示搜索的商品
    List<Product> searchProduct(@Param("cateId") String cateId,@Param("productName") String productName);


    @Select("select pic_id,pic_url from pic where product_id=#{productId}")
    @Results({
            @Result(id = true,column = "pic_id",property = "picId"),
            @Result(column = "pic_url",property = "picUrl")
    })
    List<Pic> getPicByProductId(String productId);

    @Select("select odetail_id,odetail_num from orderdetail where product_id=#{productId}")
    @Results({
            @Result(id=true,column="odetail_id",property="odetailId"),
            @Result(column="odetail_num",property="odetailNum"),
    })
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

    @Select("select * from user where user_id =#{userId}")
    User findUserByUserId(String userId);

    @Update("update user set password=#{password},user_sex=#{userSex}, " +
            "address=#{address} ,mobile=#{mobile} where user_id=#{userId}")
    boolean updateUser(User user);

    @Select("select * from category where cate_id =#{cateId}")
    Category getCateByCateId(String cateId);


    @Update("update category set cate_pic=#{img},cate_name=#{cateName} where cate_id=#{cateId}")
    boolean updateCate(@Param("cateId") String cateId,@Param("cateName") String cateName,@Param("img") String img);

    @Delete("DELETE FROM category WHERE cate_id=#{cateId}")
    boolean delCateByCateId(String cateId);

    @Delete("DELETE FROM product WHERE cate_id=#{cateId}")
    boolean delProductByCateId(String cateId);

    @Select("select * from `order` where user_id=#{userId}")
    List<Order> findOrderByUserId(String userId);

    @Delete("delete from user where user_id=#{userId}")
    boolean delUserByUserId(String userId);

    @Select("select product_id from product where cate_id=#{cateId}")
    List<String> getProductIdByCateId(String cateId);

    @Delete("delete from pic where product_id =#{o}")
    boolean delPicByProductId(String o);

    @Select("SELECT\n" +
            "\tpt.product_name,pt.product_id,\n" +
            "\tc.cate_name,c.cate_id,\n" +
            "\tpt.product_price,\n" +
            "\tpt.product_disc,\n" +
            "\tpt.product_date\n" +
            "FROM\n" +
            "\tproduct pt,\n" +
            "\tpic p,\n" +
            "\tcategory c\n" +
            "WHERE\n" +
            "\tpt.product_id = p.product_id\n" +
            "AND pt.cate_id = c.cate_id\n" +
            "AND pt.product_id =#{productId}")
    @Results({
            @Result(id = true,column = "product_id",property = "productId"),
            @Result(column = "product_name",property = "productName"),
            @Result(column = "product_disc",property = "productDisc"),
            @Result(column = "product_date",property = "productDate"),
            @Result(column = "product_price",property = "productPrice"),
            @Result(column = "pic_id",property = "pics",many = @Many(select = "com.lease.demo.mapper.AdminMapper.getPicByProductId")),
            @Result(column = "cate_id",property = "category",one = @One(select = "com.lease.demo.mapper.AdminMapper.getCateByCateId"))
    })
    Product findProductByProduct(String productId);

    @Update("update product set product_name=#{productName},cate_id=#{cateId}," +
            "product_price=#{productPrice},product_disc=#{productDisc},product_date=#{productDate}" +
            " where product_id=#{productId}")
    boolean updateProduct(Product product);

    @Update("update pic set pic_url=#{img} where product_id=#{productId}")
    boolean updatePicByProductId(@Param("productId") Integer productId,@Param("img") String img);

    @Delete("DELETE FROM product WHERE product_id =#{productId}")
    boolean delProductByProductId(String productId);

    @Delete("delete from OrderDetail where order_id=#{orderId}")
    boolean delOrderDetailsByOrderId(String orderId);

    @Delete("delete from order where order_id=#{orderId}")
    boolean delOrderByOrderId(String orderId);
}
