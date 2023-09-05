package com.example.mydesignpattern.StructuralPattern.Decorator;

/**
 * 装饰者类，继承基类
 * 具体构件(Concrete Component)角色 :实现抽象构件，通过装饰角色为其添加一些职责
 */
public class FriedNoodles extends FastFood{


    /**
     * 装饰模式是在不必改变原类的情况下，使用继承，动态地扩展一个对象的功能。
     * 它是通过创建一个包装对象，也就是装饰来包裹真实的对象
     */
    public FriedNoodles() {
    }

    public FriedNoodles(float price, String desc) {
        super(price, desc);
    }

    @Override
    public float cost() {
        return getPrice();
    }
}
