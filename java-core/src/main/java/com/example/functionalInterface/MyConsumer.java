package com.example.functionalInterface;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

/**
 *   Consumer<T>：消费型接口
 *  抽象方法： void accept(T t)，接收一个参数进行消费，但无需返回结果。
 *  都是引用数据类型，不能是primitive type
 *  为了不new 对象，方法暂时使用 static
 *
 *   imperative : 命令式
 *   Producer Consumer Pattern
 */
public class MyConsumer {

    public static void main(String[] args){
        // Normal java Function
        Customer David = new Customer("David","123456");
        greetCustomer(David);
        // Consumer Functional interface
        greetCustomerConsumer.accept(David);
        // BiConsumer
        greetCustomerConsumerV2.accept(David, false);

    }

    /**
     *  BiConsumer,  比 Consumer 多了1个参数
     */
    static BiConsumer<Customer, Boolean> greetCustomerConsumerV2 = (customer, showPhone) ->
            System.out.println("Hello " + customer.customerName +
                    ", thanks for registering phone number :"
                    // A ？ B ：C (如果A为真执行B否则执行C)， 2 ==0 ? 1+ 1: 2-2;
                    + (showPhone ? customer.customerPhone : "*********"));
    /**
     * public interface Consumer<T>
     *     accept()
     *     andThen()
     *    Customer customer
     */
    static Consumer<Customer> greetCustomerConsumer = customer ->
            System.out.println("Hello " + customer.customerName +
                    ", thanks for registering phone number :"
                    + customer.customerPhone);
    /**
     * 静态方法
     */
    static void greetCustomer(Customer customer){
        System.out.println("Hello " + customer.customerName +
                ", thanks for registering phone number :"
                + customer.customerPhone);

    }

    /**
     * 内部静态类
     */
    static class Customer{
        private final String customerName;
        private final String customerPhone;

        public Customer(String customerName, String customerPhone) {
            this.customerName = customerName;
            this.customerPhone = customerPhone;
        }
    }
}
