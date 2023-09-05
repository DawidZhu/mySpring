package com.example.mydesignpattern.CreationalPattern.abstractFactory;

/**
 * 第四步：客户端使用
 * 这里每个工厂生产的是那个品牌家族的一系列产品，而不是一个。例如切换到苹果工厂的话，就会产出苹果笔记本电脑和苹果手机。
 *
 *  Abstract Factory模式：Abstract Factory模式是一系列对象的创建，所以在抽象工厂类里面要创建一系列的对象的实例化，
 *  而不是单个对象的实例化。 切记这一系列对象存在一定的联系。
 *
 *  理解抽象工厂模式的核心关键在于理解品牌家族的概念，简单工厂方法模式与工厂方法模式创建工厂的着眼点为某类具体的产品，
 *  某个工厂与某个产品对应。而抽象工厂模式某个工厂与产品的家族对应，这个工厂可以生产这个品牌家族的一系列产品
 *
 *  抽象工厂模式技术要点总结:
 *  要准确识别出当前场景是在构建哪些产品家族的系列产品对象。
 *  每个产品家族的产品系列生产方法都要在 AbstractFactory 接口里面定义
 *
 *  总结
 *
 * 总的来说此模式在日常开发中使用频率不高，但关键时刻是能起大作用的。
 *
 * 设计模式值得你刻意练习
 *
 *
 */
public class Test {
    public static void main(String[] args){
        //使用苹果工厂生产苹果公司的系列产品
        AbstractFactory appleFactory = new AppleFactory();
        appleFactory.makeComputer().setOperationSystem();
        appleFactory.makePhone().setOperationSystem();

        //使用Win 工厂生产Win 公司的系列产品
        AbstractFactory winFactory = new WinFactory();
        winFactory.makeComputer().setOperationSystem();
        winFactory.makePhone().setOperationSystem();
    }
}
