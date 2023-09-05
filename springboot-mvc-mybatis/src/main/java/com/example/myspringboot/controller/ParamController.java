package com.example.myspringboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

/**
 * 1.@RequestParam
 *
 *  表单传参形式，http://localhost:8080/param?id=999&type=qqq
 *  @ RequestMapping("/param")  @RequestParam(value = "id") int id
 *  用于接收请求参数为表单类型的数据，通常用在方法的参数前面.
 *
 *  ModelAndView:
 *  使用ModelAndView类用来存储处理完后的结果数据，以及显示该数据的视图
 *  ModelAndView is a value object designed to hold model and view making it possible for
 *  a handler to return both model and view in a single return value.
 *
 * 2.ResponseBody
 *  表示该方法的返回结果直接写入HTTP response body中，返回数据的格式为application/json。
 *
 */
@Controller // 返回页面
public class ParamController {

    public static final String PAGE = "param"; //param.html

    /**
     * 使用 RequestParam
     * http://localhost:8080/param?id=999&type=qqq
     */
    @RequestMapping("/param")
    public ModelAndView getparam(@RequestParam(value = "id", defaultValue = "0") int id,
                              @RequestParam(value = "type", required = false, defaultValue = "") String type){
        if(null != type){
        }
        System.out.println("id = " + id);
        ModelAndView modelAndView = new ModelAndView(PAGE);
        modelAndView.addObject("id",id);
        modelAndView.addObject("type",type);
        return modelAndView;

    }

    /**
     * 使用 PathVariable
     * http://localhost:8080/path/123/david
     */
    @RequestMapping("/path/{id}/{type}")
    public ModelAndView path(@PathVariable(required = false) int id,
                             @PathVariable(required = false) String type){

        ModelAndView modelAndView = new ModelAndView(PAGE);
        modelAndView.addObject("id",id);
        modelAndView.addObject("type",type);
        return modelAndView;

    }


}