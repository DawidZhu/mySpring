package com.example.mydesignpattern.BehavioralPattern.Strategy;
/**
 * 第二步：封装各个算法
 */
public class ByUber implements Strategy {
    @Override
    public int calTraficFee(int distance) {
        return distance*5;
    }
}
