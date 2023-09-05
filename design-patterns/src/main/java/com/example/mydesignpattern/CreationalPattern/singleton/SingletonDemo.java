package com.example.mydesignpattern.CreationalPattern.singleton;

/**
 * Singleton
 *
 * is a creational design pattern that lets you ensure that a class has only one instance,
 * while providing a global access point to this instance.
 * Real-World：
 * The government is an excellent example of the Singleton pattern. A country can have only one official government.
 * Regardless of the personal identities of the individuals who form governments, the title,
 * “The Government of X”, is a global point of access that identifies the group of people in charge.
 *
 * 单例模式： 通过 static 关键字 + private constructor 实现
 * 饿汉模式，类加载就会导致对象被创建
 * 懒汉模式，类加载不会导致对象被创建，首次被使用时才会创建
 *
 * OOPS： Object-oriented, Encapsulation, Inheritance, Polymorphism, Abstraction.
 * JDK runtime类使用的单例模式 
 */
public class SingletonDemo {

    /**
     * 修改public 为private，不让外界访问去初始化对象
     */
    private SingletonDemo() {
    }

    /**
     * 饿汉模式：直接new
     * 懒汉模式：先不赋，new 方法放到getInstance里面，如果singleton对象 为空，再去new
     * Static 变量，只存在一份
     *
      */

    private static SingletonDemo singleton = new SingletonDemo();
    //懒汉模式
   // private static Singleton singleton；

    /**
     * 通过public getInstance方法 返回对象
     * @return
     */
    public static SingletonDemo getInstance(){
        return singleton;
    }


}
