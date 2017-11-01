package com.lease.demo.mapper;

import com.lease.demo.dao.Pic;
import com.lease.demo.dao.Product;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by Administrator on 2017/10/31.
 */
public interface ProductMapper {
    @Select("select * from product,pic where product.product_id=pic.product_id ")
    @Results({
            @Result(id=true,column="product_id",property="productId"),
            @Result(column="product_name",property="productName"),
            @Result(property="pics",column="pic_id",many=@Many(select="com.lease.demo.mapper.ProductMapper.getPicByProductId"))

    })
    List<Product> findAllProduct();

    @Select("select * from pic where product_id=#{productId}")
    @Results({
            @Result(id=true,column="pic_id",property="picId"),
            @Result(column="pic_url",property="picUrl"),
    })
    List<Pic> getPicByProductId(String productId);

    @Select("select * from product,pic where product.product_id=pic.product_id and product.cate_id = #{cateId}")
    @Results({
            @Result(id=true,column="product_id",property="productId"),
            @Result(column="product_name",property="productName"),
            @Result(property="pics",column="pic_id",many=@Many(select="com.lease.demo.mapper.ProductMapper.getPicByProductId"))

    })
    List<Product> getProductByCateId(String cateId);

    @Select("select * from product,pic where product.product_id=pic.product_id and product.product_id= #{productId}")
    @Results({
            @Result(id=true,column="product_id",property="productId"),
            @Result(column="product_name",property="productName"),
            @Result(property="pics",column="pic_id",many=@Many(select="com.lease.demo.mapper.ProductMapper.getPicByProductId"))

    })
    List<Product> findAllProductDetail(String productId);
}
