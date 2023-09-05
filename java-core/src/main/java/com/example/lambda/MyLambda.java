package com.example.lambda;

/**
 *   28. Anonymous class 匿名内部类
 *
 *   目的是new 对象
 *   正因为没有名字，所以匿名内部类只能使用一次，它通常用来简化代码编写
 *   只要一个类是抽象的或是一个接口，那么其子类中的方法都可以使用匿名内部类来实现
 *   但使用匿名内部类还有个前提条件：必须继承一个父类或实现一个接口
 *   先看匿名内部类的定义的语法格式：
 *
 * new 实现接口（）
 * {
 *     //匿名内部类类体部分
 * }
 * new 父类构造器（实参列表）
 * {
 *   //匿名内部类类体部分
 * }
 *   must be defined inside another class. Hence, it is also known as an anonymous inner class.
 *   Anonymous classes usually extend subclasses or implement interfaces.
 *
 *  29. Lambda 表达式
 *
 *  格式： （匿名内部类被重写方法的形参列表） -> {
 *      被重写方法的方法体代码
 *  }
 *  ->前是方法的参数，->后是方法体
 *
 *  因为函数式接口只有一个方法，所以可以省略方法名不写。
 *  前提： Lambda 表达式只能简化接口中只有一个抽象方法的匿名内部类形式。
 *   1，首先必须是接口；2，接口中是能有一个抽象方法（函数式接口）。
 *  如果只有一行代码，且代码是return语句，必须省略return 不写。
 *
 *   函数式接口(Functional Interface)就是一个有且仅有一个抽象方法，但是可以有多个非抽象方法的接口。
 *   函数式接口可以被隐式转换为 lambda 表达式。
 *
 *  Lambda 允许把函数作为一个方法的参数（函数作为参数传递进方法中）。
 *  (parameter list) -> lambda body
 *  (parameter1, parameter2) -> { code block }
 *   private static void printString(String text, MyFunction myFunction) {
 *        myFunction.print(text);
 *     }
 *
 *  以下是lambda表达式的重要特征:
 * 可选类型声明：不需要声明参数类型，编译器可以统一识别参数值。
 * 可选的参数圆括号：一个参数无需定义圆括号，但多个参数需要定义圆括号。 n -> (n%2)==0
 * 可选的大括号：如果主体包含了一个语句，就不需要使用大括号。
 * 可选的返回关键字：如果主体只有一个表达式返回值则编译器会自动返回值，大括号需要指定表达式返回了一个数值。
 *  // 2. 接收一个参数(数字类型),返回其2倍的值
 *    x -> 2 * x
 *  // 5. 接受一个 string 对象,并在控制台打印,不返回任何值(看起来像是返回void)
 *  (String s) -> System.out.print(s)
 *
 *  The Lambda expression is used to provide the implementation of an interface which has functional interface.
 *  It saves a lot of code.
 *  In case of lambda expression, we don't need to define the method again for providing the implementation.
 *  Here, we just write the implementation code.
 *  An interface which has only one abstract method is called functional interface.
 *  Java provides an anotation @FunctionalInterface
 *
 *  JDK1.8 开始后的新技术，是一种代码的新语法
 *  作用：核心目的是简化函数式接口/匿名内部类的代码写法
 *  以简化的写法，完成了只有一个接口方法的方法体内的写法。
 *  @ FunctionalInterface 一旦某个接口加上这个注解，只能有一个抽象方法
 *  If a Java interface contains one and only one abstract method then it is termed as functional interface.
 *
 *  31. Method Reference  方法引用
 *
 *  简单地说，就是一个Lambda表达式。在Java 8中，我们会使用Lambda表达式创建匿名方法，但是有时候，
 *  我们的Lambda表达式可能仅仅调用一个已存在的方法，而不做任何其它事，对于这种情况，
 *  通过一个方法名字来引用这个已存在的方法会更加清晰
 *  方法引用是一个更加紧凑，易读的Lambda表达式，注意方法引用是一个Lambda表达式，其中方法引用的操作符是双冒号"::"。
 *  方法引用主要有一下三种情况：
 *  对象 :: 实例方法名
 *  类 :: 静态方法名
 *  类 :: 实例方法名
 *
 *   接口名	        Java8新加入的方法
 * Collection   	removeIf() spliterator() stream() parallelStream() forEach()
 * List	          replaceAll() sort()
 * Map	       getOrDefault() forEach() replaceAll() putIfAbsent() remove() replace() computeIfAbsent() computeIfPresent() compute() merge()
 *
 * forEach():
 * 该方法的签名为void forEach(Consumer<? super E> action)，作用是对容器中的每个元素执行action指定的动作，
 * 其中Consumer是个函数接口，里面只有一个待实现方法void accept(T t).
 * Consumer 是接口名称， accept 是方法名称，用Lambda表达式这两个都不需要写
 *
 */

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class MyLambda {
    public static void main(String[] args){

        /**
         * Anonymous class
         * 直接new 接口，重写方法
         * 目的是new对象，使用匿名内部类，省去了创建类，实现这个接口，重写方法的操作
         * 匿名类是指没有类名的内部类，必须在创建时使用 new 语句来声明类。
         *
         * new <类或接口>() {
         *     // 类的主体
         * };
         */
//        MyInterface myInterface = new MyInterface() {
//            @Override
//            public double getPiValue() {
//                return 3.1415;
//            }
//        };

        /**
         * Note that we can declare a reference of an interface
         * but we cannot instantiate an interface.
         */
       // MyInterface ref;

       // ref = () -> 3.1415; //()前省略的是接口方法名， 省略return

       // System.out.println("Value of Pi = " + ref.getPiValue());
        /**
         * Lambda
         * interface Function<T, R> : 输入，输出
         * 第一个String，表示入参数name的类型
         * 第二个String ，表示返回name.toUpperCase()的类型
         */
        Function<String, String> upperCaseName = name -> name.toUpperCase();
        //method reference ,方法引用的写法
        // 类 :: 实例方法名
        Function<String, String> upperCaseName1 = String::toUpperCase;
        // 多行的方法体
        Function<String, String> upperCaseName2 = name -> {
            //方法体，处理逻辑
            if(name.isEmpty()) throw new IllegalArgumentException("Exception");
            return name.toUpperCase();
        };


    }
    /**
     * ArrayList & Lambda
     */
    @Test
    public void TestLambda(){

        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("I");
        arrayList.add("LOVE");
        arrayList.add("YOU");
        arrayList.add("TOO");
        arrayList.add("TAAA");
        /**
         * JAVA 7 :打印长度大于3的字符串
         * 使用for each loop
         */
        for(String str : arrayList){
            if(str.length() > 3){
                System.out.println(str);
            }
        }
        /**
         * JAVA 8: 使用forEach() 结合匿名内部类
         */
        System.out.println("JAVA 8: 使用forEach(): >>>>>");
        arrayList.forEach(new Consumer<String>() {
            @Override
            public void accept(String s) {
                if(s.length() > 3){
                    System.out.println(s);
                }
            }
        });
        /**
         * JAVA8 : 使用forEach() 结合 Lambda 表达式
         * 给forEach()方法传入一个Lambda表达式，我们不需要知道accept()方法，也不需要知道Consumer接口，
         * 类型推导帮我们做了一切。
         */
        System.out.println("使用forEach() 结合 Lambda 表达式：>>>>>");
        arrayList.forEach(s -> {
            //重点在方法体,多行的方法体可以用方法代替
            if(s.length() > 3){
                System.out.println(s);
            }
        });

        /**
         *  removeIf()
         *  该方法签名为boolean removeIf(Predicate<? super E> filter)，作用是删除容器中所有满足filter指定条件的元素，
         *  其中Predicate是一个函数接口，里面只有一个待实现方法boolean test(T t)
         */
          arrayList.removeIf(new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return s.length() > 5;
            }
        });
        /**
         * 使用Lambda表达式不需要记忆Predicate接口名，也不需要记忆test()方法名，
         * 只需要知道此处需要一个返回布尔类型的Lambda表达式就行了。
         */
        arrayList.removeIf(s -> s.length() > 5);

        /**
         * sort()  方法根据指定的顺序对动态数组中的元素进行排序。
         * 该方法定义在List接口中，方法签名为void sort(Comparator<? super E> c)，该方法根据c指定的比较规则对容器元素进行排序。
         * Comparator接口我们并不陌生，其中有一个方法int compare(T o1, T o2)需要实现，显然该接口是个函数接口。
         *
         *  需求：按照字符串长度增序对元素排序。
         */
        System.out.println("排序前，arrayList.sort: >>>>>");
        arrayList.forEach(s -> System.out.println(s));
        arrayList.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        });
        System.out.println("arrayList.sort: >>>>>");
        arrayList.forEach(s -> System.out.println(s));

        // Lambda ,按照字符串长度增序对元素排序。
        arrayList.sort( (o1, o2) -> o1.length() - o2.length());
       // arrayList.stream().filter(s -> );
    }
}