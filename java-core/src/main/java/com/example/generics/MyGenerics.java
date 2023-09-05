package com.example.generics;

import com.example.myCore.City;

import java.util.ArrayList;

/**
 *  Generics  泛型 <E>    Generic 通用
 *
 *   泛型就是一个标签：<数据类型>
 *   Java 泛型（generics）是 JDK 5 中引入的一个新特性, 泛型提供了编译时类型安全检测机制，该机制允许程序员在编译时检测非法的类型。
 *   泛型的本质是参数化类型，也就是说所操作的数据类型被指定为一个参数。
 *   类型的参数化，就是可以把类型像方法的参数那样传递。泛型使编译器可以在编译期间对类型进行检查以提高类型安全，
 *   减少运行时由于对象类型不匹配引发的异常。
 *    List<String> list = new ArrayList<String>();
 *    String: type parameters
 *    By convention, type parameter names are single, uppercase letters.
 *  泛型提供了编译时类型安全检测机制，该机制允许程序员在编译时检测到非法的类型。
 *  泛型的本质是参数化类型，也就是说所操作的数据类型被指定为一个参数。 贴标签！
 *  而 <E> 只能为引用数据类型，这时我们就需要使用到基本类型的包装类 Wrapper。
 *  E: 泛型数据类型，用于设置 objectName 的数据类型，只能为引用数据类型。
 *
 *  问题在于“类型转换异常” ClassCastException，所以我们只要保证“容器”中存储的是同一类型的元素就不会出现这个异常了。
 *  类似数组的定义一样：如 int[] 就表示专门用来存储int类型数据的数组，String[] 就是用来存储String类型数据的数组。
 *  我们只要将“容器”标上相应类型的标签就可以了。看到这里，你应该已经理解了泛型的由来，
 *  这就是泛型的设计：引入类型参数的概念，即对对象类型进行申明。
 *  当我们不确定传入的对象类型时我们就可以使用？来代替。“？”即泛型通配符。
 *
 *  java 中泛型标记符：
 * E - Element (在集合中使用，因为集合中存放的是元素)
 * T - Type（Java 类）
 * K - Key（键）
 * V - Value（值）
 * N - Number（数值类型）
 * ？ - 表示不确定的 java 类型
 *
 * Pair<String, Integer> p1 = new OrderedPair<String, Integer>("Even", 8);
 * Java compiler can infer the K and V types from the declaration OrderedPair<String, Integer>,
 * these statements can be shortened using diamond notation:
 * OrderedPair<String, Integer> p1 = new OrderedPair<>("Even", 8);
 *
 *  <? extends T>和<? super T>表示java泛型中的上界和下界的概念，Upper Bounds
 *  就是说<? extends T>限定的是容器中所能接收的最顶层的父类，也就是T和T的子类；
 *  <? super T> 限定的是容器中所能接收的最底层的子类，也就是T和T的父类。
 *  请记住PECS原则：生产者（Producer）使用extends，消费者（Consumer）使用super。
 *   Get (extend) and Put (Super) principle.
 *  This principle states that: Use an extends wildcard when you only get values out of a structure.
 *  Use a super wildcard when you only put values into a structure.
 *  And don’t use a wildcard when you both get and put.
 *  “Producer Extends，Consumer Super”。
 *  换句话说，如果参数化类型表示一个生产者，就使用<? extends T>；如果它表示一个消费者，就使用<? super T>
 *  如果你是想遍历 GET collection，并对每一项元素操作时，此时这个集合时生产者（生产元素），应该使用 Collection<? extends Thing>；
 *  如果你是想添加 PUT 元素到collection中去，那么此时集合时消费者（消费元素）应该使用Collection<? super Thing>。
 *
 */
public class MyGenerics{

    public static void main(String[] args){

        //ArrayList<E>  范型
        ArrayList<String> arrayList1 = new ArrayList();
        ArrayList<City> arrayList2 = new ArrayList();

        Printer<Integer> printer = new Printer<>(10);
        printer.print();

        Printer<Double> doublePrinter = new Printer<>(10.1);
        doublePrinter.print();

        //Consumer<T> andThen(Consumer<? super T> after)

        //public boolean addAll(Collection<? extends E> c)

    }
}

/**
 * 自定义一个范型类
 * @param <T>
 */
class Printer<T extends Number> {
    T thingToPrint;

    public Printer(T thingToPrint){
        this.thingToPrint = thingToPrint;

    }

    public void print(){
        System.out.println(thingToPrint);
    }
}
