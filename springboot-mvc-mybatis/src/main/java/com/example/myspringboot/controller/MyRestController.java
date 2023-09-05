package com.example.myspringboot.controller;

import com.example.myspringboot.entity.Person;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *  convention over configuration
 *
 *  REST: Representational State Transfer
 *  REST 风格访问资源是使用行为动作区分对资源进行的操作。GET,POST,PUT,DELETE
 *  资源名称通常使用复数，表示此类资源，如：users，books...
 *  RESTful: 根据REST风格对资源进行访问，称为RESTful
 *
 * 2. Value
 * 获取配置文件的值， @Value("${person.name}")
 *
 * 3. @GetMapping("user/{id}")
 *  表示只支持get请求方法，
 *  等价于@RequestMapping(value="/get",method=RequestMethod.GET)。
 *
 *  @ PostMapping(value = "user") @PutMapping("user") DeleteMapping()
 *
 *  RequestParam
 *  用于接收请求参数为表单类型的数据，通常用在方法的参数前面
 *
 *  测试获取参数
 *  @ PathVariable  获取路径变量，每个路径参数 /car/123/owner/david
 *  @ RequestHeader 获取请求头信息
 *  @ RequestParam 获取请求参数，每个参数，=传参形式  ?age=123&interests=basktable&interests=game
 *  @ RequestBody 获取请求体Jso格式，取对象
 *  @ RequestAttribute 获取请求属性
 *  @ CookieValue 获取cookie值
 *
 *  切换环境 spring.profiles.active=test
 *
 *  http://localhost:8080/rest/person
 */

@RestController
@RequestMapping("rest")
@Slf4j //for log
public class MyRestController {

    /** 赋值方式：
     * @ value 取配置文件或者直接赋值
     */
    @Value("${Person.userName}")
    private String name;

    /**
     * 读取YAML 文件, person：配置类 已注入IOC
     */
    @Autowired
    private Person person;

    /**
     * 获取 通过ConfigurationProperties 读取yml实例化的 IOC对象
     * @return
     */
    @GetMapping("person")
    @ResponseStatus(HttpStatus.OK)
    public Person getPerson(){
        log.info("getPerson .... "); // Slf4j
        return person;
    }

    /**
     * 使用 @Value， 读取 yml 配置的值
     */

    @GetMapping("yml")
    public String getProfile(){
        return "get yml name: " + name;

    }

    /**
     * 获取多种格式的参数：restful和表单
     *  http://localhost:8080/rest/123/owner/david?age=123&interests=basktable&interests=game
     */
    @GetMapping("/{id}/owner/{username}")
    public Map<String, Object> getParameters(@PathVariable("id") int id,
                                      @PathVariable("username") String username,
                                      @PathVariable Map<String, String> pv,
                                      @RequestHeader("User-Agent") String userAgent,
                                      @RequestParam("age")  int age,
                                      @RequestParam("interests") List<String> interests){
        Map<String, Object> map = new HashMap<>();

        map.put("id", id);
        map.put("username", username);
        map.put("pv", pv);
        map.put("User-Agent", userAgent);
        map.put("age", age);
        map.put("interests", interests);
        return map;

    }

}
