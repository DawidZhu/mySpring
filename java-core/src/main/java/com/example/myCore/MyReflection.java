package com.example.myCore;

//import org.junit.Test;

//import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;

/**
 * Reflection
 *
 * Java Reflection is a process of examining or modifying the run time behavior of a class at run time.
 * 反射是指对于任何一个类，在运行的时候可以直接得到这个类的全部成分。
 * 反射是通过先得到编译后的Class类对象：字节码文件。
 * 然后才可以得到类中的全部成分，进行一些功能设计。
 * Class：字节码文件的类型
 * Constructor：构造器的类型
 * Field：成员变量的类型
 * Method：方法的类型
 * 得到class类对象的方式：1。类名.class;2.类对象.getClass()
 *
 * 反射的作用：做JAVA高级框架，基本上都会基于反射设计一些通用技术功能。
 *  1。可以在运行时得到一个类的全部成分，然后操作。
 *  2。可以破坏封装性。
 *  3。也可以破坏范型的约束。
 *
 *
 */
public class MyReflection {

    /**
     * 用test 测试，不再需要写main方法
     */

    public void test(){

        /**
         * //1. 得到类的class文件
         * 类名.class
         */
        Class c = City.class;
        /**
         * 2. 得到class文件
         * 类对象.getClass()
         */
        City city = new City();
        city.getClass();
        /**
         * 获取类的成员变量
         */
        Field[] field = c.getDeclaredFields();
        for (Field item : field) {
            System.out.println(item.getName() + "====" + item.getType());
        }

    }
}
