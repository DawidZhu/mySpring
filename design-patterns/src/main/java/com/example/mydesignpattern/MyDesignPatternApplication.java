package com.example.mydesignpattern;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * design pattern
 *
 * In software engineering, a software design pattern is a general,
 * reusable solution to a commonly occurring problem within a given context in software design.
 * It is not a finished design that can be transformed directly into source or machine code.
 * It is a description or template for how to solve a problem that can be used in many different situations.
 * Design patterns are formalized best practices that the programmer can use to solve common problems
 * when designing an application or system.
 * 在软件工程领域，设计模式是一套通用的可复用的解决方案，用来解决在软件设计过程中产生的通用问题。
 * 它不是一个可以直接转换成源代码的设计，只是一套在软件系统设计过程中程序员应该遵循的最佳实践准则。
 *
 * SOLID 原则
 * 六大原则是必须要掌握的，其是设计模式的理论，设计模式是其实践。
 * 1. 单一职责（Single Responsibility Principle）
 *     a class should do one thing and therefore it should have only a single reason to change.
 *     就是一个类应该只负责一个职责，术语叫：仅有一个引起其变化的原因。
 *     简单点说：一个类中应该是一组相关性很高的函数及数据的封装，个中含义请自行意会。
 *
 * 2. 开闭原则（Open Close Principle）
 *     classes should be open for extension and closed to modification.
 *    一个软件实体应当对扩展开放，对修改关闭。即软件实体应尽量在不修改原有代码的情况下进行扩展。
 *    提倡一个类一旦开发完成，后续增加新的功能就不应该通过修改这个类来完成，而是通过继承，增加新的类。
 *
 * 3. 里氏替换原则（Liskov Substitution Principle）
 *     subclasses should be substitutable for their base classes.
 *      所有引用基类（父类）的地方必须能透明地使用其子类的对象。
 *      简单点说，一个软件系统中所有用到一个类的地方都替换成其子类，系统应该仍然可以正常工作。这个原则依赖面向对象的继承特性和多态特性.
 *
 * 4. 依赖倒置原则（Dependence Inversion Principle）
 *     our classes should depend upon interfaces or abstract classes instead of concrete classes and functions.
 *    抽象不应该依赖于细节，细节应当依赖于抽象。换言之，要针对接口编程，而不是针对实现编程。
 *    关键点：
          高层模块不应该依赖低层模块，两者都应该依赖其抽象. 高层模块：java中的调用类,低层模块：java中的实现类（细节
 *        抽象不应该依赖细节. 抽象：java中的抽象类或者接口
 *        细节应该依赖抽象.    细节：java中的具体实现类
 *   正常情况下：调用类（高层模块）应该依赖具体实现类（低层模块实现细节）
 *   倒置后：高层模块与低层模块都依赖了实现类的接口（低层模块的细节抽象），底层模块的依赖箭头向上了，所以叫依赖倒置了。
 *
 * 5. 接口隔离原则（Interface Segregation Principle）
 *  many client-specific interfaces are better than one general-purpose interface.
 *  使用多个专门的接口，而不使用单一的总接口，即客户端不应该依赖那些它不需要的接口。
 *  其实这个原则是很容易理解的，就是让调用者依赖的接口尽可能的小。
 *
 *  6 迪米特原则（Law of Demeter 又名Least Knowledge Principle）
 *    一个软件实体应当尽可能少地与其他实体发生相互作用。
 *    一个类应该对自己需要调用的类知道得最少，类的内部如何实现、如何复杂都与调用者或者依赖者没关系，
 *    调用者或者依赖者只需要知道他需要的方法即可，其他的我一概不关心。
 *  总结：
 *    以上六大原则全部是以构建灵活可扩展可维护的软件系统为目的，所以说它的重要性是高于设计模式的，
 *    也应该是程序员时刻印在脑子里的，设计模式只是它的具体实践而已。
 *
 *
 *
 */
@SpringBootApplication
public class MyDesignPatternApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyDesignPatternApplication.class, args);
    }

}
