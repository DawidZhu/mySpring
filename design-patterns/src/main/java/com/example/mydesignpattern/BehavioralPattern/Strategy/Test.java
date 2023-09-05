package com.example.mydesignpattern.BehavioralPattern.Strategy;

/**
 * 第四步：客户端调用
 * 根据情况，构建相应的算法类实例，传入计算器计算即可
 *
 *  优缺点
 * 优点：降低了算法类的职责，使各个算法可以独立变化并互相替换。而且使得增加新的算法变的很容易，降低了对原有系统的侵入，
 * 最终使得程序可扩展可维护性增强。
 *
 * 缺点：所有设计模式的通病，类增多了，程序从局部来看变的更复杂了
 */
public class Test {
    public static void main(String[] args){

        TrafficFeeCal trafficFeeCal = new TrafficFeeCal();
        int Fee = 0;
        // BYBUs
        Fee = trafficFeeCal.goToGC(new ByBus(), 10);
        System.out.println("BYBUs = " + Fee);
        // BYUber
        Fee = trafficFeeCal.goToGC(new ByUber(), 10);
        System.out.println("BYUber = " + Fee);
    }
}
