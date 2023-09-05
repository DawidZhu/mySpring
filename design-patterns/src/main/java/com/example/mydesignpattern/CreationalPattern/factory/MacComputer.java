package com.example.mydesignpattern.CreationalPattern.factory;

/**
 * 第二步：实现具体品牌的电脑类
 */
public class MacComputer extends Computer{
    @Override
    public void setOperationSystem() {
        System.out.println("Mac 笔记本要安装 MAC系统");
    }
}
