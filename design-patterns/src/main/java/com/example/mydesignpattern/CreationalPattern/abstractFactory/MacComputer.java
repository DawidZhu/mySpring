package com.example.mydesignpattern.CreationalPattern.abstractFactory;


/**
 * 第一步：定义电脑相关的类
 * 这里面有一个为电脑安装操作系统的抽象方法，然后定义了两个实现类。
 */
public class MacComputer extends Computer {
    @Override
    public void setOperationSystem() {
        System.out.println("Mac 笔记本要安装 MAC系统");
    }
}
