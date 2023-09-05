package com.example.myspringboot.controller;

import com.example.myspringboot.entity.City;
import com.example.myspringboot.service.CityService;
import com.example.myspringboot.service.impl.CityServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 *  1. RestController
 *  RestController return : Json (Object or String )
 *  JSON stands for JavaScript Object Notation
 *  JSON is a text format for storing and transporting data
 *  JSON is "self-describing" and easy to understand
 *  结合： RequestMapping，GetMapping， PostMapping
 *
 *  @ RestController = Controller + ResponseBody， return :Json    freemarker
 *
 *  PathVariable
 *  restful 风格,@ RequestMapping("/path/{id}/{type}")
 *  用于获取请求路径中的参数，通常用于restful风格的api上.
 *   @ PathVariable("id")
 *
 *  @ RequestBody
 *  表示请求体的Content-Type必须为application/json格式的数据，接收到数据之后会自动将数据绑定到Java对象上去
 *  前端发送json封装的对象给后端，后端使用java对象来接收。
 *
 * @ Autowired 注入的是接口，而不是实现类，下面应该写接口
 *
 *  该接口只有 这一个实现类，那么在引用实现类的时候，我们使用的是实现类的接口
 *  Spring会按 byType的方式寻找接口的实现类，将其注入。
 *  * 这个其实是创建了实现类的对象但引用了接口类型，即"InjectionDao injectionDao = new InjectionDaoImpl()",
 *  * 这个其实是Java多态性（向上转型）的一种应用
 *
 *  @ Service 注解是标注在实现类上的
 *  因为@Service是把spring容器中的bean进行实例化，也就是等同于new操作，
 *  只有实现类是可以进行new实例化的，而接口则不能，所以是加在实现类上的。
 *
 */

@RestController //  = Controller + ResponseBody， return :Json    freemarker
@RequestMapping("/city")
public class CityRestController {

    @Autowired  // 注入的是接口，而不是实现类
    CityService cityService;

//    @Autowired
//    CityServiceImpl cityService1;

    /**
     * http://localhost:8080/city/1
     * @param id
     * @return
     */
    @GetMapping("{id}")
    public City getById(@PathVariable("id") Long id){

        return cityService.getById(id);
    }

    /**
     * 使用 Mybatis plus
     * 直接使用 BaseMapper 的CRUD 方法，不需要写任何SQL，类似Hibernate JPA
     */
    @GetMapping("/plus/{id}")
    public City getByIdPlus(@PathVariable("id") Long id){
        return cityService.getByIdPlus(id);

    }

    /**
     * 新增
     * RequestBody 注解： 表示请求体的Content-Type必须为application/json格式的数据，
     * 接收到数据之后会自动将数据绑定到Java对象上去
     * http://localhost:8080/city/save
     */
    @PostMapping("save")
    public void saveCity(@RequestBody City city){

        cityService.saveCity(city);
    }

    /**
     *删除
     * @param id
     */
    @DeleteMapping("city/{id}")
    public void deleteById(@PathVariable("id") Long id){
        cityService.deleteById(id);
    }
}
