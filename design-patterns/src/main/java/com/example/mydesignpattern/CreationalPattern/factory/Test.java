package com.example.mydesignpattern.CreationalPattern.factory;

/**
 * 第四步：客户端使用
 * 使用具体的工厂来生产相应品牌的电脑，例如要生产Mac电脑，就先构建Mac的生产工厂，然后去生产mac电脑。
 *
 * 优点：不直接在客户端创建具体产品的实例，降低了耦合性。
 * 缺点：每增加一种产品就要相应的增加一个工厂类，类增多了。
 *
 * 技术要点总结:
 * 构建的都是同一类型的对象，即实现相同的接口
 * 每一类对象对应一个工厂
 *
 * Factory Pattern
 * or Factory Method
 *
 * says that just define an interface or abstract class for creating an object
 * but let the subclasses decide which class to instantiate.
 * In other words, subclasses are responsible to create the instance of the class.
 *
 *  * The main difference between a "factory method" and an "abstract factory" is that
 *  * the factory method is a method, and an abstract factory is an object.
 * 源码：Collection.iterator
 * Collection接口是抽象工厂类，ArrayList是具体的工厂类;Iterator接口是抽象商品类，
 * ArrayList类中的Iter内部类是具体的商品类。在具体的工厂类中iterator()方法创建具体的商品 类的对象。
 *
 * 工厂方法模式只有1种create， 当你要新增一类产品的时候， 得重新设计工厂接口类。
 * 而抽象工厂中， 直接在工厂接口类上新增了方法， 后面的子类同一实现即可。
 * 新增接口方法， 不需要再新增接口类
 *
 * 再通俗深化理解下：工厂模式针对的是一个产品等级结构 ，抽象工厂模式针对的是面向多个产品等级结构的。
 */
public class Test {
    public static void main(String[] args){

        // 生产MAC 电脑
        ComputerFactory macFactory = new MacComputerFactory();
        macFactory.makeComputer().setOperationSystem();

        // 生产win 电脑
        ComputerFactory winFactory = new WinComputerFactory();
        winFactory.makeComputer().setOperationSystem();

    }
}
