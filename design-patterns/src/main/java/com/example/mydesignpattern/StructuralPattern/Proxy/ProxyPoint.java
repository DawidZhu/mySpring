package com.example.mydesignpattern.StructuralPattern.Proxy;

/**
 *  Proxy Pattern
 *
 *  It provides the protection to the original object from the outside world.
 *  为其他对象提供一种代理以控制外部对这个对象的访问。
 *
 * Proxy is a structural design pattern that lets you provide a substitute or placeholder
 * for another object.
 * A proxy controls access to the original object, allowing you to perform something
 * either before or after the request gets through to the original object.
 *
 * Proxy could be used when you want to lazy-instantiate an object, or hide the fact that you're calling
 * a remote service, or control access to the object.
 *
 * 代理(Proxy)模式分为三种角色:
 * 抽象主题(Subject)类: 通过接口或抽象类声明真实主题和代理对象实现的业务方法。
 * 真实主题(Real Subject)类: 实现了抽象主题中的具体业务，是代理对象所代表的真实对 象，是最终要引用的对象。
 * 代理(Proxy)类 : 提供了与真实主题相同的接口，其内部含有对真实主题的引用，它可以访 问、控制或扩展真实主题的功能。
 *
 *  一般认为代理模式侧重于使用代理类增强被代理对象的访问，而装饰者模式侧重于使用装饰者类来对被装饰对象的功能进行增减。
 *  装饰者模式主要是提供一组装饰者类，然后形成一个装饰者栈，来动态的对某一个对象不断加强，而代理一般不会使用多级代理。
 *
 * 动态代理在AOP中的应用：
 * AOP： 定义：In computing, aspect-oriented programming (AOP) is a programming paradigm that aims to increase modularity by allowing the separation of cross-cutting concerns.
 * AOP是一种编程范式，其目标是通过隔离切面耦合来增加程序的模块化
 *
 * 要理解AOP就首先要理解什么是切面耦合（cross-cutting concerns）。例如有这样一个需求，要求为一个程序中所有方法名称
 * 以test开头的方法打印一句log，这个行为就是一个典型的cross-cutting场景。首先这个打印log和业务毫无关系，
 * 然后其处于分散在整个程序当中的各个模块，如果按照我们原始的方法开发，一旦后期需求变动将是及其繁琐的。
 * 所以我们就需要将这个切面耦合封装隔离，不要将其混入业务代码当中
 *
 */
public class ProxyPoint implements SellTickets{

    // 第三步：获取要代理的对象，火车站
    private TrainStation station = new TrainStation();
    @Override
    public void sell() {
        System.out.println("代售点卖票，收手续费。");
        station.sell();
    }
}
