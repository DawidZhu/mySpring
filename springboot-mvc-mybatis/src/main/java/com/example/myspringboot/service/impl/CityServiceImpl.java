package com.example.myspringboot.service.impl;

import com.example.myspringboot.entity.City;
import com.example.myspringboot.mapper.CityMapper;
import com.example.myspringboot.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

/**
 *
 * * MyBatis 注解模式，不需要配置文件，SQL 写在 Mapper 接口中
 *     MyBatis-plus 测试在 Test 中
 *  1. @Component
 *
 *   Spring 提供@Component注解的三个衍生注解，使用注解代替XML配置文件
 *  @ Controller ：用于表现层bean 定义 controller 类，return: page
 *  @ RestController = Controller + ResponseBody， return :Json    freemarker
 *  @ Service ：用于业务层bean 定义 service 类
 *  @ Repository： 用于数据层bean 定义 Dao 类
 * MyBatis 注解模式使用
 *
 *   接口是不能直接被实例化的，然而我们一般在service层中编写的注入属性都是Mapper接口
 *   如果使用Spring和MyBatis作为开发框架时，在搭建开发环境的时候，都会做一个Spring与MyBatis的整合，
 *  使用到的就是MyBatis-Spring这个中间件，MyBatis-Spring中间件把mapper接口和mapper.xml文件对应的代理类注册到Spring中，
 *  因此，在service层中就能根据类型注入，将对应mapper接口的代理类 MapperProxy 注入到service层中，这样才能够调用到对应的方法
 *
 */
@Service
// @Scope("singlton") //单例
public class CityServiceImpl implements CityService {

    @Autowired
    //Qualifier,导入指定名称的bean
    CityMapper cityMapper;

    @Override
    public City getById(Long id){

        return cityMapper.getById(id);
    }

    @Override
    public void saveCity(City city){
        cityMapper.saveCity(city);
    }

    @Override
    public void deleteById(Long id) {
        cityMapper.deleteById(id);
    }

    /**
     * BaseMapper 自带方法
     */
    @Override
    public City getByIdPlus(Long id) {
        return cityMapper.selectById(id);
    }


}
