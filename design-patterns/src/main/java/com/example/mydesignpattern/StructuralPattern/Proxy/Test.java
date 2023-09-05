package com.example.mydesignpattern.StructuralPattern.Proxy;

/**
 * A proxy controls access to the original object, allowing you to perform something
 * either before or after the request gets through to the original object.
 *
 * 为其他对象提供一种代理以控制外部对这个对象的访问。
 * 一般认为代理模式侧重于使用代理类增强被代理对象的访问，而装饰者模式侧重于使用装饰者类来对被装饰对象的功能进行增减。
 * 装饰者模式主要是提供一组装饰者类，然后形成一个装饰者栈，来动态的对某一个对象不断加强，而代理一般不会使用多级代理。
 */
public class Test {
    public static void main(String[] args){

        ProxyPoint proxyPoint = new ProxyPoint();
        proxyPoint.sell();
    }
}
