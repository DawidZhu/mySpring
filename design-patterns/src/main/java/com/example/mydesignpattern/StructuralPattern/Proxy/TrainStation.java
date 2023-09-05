package com.example.mydesignpattern.StructuralPattern.Proxy;

/**
 * 第二步：实现接口
 */
public class TrainStation implements SellTickets{


    @Override
    public void sell() {
        System.out.println("火车站卖票");
    }
}
