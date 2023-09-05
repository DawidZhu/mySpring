package com.example.myspringboot.mapper;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.myspringboot.entity.City;
import org.apache.ibatis.annotations.*;

/**
 * HikariDataSource
 *
 * 1. Mybatis是一个持久层框架
 *  操作数据库的Mapper 接口
 *  1.使用@Mapper将CityMapper接口交给Spring进行管理
 *  2.不用写Mapper映射文件（XML）
 *  3.为这个CityMapper接口生成一个实现类，让别的类进行引用
 *
 *  整合MyBatis步骤：
 *  1.POM文件引入mybatis-stater,
 *  2.配置application.yml 相关参数，
 *  3.编写Mapper接口并标注Mapper注解，
 *  4.简单方法直接注解方式，复杂可考虑用XML绑定映射
 *
 * Mybatis 注解模式 (不再需要xml文件) & MyBatis Plus，SQL 写在 Mapper 接口中
 *
 * 2. MyBatis-plus :
 *    extends BaseMapper<City> 是 Mybaatis plus在使用
 *    MyBatisPlus是一个MYBatis的增强工具，简化开发，提高效率，将通用的CRUD方法封装在BaseMapper中。
 *   @ Select： 使用注解模式，直接写查询语句，不再需要XML配置文件
 *   @ Insert、@Delete、@Update、@Select
 *   放在Test中测试MyBatis-plus
 *
 *  3.TableName
 *    @ TableName("city") //for MyBatis PLus
 *    在实体类上指定，指定实体类和数据库表的映射关系。当实体类的类名在转成小写后和数据库表名相同时，可以不指定该注解。
 *
 */

@Mapper
@TableName("city") //for MyBatis PLus
public interface CityMapper extends BaseMapper<City> {

    /**
     * MyBatis 注解模式
     */
    @Select("select * from city where id=#{id}")
    public City getById(Long id);

    /**
     * MyBatis 注解模式
     * 注意Insert 语句格式
     */
    @Insert( {"insert into city(name,state,country) values(#{name}, #{state}, #{country})"} )
    @Options(useGeneratedKeys = true, keyProperty = "id")
    public void saveCity(City city);

    /**
     * Delete 根据id删除
     * @param id
     */
    @Delete("delete from city where id=#{id}")
    public void deleteById(Long id);

}
