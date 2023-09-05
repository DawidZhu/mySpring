package com.example.mydesignpattern.BehavioralPattern.Strategy;

/**
 * Strategy：
 * Strategy is a behavioral design pattern that lets you define a family of algorithms,
 * put each of them into a separate class, and make their objects interchangeable.
 * 就是：用OOPs去完成if-else的功能
 *
 * 策略模式定义了一系列的算法，并将每一个算法封装起来，使他们可以相互替换。
 * 第一步：封装不同的实现算法
 * 首先定义一个策略接口，规定算法的同一操作
 *
 * 当你写代码的时候发现一个操作有好多种实现方法，而你需要根据不同的情况使用if-else等分支结构来确定使用哪种实现方式的时候，
 * 想一想这个模式。
 */
public interface Strategy {
    int calTraficFee(int distance);
}
