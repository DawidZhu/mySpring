package com.example.myCore;

/**
 * 1. What is JIT?
 * Just in Time compiler, 是Java 运行时的一个组件，JIT compiles code to Machine Level directly for higher speed of code execution.
 *  可以提高运行时JAVA应用程序的性能。
 * At compile time: X.java -> Compiler -> X.class(byteCode)
 * At run Time: X.Class ->JIT Compiler -> Native code(Machine level)
 *
 * 2,What is Association?
 * 关联是两个独立的类之间，通过它们的对象建立的关系。关联可以是一对一，一对多，多对一，多对多
 * Association is relation between two separate classes which establishes through their Objects. Association can be one-to-one, one-to-many, many-to-one, many-to-many.
 * In Object-Oriented programming, an Object communicates to other Object to use functionality and services provided by that object. Composition and Aggregation are the two forms of association.
 *
 * 3,Marker interface
 * java中的标记接口（Marker Interface），又称标签接口（Tag Interface），具体是不包含任何方法的接口.
 * 标记接口就是用来判断某个类是否具有某个能力的
 * 常见的几个标记接口有：java.lang.Cloneable, java.io.Serializable，支持序列和反序列化。
 *
 * 4, Java  package
 * 为了更好地组织类，Java 提供了包机制，用于区别类名的命名空间。
 * 一个包（package）可以定义为一组相互联系的类型（类、接口、枚举和注释），为这些类型提供访问保护和命名空间管理的功能。
 * 由于包创建了新的命名空间（namespace），所以不会跟其他包中的任何名字产生命名冲突。使用包这种机制，更容易实现访问控制，
 * 并且让定位相关类更加简单。
 *
 * 6. JDK JRE
 *
 * JDK全称为Java Development Kit，顾名思义是java开发工具包，是程序员使用java语言编写java程序所需的开发工具包。
 *
 * JRE全称为Java Runtime Environment，顾名思义是java运行时的环境，包含了java虚拟机，java基础类库，
 * 是使用java语言编写的程序运行所需要的软件环境。
 * 如果你需要编写java程序，需要安装JDK。如果你需要运行java程序，只需要安装JRE就可以了。
 * JDK包含了JRE，JDK 和 JRE 中都包含 JVM。也可以说JDK是JRE+Java的开发工具。JRE包含了JVM+Java语言的核心类库。
 *
 * 7. Serializable and Externalizable interface
 *
 * 序列化(Serialization)：是将对象的状态信息转换为可以存储或传输的形式的过程。
 * 更通俗地讲，是将该对象字段和状态信息以字节流的方式输出到目的地。
 *  要实现Java对象的序列化，只要将类实现Serializable或Externalizable接口即可。
 *
 *  如果我们需要持久化Java对象比如将Java对象保存在文件中，或者在网络传输Java对象，这些场景都需要用到序列化
 *
 *  8.finalize() 方法
 *  Object finalize() 方法用于实例被垃圾回收器回收的时触发的操作。
 * 当 GC (垃圾回收器) 确定不存在对该对象的有更多引用时，对象的垃圾回收器就会调用这个方法。
 *
 *
 */
public class Interview {

    private String str = "David";
    public static void main(String[] args){

        System.out.println("hello!");
    }
}
