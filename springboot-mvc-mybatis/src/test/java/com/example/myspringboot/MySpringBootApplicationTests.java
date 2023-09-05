package com.example.myspringboot;

import com.example.myspringboot.entity.City;
import com.example.myspringboot.mapper.CityMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * 1.SpringBootTest
 * JUnit5 不再需要@Runwith()
 *
 * 2.Juni5 = Junit Platform + Junit Jupiter + JUnit Vintage
 * Springboot 2.4以后不能再使用junit 4
 *
 * @ DisplayName() ：显示测试方法的别名
 * @ Test 表示方法是测试方法,可以直接运行测试
 *
 * @ Transactional :标注测试方法，测试完成后自动回滚
 *
 * 3. Redis
 *
 *
 */
@DisplayName("Spring Boot test ...")
@SpringBootTest // 使用spring的IOC进行测试

class MySpringBootApplicationTests {


    @Autowired
    CityMapper cityMapper;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    // 以对象作为key value
    @Autowired
    private RedisTemplate redisTemplate;

    //以字符串作为key value, 常用
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Test
    void contextLoads() {

        Long aLong = jdbcTemplate.queryForObject("select count(*) from student", Long.class);

        System.out.println("select count = " + aLong);
    }

    /**
     * 测试 Mybatis-plus
     */
    @DisplayName("testCityMapper")
    @Test
    void testCityMapper(){
        City city = cityMapper.getById(1L);

        System.out.println("testCityMapper = " + city);
    }

    /**
     * 读取 Redis 使用 redisTemplate 以对象作为key value
     *
     */
    @Test
    void set(){

        ValueOperations ops = redisTemplate.opsForValue();
        ops.set("age",30);
    }

    @Test
    void get(){
        ValueOperations ops = redisTemplate.opsForValue();
        Object age = ops.get("age");
        System.out.println("age==== " + age);
    }

    /**
     * 读取 Redis hash
     * redisTemplate
     */
    @Test
    void hset(){

        HashOperations ops = redisTemplate.opsForHash();
        ops.put("user","name","daweizhu");
    }

    @Test
    void hget(){
        HashOperations ops = redisTemplate.opsForHash();
        Object val = ops.get("user","name");
        System.out.println(val);
    }

    /**
     * 读取 Redis 使用 stringRedisTemplate 以字符串作为key value
     *
     */
    @Test
    void setString(){

        ValueOperations ops = redisTemplate.opsForValue();
        ops.set("age",30);
    }

    @Test
    void getString(){
        ValueOperations<String,String> ops = stringRedisTemplate.opsForValue();
        String name  = ops.get("myname");
        System.out.println(name);
    }

}

