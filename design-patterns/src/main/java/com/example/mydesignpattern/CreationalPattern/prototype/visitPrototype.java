package com.example.mydesignpattern.CreationalPattern.prototype;

public class visitPrototype {

    public static void main(String[] args) throws CloneNotSupportedException {

        RewardPrototype rewardPrototype1 = new RewardPrototype();
        rewardPrototype1.setName("David");
        // 关键一句
        RewardPrototype rewardPrototype2 = (RewardPrototype) rewardPrototype1.clone();
        rewardPrototype2.setName("Nina");

        rewardPrototype1.show();
        rewardPrototype2.show();

        System.out.println(rewardPrototype1 == rewardPrototype2);

    }
}
