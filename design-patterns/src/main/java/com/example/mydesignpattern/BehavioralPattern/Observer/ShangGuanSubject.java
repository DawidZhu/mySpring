package com.example.mydesignpattern.BehavioralPattern.Observer;

import java.util.ArrayList;
import java.util.List;

/**
 * 被观察者，或者叫订阅主题de 实现类
 * 其持有一个对其感兴趣的观察者集合，当状态发生改变时就循环通知每个观察者。
 *
 * 被观察者，Subject 或者叫Observable 持有observer的集合
 */
public class ShangGuanSubject implements GreenTeaSubject{
    // 保存订阅者的list,其持有一个对其感兴趣的观察者集合，当状态发生改变时就循环通知每个观察者。
    private List<TianDogObserver> tianDogs = new ArrayList<>();
    @Override
    public void add(TianDogObserver observer) {

    }

    @Override
    public void remove(TianDogObserver observer) {

    }

    @Override
    public void notifyState(String state) {

    }
}
