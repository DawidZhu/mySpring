package com.example.myCore;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

/**
 * Annotation
 *
 * 注解：用在类上，方法上，成员变量，构造器上对成分进行编译约束、标记等操作。
 * 注解是给编译器或JVM看的。
 * 自定义注解格式：
 *  修饰符 @interface 注解名{
 *      //注解属性格式：
 *      格式1：数据类型 属性名();
 *      格式2：数据类型 属性名() default 默认值；
 *
 *  }
 *  注解可以有属性值，属性名必须有()
 *  在用注解的时候，属性必须赋值，除非这个属性有默认值
 *
 *  如果只有一个value属性，使用的时候可以省略value名称不写
 * @ Book(value="/DeleteBook.action") = @ Book("/DeleteBook.action")
 *
 *  元注解
 *  元注解是用来注解自定义注解的。
 * @ Target : 约束自定义注解只能在哪些地方使用
 * @ Retention ：申明注解的申明周期
 *
 * 在用注解的时候，属性必须赋值，除非这个属性有默认值！
 */

public class MyAnnotation {
    @MyBook(name="Java Book",authors = "David,Daniel")
    public static void main(String[] args){

    }
}


/**
 * 自定义一个注解
 */
@Target(ElementType.METHOD) //注解只能在方法上使用
@interface MyBook{
    String name();
    String[] authors();
    String address() default "GC";
}
