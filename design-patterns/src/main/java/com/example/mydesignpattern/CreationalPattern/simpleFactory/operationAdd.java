package com.example.mydesignpattern.CreationalPattern.simpleFactory;

/**
 * 具体的操作方法，继承抽象类
 */
public class operationAdd extends Operation{

    @Override
    public double getResult() {
        return numA + numB;
    }
}
