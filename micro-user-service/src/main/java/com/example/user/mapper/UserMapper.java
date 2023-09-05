package com.example.user.mapper;

import com.example.user.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * MyBatis 注解模式
 * Mybatis 使用Mapper; 注解 @ Mapper
 * Hibernate 使用 JPA Repository， 注解 @Entiry
 *
 * 接口不能被实例化，实际注入的是 MapperProxy
 *
 * Mapper 所有方法执行相同的操作：找到对应的SQL，绑定参数，返回SQL执行结果
 */
@Mapper
public interface UserMapper {
    /**
     * Select 注解
     */
    @Select("select * from tb_user where id = #{id}")
    User findById(Long id);
    // User findById(@Param("id") Long id);
}