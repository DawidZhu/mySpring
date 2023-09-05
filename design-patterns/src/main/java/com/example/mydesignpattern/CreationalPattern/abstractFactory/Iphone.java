package com.example.mydesignpattern.CreationalPattern.abstractFactory;

/**
 *  第二步：定义手机相关的类
 *  里面有一个为手机安装操作系统的抽象方法，然后定义两个实现类
 */
public class Iphone extends Phone{
    @Override
    public void setOperationSystem() {
        System.out.println("苹果手机安装IOS系统");
    }
}
