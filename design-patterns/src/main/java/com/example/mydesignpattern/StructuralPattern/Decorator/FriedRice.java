package com.example.mydesignpattern.StructuralPattern.Decorator;

/**
 * 装饰者类，继承基类
 */
public class FriedRice extends FastFood{

    /**
     * 装饰模式是在不必改变原类的情况下，使用继承，动态地扩展一个对象的功能。
     * 它是通过创建一个包装对象，也就是装饰来包裹真实的对象
     */
    public FriedRice() {
    }

    /**
     * 调用父类构造方法
     * @param price
     * @param desc
     */
    public FriedRice(float price, String desc) {
        super(price, desc);
    }

    @Override
    public float cost() {
        return getPrice();
    }
}
