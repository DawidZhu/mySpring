package com.example.mydesignpattern.CreationalPattern.builder;

/**
 * 具体的建造者 builder
 * implementation classes
 * 实现 Builder 接口，完成复杂产品的各个部件的具体 创建方法。在构造过程完成后，提供产品的实例
 */
public class MobBuilder extends Builder{
    @Override
    public void buildFrame() {
        bike.setFrame("MobFrame");
    }

    @Override
    public void buildSeat() {
        bike.setSeat("MobSeat");
    }

    @Override
    public Bike creatBike() {
        return bike;
    }
}
