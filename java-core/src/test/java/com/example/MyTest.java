package com.example;

import com.example.myCore.David;
import org.junit.jupiter.api.Test;

/**
 * Springboot 2.4以后不能再使用junit 4
 */
public class MyTest {

    /**
     * 测试单例模式
     */
    @Test
    public void testSingleton(){
        //static 方法，可以直接获取
//        SingletonDemo singleton1 = SingletonDemo.getInstance();
//        SingletonDemo singleton2 = SingletonDemo.getInstance();
//        // 比较的地址是否相等
//        System.out.println(singleton1.equals(singleton2));
//        System.out.println(singleton1.hashCode());
//        System.out.println(singleton2.hashCode());

        /**
         * test Daniel
         * 获取两个对象，测试是不是单例
         */
        David david1 = David.getInstance();
        David david2 = David.getInstance();
       // Daniel daniel3 = new Daniel();   因为构造器私有，在class外无法访问new对象
        System.out.println("测试是不是单例： ");
        System.out.println(david1 == david2); //ture ,"==" 对于对象，比较的是地址
        //System.out.println(daniel1 == daniel3);

    }
}
