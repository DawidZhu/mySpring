package com.example.mydesignpattern.CreationalPattern.factory;

/**
 * 第一步：定义一个电脑的抽象基类
 * 里面有一个为电脑安装操作系统的抽象方法，这个就是产品要实现的共同接口。
 */
public abstract class Computer {
    public abstract void setOperationSystem();
}
