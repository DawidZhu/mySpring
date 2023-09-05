package com.example.myCore;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Wrapper classes provide a way to use primitive data types (int, boolean, etc..) as objects.
 * String 是对象，不是基础数据类型。
 *
 * Sometimes you must use wrapper classes, for example when working with Collection objects,
 * such as ArrayList, where primitive types cannot be used (the list can only store objects):
 *
 * 所有包装类型都是不可变类型（Immutable），有两种创建包装类型的方式。
 * 使用构造方法（Constructors）
 * 使用valueOf()静态工厂方法
 * Java 自动装箱与拆箱（Autoboxing and Unboxing）作用于基本类型与其对应的包装类。
 * 将基本类型自动转换为其对应的包装类型，被称为自动装箱；将包装类型自动转换为其对应的基本类型，被称为自动拆箱
 *
 * Primitive Data Type	    Wrapper Class
 * byte	                  Byte
 * short	           Short
 * int	               Integer
 * long         	   Long
 * float	           Float
 * double	          Double
 * boolean	         Boolean
 * char	            Character
 */
public class MyWrapper {

    public static void main(String[] args){

        /**
         *  对象类型： Wrapper Class，Integer
         *  基本数据类型：  int
         *  赋值方式 ： * 使用构造方法（Constructors）
         *  * 使用valueOf()静态工厂方法
         */
        Integer integer = 5; // Autoboxing
        Integer integer1 = new Integer(5);
        Integer integer2 = Integer.valueOf(5);
        int int2 = integer2; // Unboxing

        /**
         * AtomicInteger 原子性的int 类型
         * 默认加了 volatile， 线程安全
         */
        AtomicInteger atomicInteger = new AtomicInteger(); //默认为0

        int i = 5;
        Long l1 = Long.valueOf(100);
        long l2 = 100;

        double boub1 = 1.0;
        Double doub2 = 1.0;
        Double doub3 = new Double(1.0);

        boolean b = true;
        Boolean b1 = true;
        Boolean b2 = new Boolean("false");


        System.out.println(integer.getClass());
        System.out.println(integer.hashCode());
        System.out.println(i);

        System.out.println(l1);

    }

}
