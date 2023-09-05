package com.example.mydesignpattern.CreationalPattern.prototype;

/**
 * 原型类：prototype
 *
 * Prototype Pattern says that cloning of an existing object instead of creating new one
 * and can also be customized as per the requirement.
 * This pattern should be followed, if the cost of creating a new object is expensive and resource intensive.
 * 抽象原型类：规定了具体原型对象必须实现的clone()方法
 * 具体原型类：实现抽象原型类的clone 方法，它是可以被复制的对象。
 * 访问类：使用具体原型类中的 clone() 方法来复制新的对象
 * 使用场景：
 * 对象的创建非常复杂，可以使用原型模式快捷的创建对象。
 * 性能和安全要求比较高。
 */
public class RewardPrototype implements Cloneable{

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void show(){
        System.out.println("获奖同学："+ name);
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
