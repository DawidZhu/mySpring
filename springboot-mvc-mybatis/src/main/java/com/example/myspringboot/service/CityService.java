package com.example.myspringboot.service;


import com.example.myspringboot.entity.City;

/**
 * Mybatis 注解模式 &MyBatis Plus
 *
 */
public interface CityService {

    public City getById(Long id);

    public void saveCity(City city);

    public void deleteById(Long id);

    /**
     * BaseMapper 自带的方法
     */
    public City getByIdPlus(Long id);
}
