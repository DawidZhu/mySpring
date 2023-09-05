package com.example.mydesignpattern.CreationalPattern.builder;

/**
 *  Director
 *
 *  指挥者类 Director 在建造者模式中具有很重要的作用，它 用于指导具体构建者如何构建产品，控制调用先后次序，
 *  并向调用者返回完整的产品类
 *  Builder focuses on constructing a complex object step by step.
 *  Abstract Factory emphasizes a family of product objects (either simple or complex).
 *  Builder returns the product as a final step, but as far as the Abstract Factory is concerned,
 *  the product gets returned immediately
 *
 *
 *  抽象工厂模式：实现对产品家族的创建，一个产品家族是这样的一系列产品:具有不同分类维度的产品组合，
 *  采用抽象工厂模式则是不需要关心构建过程，只关心什么产品由什么工厂生产即可。
 *
 *  建造者模式：则是要求按照指定的蓝图建造产品，它的主要目的是通过组装零配件而产生一个新产品.
 *   如果将抽象工厂模式看成汽车配件生产工厂，生产一个产品族的产品，那么建造者模式就是一个汽车组
 *   装工厂，通过对部件的组装可以返回一辆完整的汽车
 *
 */
public class Director {
    private Builder builder;

    /**
     * 需要一个builder参数，来实例化构造方法
     */
    public Director(Builder builder) {
        this.builder = builder;
    }

    /**
     * 按顺序 builder，并返回 产品
     * @return
     */
    public Bike buildBike(){
        builder.buildFrame();
        builder.buildSeat();
        return builder.creatBike();
    }


}
