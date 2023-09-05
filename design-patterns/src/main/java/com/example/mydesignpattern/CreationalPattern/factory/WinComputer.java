package com.example.mydesignpattern.CreationalPattern.factory;

/**
 * 第二步：实现具体品牌的电脑类
 */
public class WinComputer extends Computer{
    @Override
    public void setOperationSystem() {
        System.out.println("Win 笔记本要安装Windows系统");
    }
}
