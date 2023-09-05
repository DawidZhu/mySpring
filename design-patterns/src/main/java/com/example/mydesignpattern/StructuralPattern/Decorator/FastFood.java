package com.example.mydesignpattern.StructuralPattern.Decorator;

import lombok.Data;

/**
 * 基类
 * 抽象构件(Component)角色 :定义一个抽象接口以规范准备接收附加责任的对象
 */

public abstract class FastFood {
    private float price;
    private String desc;

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public FastFood() {
    }

    public abstract float cost(); //获取价格

    public FastFood(float price, String desc) {
        this.price = price;
        this.desc = desc;
    }
}
