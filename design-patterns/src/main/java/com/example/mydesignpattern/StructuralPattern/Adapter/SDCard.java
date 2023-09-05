package com.example.mydesignpattern.StructuralPattern.Adapter;

/**
 * 目标(Target)接口:
 * 当前系统业务所期待的接口，它可以是抽象类或接口。它是我们客户端使用的目标接口
 */
public interface SDCard {
    String readSD();
    void writeSD(String str);
}
