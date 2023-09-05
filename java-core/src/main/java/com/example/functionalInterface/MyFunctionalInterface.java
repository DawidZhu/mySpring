package com.example.functionalInterface;
/**
 *
 *  Functional Interface  函数式接口
 *   定义： 函数式接口()就是一个有且仅有一个抽象方法，但是可以有多个非抽象方法的接口。
 *   函数式接口适用于函数式编程的场景，Lambda 是Java中函数式编程的体现
 *   函数式接口可作为方法的参数使用
 *  函数式编程规则 functional programing rules：
 *  No state
 *  Pure Functions
 *  No side effects
 *
 *  Java 8以前的 FunctionalInterface：
 *    @ FunctionalInterface
 *  1. public interface Runnable {
 *        public abstract void run(); }
 *
 *  @ FunctionalInterface
 *  2.public interface Comparator<T> {}
 */

@FunctionalInterface
public interface MyFunctionalInterface {
    /**
     * It contains a single abstract method named getPiValue()
     * 这种只有一个接口函数需要被实现的接口类型，我们叫它”函数式接口
     */

    //   abstract method
    double getPiValue();

    /**
     * 接口可以有默认的实现方法和static方法
     */
    default String getHello(String name ){
        return "Hello" + name;
    }

    static String hello(){
        return "Hello";
    }
}
