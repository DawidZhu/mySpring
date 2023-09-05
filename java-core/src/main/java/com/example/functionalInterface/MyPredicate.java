package com.example.functionalInterface;

import java.util.function.Predicate;

/**
 *  Predicate<T> ： 断言型接口
 *    抽象方法： boolean test(T t),传入一个参数，返回一个布尔值。
 *
 *    and()
 *    or()
 *  BiPredicate
 */
public class MyPredicate {

    public static void main(String[] args){

        System.out.println(isPhoneNumberValid("042300"));

        System.out.println(isPhoneNumberValidPredicate.test("0423002400"));
        System.out.println(
                isPhoneNumberValidPredicate.and(containNumber00).test("0423002400")
        );


    }

    static boolean isPhoneNumberValid(String phoneNumber){
        return phoneNumber.startsWith("04") && phoneNumber.length() == 10;
    }
    // boolean test(T var1);
    static Predicate<String> isPhoneNumberValidPredicate = phoneNumber ->
            phoneNumber.startsWith("04") && phoneNumber.length() == 10;

    static Predicate<String> containNumber00 = phoneNumber ->
            phoneNumber.contains("00");

}
