package com.example.mydesignpattern.BehavioralPattern.Strategy;

/**
 * 第三步：使用算法
 * 选择不同的 strategy，有不同的计算规则
 */
public class TrafficFeeCal {
    public int goToGC(Strategy strategy, int distance){
        //多态
        return strategy.calTraficFee(distance);

    }
}
