package com.example.mydesignpattern.BehavioralPattern.Observer;

/**
 * 客户端调用时，先给被观察者通过add添加观察者，也就是让二狗和西门订阅上官的状态，以便于上官状态改变时可以得到通知。
 * 最后使用notifyState来通知观察者状态改变了。如果某个观察者不再对被观察者感兴趣，直接使用remove方法取消订阅即可。
 * 最后王二狗被绿茶婊上官伤透了心，和牛翠华走到了一起，从此二狗就不再关心上官的状态了，直接使用remove方法取消订阅。
 */
public class Test {

    public void sendThink(){
        //创建 subject, 被观察者对象，也叫Publsher
        GreenTeaSubject subject = new ShangGuanSubject();

        //创建 Observer, 观察者对象,也叫订阅者 Subscriber
        Dog2WangObserver dog2WangObserver = new Dog2WangObserver();
        // 给被观察者通过add添加观察者，建立起联系
        subject.add(dog2WangObserver);
        // subject.add(new YinDangObserver());

        // 被观察者发布消息
        System.out.println("------午夜12点，肚子好饿，找个人来买东西吃------");
        subject.notifyState("肚子好饿");
        System.out.println("------又被渣男甩了，有点小难过，找个人来安慰一下------");
        subject.notifyState("心情不好");
        System.out.println("------二狗终于看透了上官这个绿茶婊，和牛翠花走到了一起------");
        // 被观察者 移除观察者，取消联系
        subject.remove(dog2WangObserver);
        System.out.println("------上官又被渣男甩了，想找个人来安慰一下，却不见了那个好人的身影------");
        subject.notifyState("心情不好");
    }
}
