package com.example.functionalInterface;

import java.util.List;
import java.util.function.Supplier;

/**
 *   Supplier<T>: 供给型接口
 *   抽象方法：T get()，无参数，有返回值。
 */
public class MySupplier {
    public static void main(String[] args){
        System.out.println(getDBConnectionUrl());
        //  Supplier<T>
        System.out.println(getDBConnectionUrlSupplier.get());
    }

    static String getDBConnectionUrl(){
        return "Jdbc://localhost:3306/testDB";
    }

    static Supplier<List<String>> getDBConnectionUrlSupplier = ()
            -> List.of(
            "Jdbc://localhost:3306/testDB",
            "Jdbc://localhost:3306/test"
    );
}
