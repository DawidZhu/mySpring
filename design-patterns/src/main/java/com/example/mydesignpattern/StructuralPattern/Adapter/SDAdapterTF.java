package com.example.mydesignpattern.StructuralPattern.Adapter;

/**
 * Adapter Pattern
 *
 * 将一个接口转换为客户端所期待的接口，从而使两个接口不兼容的类可以在一起工作
 * says that just "converts the interface of a class into another interface that a client wants".
 * In other words, to provide the interface according to client requirement while
 * using the services of a class with a different interface.
 *
 * Adapter is used when you have an abstract interface, and you want to map that interface to
 * another object which has similar functional role, but a different interface.
 *
 * SDAdapterTF implements SDCard
 * SDCard 类型的参数，都可以传入 SDAdapterTF
 * 适配者(Adaptee)类:它是被访问和适配的现存组件库中的组件接口。
 * 适配器(Adapter)类:它是一个转换器，通过继承或引用适配者的对象，把适配者接口转换成 目标接口，让客户按目标接口的格式访问适配者
 *
 * 这个类是适配器模式的核心，通过此类就可以将三方库提供的接口转换为系统的目标接口
 */
public class SDAdapterTF implements SDCard{
    /**
     * 适配器类： 实现目标的接口，拿需要改造的对象 Adaptee，进行转换适配
     */
    private TFCard tfCard;

    /**
     * 构造方法，初始化对象
     */
    public SDAdapterTF(TFCard tfCard) {
        this.tfCard = tfCard;
    }

    @Override
    public String readSD() {
        System.out.println("adapter TF to SD...");
        return tfCard.readTF();
    }

    @Override
    public void writeSD(String str) {
        System.out.println("adapter TF to SD...");
        tfCard.writeTF("SD write to TF");

    }
}
