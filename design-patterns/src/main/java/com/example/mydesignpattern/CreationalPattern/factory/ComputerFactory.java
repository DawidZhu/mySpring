package com.example.mydesignpattern.CreationalPattern.factory;

/**
 * 第三步：定义工厂
 * 首先定义一个抽象工厂ComputerFactory 接口，里面定义了生产方法，通过这个方法就可以生产出电脑，
 * 但是生产不同品牌的电脑的具体方式肯定是不同的，例如生产小米电脑的流水线和生产苹果电脑的流水线肯定是有区别的，
 * 所以这个接口方法由具体产品工厂去实现。
 *
 * 工厂方法类 接口
 * 定义一个用于创建对象的接口，让子类决定实例化哪个产品对象。
 * 工厂方法使一个产品的实例化延迟到其子类工厂。
 * The Factory Pattern is also known as Virtual Constructor.
 *  作用：loose-coupling
 * 使用的时候，还是利用多态。
 */
public interface ComputerFactory {
    Computer makeComputer();
}
