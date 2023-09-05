package com.example.mydesignpattern.StructuralPattern.Decorator;

/**
 * Decorator Pattern
 *  装饰模式是在不必改变原类和使用继承的情况下，动态地扩展一个对象的功能。它是通过创建一个包装对象，也就是装饰来包裹真实的对象
 *
 *  Real-World：
 *  Wearing clothes is an example of using decorators. When you’re cold, you wrap yourself in a sweater.
 *  If you’re still cold with a sweater, you can wear a jacket on top. If it’s raining, you can put on a raincoat.
 *  All of these garments “extend” your basic behavior but aren’t part of you, and you can easily
 *  take off any piece of clothing whenever you don’t need it.
 *
 * 配料类
 * 抽象装饰(Decorator)角色 : 继承或实现抽象构件，并包含具体构件的实例，可以通过其子 类扩展具体构件的功能
 * 装饰器模式 允许向一个现有的对象添加新的功能，同时又不改变其结构。
 * 这种类型的设计模式属于结构型模式，它是作为现有的类的一个包装。 这种模式创建了一个装饰类，
 * 用来包装原有的类，并在保持类方法签名完整性的前提下，提供了额外的功能
 *
 * 装饰者模式的精髓在于动态的给对象增减功能，往接口定义的方法里面加功能！
 *
 * Decorator is also called "Smart Proxy." This is used when you want to add functionality to an object,
 * but not by extending that object's type. This allows you to do so at runtime.
 *
 * 简单说，就是装饰器包装对象，从而获得额外的功能。
 * 装饰模式，形象的说，就像一个礼物盒子里面还装着礼物盒子…最后一个礼物盒子装着礼物本体，礼物本体就是原始对象，而每个礼物盒子就是装饰器。
 *
 * A Decorator Pattern says that just "attach a flexible additional responsibilities to an object dynamically".
 * In other words, The Decorator Pattern uses composition instead of inheritance to extend the
 * functionality of an object at runtime.
 *
 * 优点：
 * 可以提供比继承更加灵活的方式去扩展对象的功能，通过排列组合，可以对某个类的一些对象做动态的功能扩展，而不需要装饰的对象却可以保持原样。
 */
public abstract class Decorator extends FastFood{

    /**
     * 并包含具体构建的实例
     */
    private FastFood fastFood;

    public FastFood getFastFood() {
        return fastFood;
    }

    public void setFastFood(FastFood fastFood) {
        this.fastFood = fastFood;
    }

    public Decorator(FastFood fastFood) {
        this.fastFood = fastFood;
    }

    public Decorator(float price, String desc, FastFood fastFood) {
        super(price, desc);
        this.fastFood = fastFood;
    }


}
