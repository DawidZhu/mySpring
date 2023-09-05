package com.example.order.mapper;

import com.example.order.model.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * Mapper 接口
 * SpringBootApplication 有Mapperscan(),这里可以不用写Mapper注解
 *
 */
@Mapper
public interface OrderMapper {

    @Select("select * from tb_order where id = #{id}")
    Order findById(Long id);
}
