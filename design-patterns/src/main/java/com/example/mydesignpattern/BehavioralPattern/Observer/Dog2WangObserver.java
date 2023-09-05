package com.example.mydesignpattern.BehavioralPattern.Observer;

/**
 * Observer
 *
 * is a behavioral design pattern that lets you define a subscription mechanism to
 * notify multiple objects about any events that happen to the object they’re observing.
 *
 * 实现一个舔狗王二狗类
 * 在update方法中，接收到女神的通知后，根据不同的状态做出了相应的动作。
 */
public class Dog2WangObserver implements TianDogObserver{
    @Override
    public void update(String message) {
        if("肚子好饿".equals(message)){
            System.out.println("二狗：半夜起来，翻墙出去步行2公里买女神最爱吃的小笼包... 上官：二狗，你真是个好人");
        }else if("心情不好".equals(message)){
            System.out.println("二狗：官哭着述说渣男怎么欺负的她...整整3个小时，全程安慰... 上官：二狗，你真是个好人");
        }else {
            System.out.println("随叫随到...");
        }
    }
}
