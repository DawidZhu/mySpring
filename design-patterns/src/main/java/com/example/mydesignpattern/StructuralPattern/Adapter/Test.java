package com.example.mydesignpattern.StructuralPattern.Adapter;

/**
 * 结构型模式 Structural Pattern
 *
 * 描述如何将类或对象按某种布局组成更大的结构。它分为类结构型模式和对象结构型模式，
 * 前者采用继承机制来组织接口和类，后者釆用组合或聚合来组合对象。
 *
 * Adapter Pattern
 *
 * 将一个接口转换为客户端所期待的接口，从而使两个接口不兼容的类可以在一起工作
 * says that just "converts the interface of a class into another interface that a client wants".
 * In other words, to provide the interface according to client requirement while
 * using the services of a class with a different interface.
 * 优点：
 *  极大的增强了程序的可扩展性，通过此模式，你可以随意扩展程序的功能，但却不需要修改接口
 */
public class Test {
    public static void main(String[] args){
    Computer computer = new Computer();
    SDCard sdCard = new SDCardImpl();

    System.out.println(computer.readSD(sdCard));

    // 适配器类： 实现目标的接口，拿需要改造的对象 tfCard，进行转换适配，得到实现了目标接口的对象。
    TFCard tfCard = new TFCardImpl();
    SDAdapterTF adapter = new SDAdapterTF(tfCard);

    System.out.println(computer.readSD(adapter));

    }
}
