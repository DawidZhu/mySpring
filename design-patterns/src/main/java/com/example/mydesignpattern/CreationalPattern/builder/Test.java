package com.example.mydesignpattern.CreationalPattern.builder;

public class Test {
    public static void main(String[] args){
        /**
         * Director 需要一个builder参数，来实例化构造方法
         */

        Director director = new Director(new OfoBuilder());

        Bike bike = director.buildBike();

        System.out.println(bike.getFrame());


    }
}
