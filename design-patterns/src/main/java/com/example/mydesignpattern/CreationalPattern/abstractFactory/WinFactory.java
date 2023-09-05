package com.example.mydesignpattern.CreationalPattern.abstractFactory;

/**
 *  Abstract Factory模式：Abstract Factory模式是一系列对象的创建，所以在抽象工厂类里面要创建一系列的对象的实例化，
 *  而不是单个对象的实例化。 切记这一系列对象存在一定的联系。
 */
public class WinFactory implements AbstractFactory{
    @Override
    public Computer makeComputer() {
        return new WinComputer();
    }

    @Override
    public Phone makePhone() {
        return new WinPhone();
    }
}
