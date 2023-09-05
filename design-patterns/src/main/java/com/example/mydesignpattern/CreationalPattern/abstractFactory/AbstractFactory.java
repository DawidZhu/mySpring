package com.example.mydesignpattern.CreationalPattern.abstractFactory;


/**
 *  第三步：定义工厂类
 * 注意：这里的工厂不是按照具体的产品类型定义，而是按照品牌家族来定义。
 * 例如现在有两个品牌小米和苹果，那么就需要分别为这两个品牌各定义一个工厂，每个工厂生产这个品牌家族的一系列产品，例如笔记本电脑和手机。
 * 这里定义一个抽象工厂的接口，并提供小米和苹果这两个实现类。
 *
 * 创建型模式 Creational Pattern
 * 主要关注点是“怎样创建对象?”，它的主要特点是“将对象的创建与使用分离”。
 * 这样可以降低系统的耦合度，使用者不需要关注对象的创建细节。
 *
 * Abstract Factory Pattern says that just define an interface or abstract class for creating families of
 * related (or dependent) objects but without specifying their concrete sub-classes.
 * That means Abstract Factory lets a class returns a factory of classes. So, this is the reason that
 * Abstract Factory Pattern is one level higher than the Factory Pattern.
 *
 *  * The main difference between a "factory method" and an "abstract factory" is that
 *  * the factory method is a method, and an abstract factory is an object.
 *
 * Abstract Factory模式：Abstract Factory模式是一系列对象的创建，所以在抽象工厂类里面要创建一系列的对象的实例化，
 * 而不是单个对象的实例化。 切记这一系列对象存在一定的联系。
 *
 * 抽象工厂模式是工厂模式的升级版本，他用来创建一组相关或者相互依赖的对象。
 *
 * 工厂方法模式只有1种create， 当你要新增一类产品的时候， 得重新设计工厂接口类。
 * 而抽象工厂中， 直接在工厂接口类上新增方法， 后面的子类同一实现即可。
 * 新增接口方法， 不需要再新增接口类
 * 再通俗深化理解下：工厂模式针对的是一个产品等级结构 ，抽象工厂模式针对的是面向多个产品等级结构的。
 *
 * With the Factory pattern, you produce instances of implementations (Apple, Banana, Cherry, etc.)
 * of a particular interface -- say, IFruit.
 *
 * With the Abstract Factory pattern, you provide a way for anyone to provide their own factory.
 * This allows your warehouse to be either an IFruitFactory or an IJuiceFactory,
 * without requiring your warehouse to know anything about fruits or juices.
 *
 *
 *
 *
 */
public interface AbstractFactory {

    Computer makeComputer();
    Phone makePhone();
}
