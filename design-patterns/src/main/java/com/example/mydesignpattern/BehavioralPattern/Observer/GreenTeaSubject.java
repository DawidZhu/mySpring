package com.example.mydesignpattern.BehavioralPattern.Observer;

/**
 * 被观察者，或者叫订阅主题
 * 首先是上官无雪这个绿茶婊的类
 *
 * 先定义一个接口，很简单，包含一个用来订阅的方法add和取消订阅的方法remove。
 * 还有一个当状态发生改变时，用来通知其观察者的方法notifyState
 */
public interface GreenTeaSubject {
    void add(TianDogObserver observer);

    void remove(TianDogObserver observer);

    void notifyState(String state);
}
