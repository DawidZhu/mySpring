package com.example.mydesignpattern.CreationalPattern.simpleFactory;

/**
 * OOPS： Object-oriented, Encapsulation, Inheritance, Polymorphism, Abstraction.
 * Simple Factory Pattern:
 *
 * 用一个单独的类来实现具体的实例化过程，避免客户端对具体实例化过程的显式指定。
 * Java 中，万物皆对象，这些对象都需要创建，如果创建的时候直接使用new,就会对该对象耦合严重，违背了软件设计的Open-Close principle，
 * 如果我们使用工厂来生产对象，只需要和工厂打交道就可以。
 * 工厂模式的目的：解耦。
 *
 * 简单工厂模式：用工厂类，提供对象的创建。
 * 用到的思想：继承，多态。
 */
public class SimpleFactory {

    public static Operation createOpearation(String operator){
        Operation operation = null;
        if ("+".equals(operator)){
                System.out.println("");
                operation = new operationAdd();

        }

        return operation;
    }


}

