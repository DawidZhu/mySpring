package com.example.user.controller;

import com.example.user.model.User;
import com.example.user.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 * RestController
 * controller层，接受前端的请求并返回
 *
 * http://localhost:8081/user/1
 */
@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {

    /**
     * 自动加载，接口
     * 用@Autowired的时候，到底是写接口的名字还是实现类的名字： 用接口名称
     * @ Autowired，Spring会按 byType的方式寻找接口的实现类，将其注入。存在多个实现类，应该指定名字，
     * 可以通过 byName 注入的方式。可以使用 @Resource 或 @Qualifier 注解。
     */
    @Autowired
    private UserService userService;

    /**
     * 路径： /user/110
     *@ RequestHeader("Author") 测试Gateway filter,  添加 请求头使用
     */
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public User queryById(@PathVariable("id") Long id, @RequestHeader(value ="Author", required = false) String author) {
       System.out.println("Gateway filter Author is : " + author);
       log.info("Gateway filter Author: {}" + author);
        return userService.queryById(id);
    }
}
