package com.example.myspringboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *  跳转页面功能
 *
 *  @ RequestMapping
 *
 * 作用就是映射URL路径，将http的请求地址映射到控制器(controller)类的处理方法上。
 * 注解可以定义在控制器类上，也可以定义在类里面的方法上。
 * 定义类上：将http请求映射到该控制器上，规定初步的请求映射地址，相当于请求地址的父路径。
 * value：指定请求的实际地址，像/action/info这样的。
 * method：指定请求的method类型， GET、POST、PUT、DELETE等。
 *
 * @ Controller
 * 用于表现层bean 定义 controller 类，返回类型是：page，实现跳转页面的开发
 * 通常用于修饰controller层的组件，由控制器负责将用户发来的URL请求转发到对应的服务接口，
 * 通常还需要配合注解@RequestMapping使用。
 * Controller + ResponseBody = RestController
 *
 *  Freemarker
 * 这是一个老牌的开源的免费的模版引擎。直接使用${变量名} 在页面取数据
 * Freemarker 模版后缀为 .ftl (FreeMarker Template Language)。FTL 是一种简单的、专用的语言， 它不是像 Java 那样成熟的编程语言。
 * 在模板中，你可以专注于如何展现数据， 而在模板之外可以专注于要展示什么数据。
 *
 */

@Controller
@RequestMapping("/control")
public class MyController {

    public static final String PAGE = "view";

    /**
     * 直接返回页面，没有数据
     * 添加配置：spring mvc view suffix=.html
     * http://localhost:8080/control/view
     */
    @RequestMapping("view")
    public String view(){

        return PAGE; //view.html
    }

    /**
     * 返回数据到页面 ，使用 ModelAndView 对象
     * http://localhost:8080/control/data
     */
    @RequestMapping("/data")
    public ModelAndView data(){
        ModelAndView modelAndView = new ModelAndView(PAGE);
        modelAndView.addObject("str","hello world,数据来源 ModelAndView!!!");
      //  view.addObject("param = ", "world");
        return modelAndView; //
    }


}
