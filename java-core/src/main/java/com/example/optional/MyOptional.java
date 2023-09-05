package com.example.optional;

import com.example.myCore.City;

import java.util.Optional;

/**
 *  Optional：
 *  Optional 是 Java 8 引进的一个新特性，我们通常认为Optional是用于缓解Java臭名昭著的空指针异常问题。
 *  Optional给了我们一个真正优雅的Java风格的方法来解决null安全问题。只要一段代码可能产生null，那它就可以返回Optional。
 *  Optional就像一个处理不确定性的管道，我们在一头丢进一个可能是null的东西（接口返回结果），经过层层处理，最后消除不确定性.
 *  Optional是一个容器对象，可以包含也可以不包含非null值。Optional在Java 8中引入，
 *  目的是解决  NullPointerExceptions的问题。本质上，Optional是一个包装器类，其中包含对其他对象的引用。
 *  Optional<City> getCityById() 方法返回了  Optional<City> 作为结果，这样就表明 City 可能存在，也可能不存在
 *
 */
public class MyOptional {

    public static void main(String[] args) {

        Optional<Object> empty = Optional.empty();
        System.out.println(empty.isPresent());
        // System.out.println(empty.isEmpty());
        // Optional<T> ofNullable(T value)
        Optional<String> str = Optional.ofNullable("hello");
        // return this.value != null ? this.value : other;
        String orElse = str.orElse("str is null");
        System.out.println("orElse>>>>" + orElse);

        Optional<String> hello = Optional.ofNullable("hello");
        hello.map(s -> s.toUpperCase());
        // 简化if,else的写法， hello 如果非空，否则...
        hello.ifPresentOrElse(s -> System.out.println(s), () -> System.out.println("world"));

        Object value = Optional.ofNullable("Hello")
                //Supplier
                .orElseThrow(() -> new IllegalStateException("exception"));

        Optional.ofNullable(null)
                .ifPresent(email -> System.out.println("Sending eamil to " + email));

        //Transforming Value With map()


    }

    /**
     * 不使用 Optional
     */
    public String getName(City city) {

        if (city != null || city.getName() != null) {
            return city.getName();
        }
        return "Unknown";
    }

    /**
     * Optional 写法
     * 进行链式调用，而不是一层层判断
     * map(Function<? super T, ? extends U> mapper)
     */
    public String getName1(City city) {
        return Optional.ofNullable(city).map(s->s.getName()).orElse("Unknown");
    }
}
