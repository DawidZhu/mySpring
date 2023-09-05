package com.example.myCore;

/**
 * 15. Singleton Pattern
 *
 * 单例模式，利用static实现
 * 饿汉单例和懒汉单例
 * 单例的意思是一个类永远只存在一个对象，不能创建多个对象。
 * 作用：对象越多越占用内存，有时候只需要一个对象就可以实现业务。如：JVM、任务管理器
 * 如何实现单例：
 *  1，定义一个单例类；
 *  2，把类的构造器私有；
 *  3，定义静态成员变量用于存储一个对象；
 *  4，定义一个方法直接返回单例对象（饿汉，提前创建好）；不存在时才去创建一次，后面使用无需再创建（懒汉，需要时再去创建）
 *
 * 16. Enum
 *
 *  枚举类用于做信息标志和信息分类。
 *  An enum is a special "class" that represents a group of constants (unchangeable variables, like final variables).
 *  To create an enum, use the enum keyword (instead of class or interface), and separate the constants with a comma.
 *  枚举类第一行必须是枚举类的对象名称，而且是用常量存储。默认存储了枚举对象。
 *  枚举类是final 修饰的，不能被继承；
 *  枚举类的构造器是私有的，枚举类相当于多例设计模式。
 *  Java 中的每一个枚举都继承自 java.lang.Enum 类。当定义一个枚举类型时，每一个枚举类型成员都可以看作是 Enum 类的实例，
 *  这些枚举成员默认都被 final、public, static 修饰，当使用枚举类型成员时，直接使用枚举名称调用成员即可。
 *
 *  建议以后做信息标志和信息分类，使用枚举类型。
 */

/**
 * 枚举类 enum
 * 这些枚举成员默认都被 final、public, static 修饰，当使用枚举类型成员时，直接使用枚举名称调用成员即可。
 */
//public enum Oritation{
 enum Oritation{
    UP,
    DOWN,
    LEFT,
    RIGHT;
    }

public class David {

    /**
     * 饿汉单例设计模式:
     * 构造器私有, 定义静态成员变量用于存储一个对象，提供一个方法返回单例对象
     */
    public static David david = new David();

    /**
     * 私有构造器
     */
    private David() {
    }

    public static David getInstance(){
        return david;
    }

    /**
     * 饿汉单例设计模式:
     * 只定义Static，不创建
     */
     // public static Daniel daniel;

    /**
     * 饿汉单例设计模式:
     * if(daniel == null),   daniel = new Daniel();
     */
//    public static Daniel getInstance(){
//    if(daniel == null){
//        daniel = new Daniel();
//    }
//        return daniel;
//    }





    public static void main(String[] args){
        /**
         * 获取两个对象，测试是不是单例
         */
        David david1 = David.getInstance();
        David david2 = David.getInstance();
        David david3 = new David(); //private 方法，在本类中可访问
        System.out.println("测试是不是单例： ");
        System.out.println(david1 == david2); //ture ,"==" 对于对象，比较的是地址
        System.out.println(david1 == david3);
        System.out.println("Oritation.DOWN ====" + Oritation.DOWN);

        move(Oritation.RIGHT);

    }

    /**
     * 测试枚举类
     */
    public static void move(Oritation oritation){
        switch(oritation){
            case UP:
                System.out.println("向左移动...");
                break;
            case DOWN:
                System.out.println("向下移动...");
                break;
            case LEFT:
                System.out.println("向左移动...");
                break;
            case RIGHT:
                System.out.println("向右移动...");
                break;
        }
    }


}
