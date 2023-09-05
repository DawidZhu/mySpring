package com.example.mydesignpattern.StructuralPattern.Adapter;

/**
 * 适配者(Adaptee)类:它是被访问和适配的现存组件库中的组件接口。
 * 我们想要使用的接口与Target不兼容的类，它可以是一个接口，也可以是一个类。
 */
public interface TFCard {
    String readTF();
    void writeTF(String str);
}
