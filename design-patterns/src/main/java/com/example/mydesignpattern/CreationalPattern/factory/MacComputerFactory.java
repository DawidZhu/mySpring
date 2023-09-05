package com.example.mydesignpattern.CreationalPattern.factory;

/**
 * 实现了生成苹果电脑的MacComputerFactory 工厂
 * 具体的工厂类，继承工厂类接口
 *
 * Factory 模式：使一个类的实例化延迟到子类，具体来讲，
 * 就是Factory 模式将创建对象实例的责任转移到工厂类，也就是说在工厂类里面，定义对象的实例化。
 */
public class MacComputerFactory implements ComputerFactory{
    @Override
    public Computer makeComputer() {
        return new MacComputer();
    }
}
