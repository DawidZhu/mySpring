package com.example.mydesignpattern.StructuralPattern.Adapter;

/**
 * 适配者(Adaptee)类:它是被访问和适配的现存组件库中的组件接口。
 * 我们想要使用的接口与Target不兼容的类，它可以是一个接口，也可以是一个类。
 */
public class TFCardImpl implements TFCard{
    @Override
    public String readTF() {
        return "Read from TF Card: hello";
    }

    @Override
    public void writeTF(String str) {
        System.out.println("Write to TF : "+str);
    }
}
