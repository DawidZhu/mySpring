package com.example.mydesignpattern.CreationalPattern.simpleFactory;

import lombok.Data;

@Data
public abstract class Operation {
    public double numA;
    public double numB;

    //抽象方法
    public abstract double getResult();

}
