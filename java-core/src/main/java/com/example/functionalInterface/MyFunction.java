package com.example.functionalInterface;

import java.util.function.BiFunction;
import java.util.function.Function;

/**
 *  Function<T,R>: 函数型接口
 *     抽象方法： R apply(T t)，传入一个参数，返回想要的结果。
 * apply()
 * compose()
 * andThen()
 */
public class MyFunction {
    public static void main(String[] args){
        // Function takes 1 argument
        int increment = incrementByOne(1);
        System.out.println(increment);

        int increment2 = incrementByOneFunction.apply(1);
        System.out.println(increment2);

        int multiply = multiplyBy10Function.apply(increment2);
        System.out.println(multiply);

        /**
         * chain function 链式函数 andThen()
         */
        Function<Integer, Integer> addBy1AndThenMultiplyBy10 =
                // default <V> Function<T, V> andThen 方法
                incrementByOneFunction.andThen(multiplyBy10Function);

        int addAndmultiply = addBy1AndThenMultiplyBy10.apply(4);
        System.out.println(addAndmultiply);

        // Normal Java Function takes 2 arguments
        int byOneAndMultiply  = incrementByOneAndMultiply(4,100);
        System.out.println(byOneAndMultiply);

        // BiFunction takes 2 arguments
        int byOneAndMultiplyBi  = incrementByOneAndMultiplyBiFunction.apply(4,100);
        System.out.println(byOneAndMultiplyBi);

    }
    /**
     * @ FunctionalInterface
     * public interface Function<T, R> T:input, R:output
     * R apply(T var1);
     */
    static Function<Integer, Integer> incrementByOneFunction =
            number -> number +1;

    static Function<Integer, Integer> multiplyBy10Function =
            number -> number * 10;
    static int incrementByOne(int number){
        return number + 1;
    }
    /**
     *  public interface BiFunction<T, U, R> 3个参数
     * @ param t the first function argument
     * @ param u the second function argument
     */
    static BiFunction<Integer, Integer, Integer> incrementByOneAndMultiplyBiFunction =
            (numberToIncrementByOne, numberToMultiplyBy)
                    -> (numberToIncrementByOne + 1 ) * numberToMultiplyBy;
    static int incrementByOneAndMultiply(int number, int numToMultiplyBy){
            return (number +1) * numToMultiplyBy;
    }
}
