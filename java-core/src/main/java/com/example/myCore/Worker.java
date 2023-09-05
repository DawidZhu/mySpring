package com.example.myCore;

/**
 * 11. Interface
 *
 *  接口体现的是规范思想。接口是用来实现的 implements.   An interface is a template which has only method declarations
 *  and not the method implementation.
 *  JDK1.8 之前的接口中只有 抽象方法 和 常量。
 *  常量constants， static：只有一个值，final:在运行中不能被修改。 public static final
 *  All the variables in the interface are internally public static final that is constants.
 *  抽象方法 public abstract void
 *  The class which implements the interface should provide an implementation for all the methods declared in the interface.
 *  一个类实现接口，必须重写接口中的全部抽象方法，否则这个类就要定义成抽象类！
 *  类与类是单继承 extends 关系， 一个类只能继承一个直接父类
 *  类与接口是多实现 implements 关系,  一个类可以同时实现过个接口
 *  接口与接口多继承关系，一个接口可以同时继承多个接口，目的：用一个接口合并多个接口。
 *
 *  接口中没有构造器，不能创建对象。接口是更彻底的抽象！
 *  一个类可以多次实现接口，实现接口的类是实现类 class A implements interface1, interface2 ....
 *  JDK1.8 后接口新增了3个方法：
 *      1，默认方法 2，静态方法 3，私有方法
 *      简单说，默认方法就是接口可以有实现方法，而且不需要实现类去实现其方法。只需在方法名前面加个 default 关键字即可
 *
 *  接口中的静态方法背后的思想是提供一种简单的机制，允许通过将相关的方法内聚在接口中，而不必创建新的对象。
 *  抽象类也可以做同样的事情。主要的区别在于抽象类可以有构造函数、成员变量和方法。
 *
 *  默认接口方法 提供默认的功能实现，你不喜欢可以改。
 *  静态接口方法 同样提供一个默认的功能实现，子类无法进行覆写。
 *
 *      对比 接口与抽象类
 */
public interface Worker {

    /**
     *  常量：static：只有一个值，final:在运行中不能被修改。
     *  接口中的常量可以省区 public static final, 默认会加上
     */
    public static final String WORK_TIME = "8 HOURS";
    /**
     * 抽象方法 Abstract
     * 接口中的方法可以省区 public abstract ,默认会加上
     */
    public abstract void work();
    public abstract  void rest();
    /**
     *接口中的默认方法 default
     */
    default void testInterface(){
        System.out.println("default method in the Interface ...");
    }
    /**
     *接口中的静态方法
     */
    public static void doTest(){
        System.out.println("static method in the Interface ...");
    }

}
