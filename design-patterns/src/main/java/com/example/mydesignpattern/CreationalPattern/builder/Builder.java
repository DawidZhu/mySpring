package com.example.mydesignpattern.CreationalPattern.builder;

/**
 * Builder 抽象类
 * The intent of the Builder design pattern is to separate the construction of a complex object
 * from its representation. By doing so the same construction process can create different representations
     将一个复杂对象的构建与其表示分离，使得同样的构建过程可以创建不同的表示

  Imagine a complex object that requires laborious, step-by-step initialization of many fields and nested objects.
  Such initialization code is usually buried inside a monstrous constructor with lots of parameters.
  Or even worse: scattered all over the client code.
 *
 * It is mostly used when object can't be created in single step.
 * The Factory pattern can almost be seen as a simplified version of the Builder pattern.
 *
 * 抽象建造者类(Builder):这个接口规定要实现复杂对象的那些部分的创建，并不涉及具体的 部件对象的创建
 *
 *  Builder focuses on constructing a complex object step by step.
 *  Abstract Factory emphasizes a family of product objects (either simple or complex).
 *  Builder returns the product as a final step, but as far as the Abstract Factory is concerned,
 *  the product gets returned immediately
 *
 *  应用场景：
 *  当一个类的构造函数参数个数超过4个，而且这些参数有些是可选的参数，考虑使用构造者模式。
 *  在客户端使用链式调用，一步一步的把对象构建出来。
 *  Computer computer=new Computer.Builder("因特尔","三星")
 *         .setDisplay("三星24寸")
 *         .setKeyboard("罗技")
 *         .setUsbCount(2)
 *         .build();
 *
 *
 */
public abstract class Builder {

    public Bike bike = new Bike();

    public abstract void buildFrame();
    public abstract void buildSeat();
    public abstract Bike creatBike();

}
