package com.example.myCore;

/**
 * 1. Class & Object
 *
 *  类：描述相同事物的共同特征的抽象。 Animal
 *  keyword: class, 类里写field，逻辑代码写在方法里
 *
 *  对象：是具体的实例，真实存在的。 cat, dog. 实例 = 对象
 *  Class is a template used to create objects and to define object data types and methods.
 *  A Java object is a member (an instance) of a Java class. Each object has an identity, a behavior and a state.
 *  Class 仅有5大成分： 1，成员变量 fields(字段)；2，成员方法 methods；3，构造器 constructor；4，代码块 static block；5，内部类 inner class。
 *  the type of Class: 1,static class(内部类); 2,final class(不能被继承); 3,abstract class(用来被继承); 4,concrete class;
 *  5,singleton class 6, inner class 7, POJO class(Plain Old Java Object)(readability & reusability )
 *  A concrete class is a class that we can create an instance of, using the new keyword.
 *  一个file可以包含多个class，但是只能有一个public，并且和file名一样,不建议！
 *  创建对象实例的时候类会被加载。
 *
 * 2. Constructor
 *
 *  作用：初始化一个对象并返回类的引用。 used to initialize the state of an object
 *  一个类，默认会有无参的构造器，如果已经提供了有参数构造器，无参的会消失。
 *  the constructor to initialize the instance variable of the class
 *  当你new一个对象时，就会调用构造器。 构造器的作用：实例化对象，给对象赋初始值
 *  It is invoked when the class is instantiated(实例化), and the memory is allocated for the object.
 *  Every time, an object is created using the new keyword, the default constructor of the class is called.
 *  The name of the constructor must be similar to the class name. The constructor can be overloaded.
 *
 * 3，This
 *
 *  this.属性 = 对象.属性
 *  "this 表示当前的对象" , this.就是当前的对象Object.
 *  this 用在实例方法和构造器中 Constructor
 *  this 用在方法中，哪个对象调用这个方法，this就代表谁
 *  this 用在构造器 constructor ，代表正在初始化 initialize 那个对象的引用
 *
 *  4. Static
 *
 *   根据有无static修饰，变量和方法分为 静态 Static variables/methods 和 实例 Instance variables/methods
 *   Static 意思是只有一份
 *   final 是"最终"的含义。 The word final means that cannot be changed.
 *   final 修饰变量，变量有且仅能被赋值一次。
 *  static 修饰的静态成员变量和方法; 只有一份，全局唯一，内存中唯一，属于类本身，而不是实例，和类一起加载，在任何地方都可以直接用类名访问，
 *  静态变量可以被共享访问，类名.xxx, 更方便。静态方法不能调用非静态的方法和变量。static void main()中不能调用非静态的变量
 *  无 static 的 是实例成员变量和方法，用来 new 出来的，属于具体对象。
 *  实例成员变量 Instance variable：无static修饰，属于每个对象，与对象一起加载。
 *  静态变量和方法可以用对象访问，不推荐。
 *  子类不能重写父类的static, static final 方法
 *
 *  5，Encapsulation
 *
 *  * 封装 Encapsulation  Make all the instance variables private and create setter and getter for those variables
 *  * 作用：安全访问、可维护；Protects the code and data from others.
 *  * 规范：1. 成员变量都私有，用 private 修饰. 只能在本类内部被直接访问。
 *  *      2. 提供getter, setter方法，来赋值、取值成员变量。 用 public 修饰
 *  * 核心思想：合理隐藏、合理暴露。
 *
 *  9，abstract
 *
 *  抽象类：本质上也是一个类，拥有抽象方法的类叫抽象类，抽象类不一定有抽象方法； 体现了模板思想 Template Method designPattern，
 *  部分实现，部分抽象。
 *  The class may or may not contain abstract methods
 *  抽象意味着不能被具体化。如果子类继承了抽象类，需要重写父类中的所有抽象方法。
 *  The concrete Subclass which extends the Abstract class should provide the implementation for abstract methods.
 *  抽象方法：只有方法名，没有方法体，用 abstract 修饰
 *  The abstract method which has only the declaration and not the implementation.
 *  作用：父类约定子类需要完成的方法；子类要完成这个功能，由子类自己重写完成 override
 *  特征：有得有失。 抽象类得到了拥有抽象方法的能力，失去了创建对象的能力。
 *  抽象类作为类，有构造器，提供给子类创建对象时，调用父类构造器，初始化父类成员使用的。
 *  抽象类虽然有构造器，但是不能创建对象。因为抽象方法不能执行，没有方法体。
 *  除了不能创建对象，可能拥有抽象方法，其他类的属性抽象类都具备。
 *
 *  核心意义：为了被子类继承。体现了模板思想，部分实现，部分抽象。
 *  抽象类不确定如何实现的定义为抽象方法，交给子类去实现。
 *
 *  10，design pattern ：template pattern
 *
 *  设计模式是总结的优秀软件设计架构和思想，可以直接拿来使用，提高开发效率，可扩展性，可维护性。
 *  A design patterns are well-proved solution for solving the specific problem/task.
 *  模板模式：写好的内容固定成模板，需要写的内容定义为抽象方法，让子类去写。
 *
 */
public abstract class Person {

    /**
     * 静态 变量 static variable / class variable
     */
    public static String GLOBAL_NAME = "Person_Earth"; // 不会包含在constructor
    /**
     * 常量
     */
    public static final String HOME_NAME = "Person_HOME_NAME"; // 不会包含在constructor
    /**
     * Instance variable
     */
    public  String address = "person address"; // public 测试使用

    /**
     * private Access Modifiers,仅在本类中访问
     */
    private City city; //reference type

    private String name;
    /**
     * 默认修饰符，本类、本包可以访问
     */
    int age;
    /**
     * 静态方法 static 修饰
     */
    public static void doEat(){
        System.out.println("Person do eating ...");
    }

    /**
     * static final 方法，不能被重写
     */
    public static final void doIniate(){
        System.out.println("Person do Iniate ...");
    }

    //public static abstract void doEat();

    /**
     * Instance methods
     * 实例方法，无static修饰
     */
    public void doSleep(){
        System.out.println(" Person doSleep ...");
    }

    /**
     * 私有的实例方法，只能在本类中访问，不能被子类使用
     */
    private void doLecture(){
        System.out.println("Person doLecture ...");
    }

    /**
     * 抽象方法
     * 只有方法名，没有方法体，用 abstract 修饰
     */
    public abstract void doTask();

    /**
     * 抽象类有构造函数
     * 有参数constructor
     * 哪个对象调用这个方法，this就代表谁,可以省略
     */
    public Person(String address, String name, City city, int age) {
        System.out.println("Person 父类 的有参数 构造器");
        this.address = address;
        this.name = name;
        this.city = city;
        this.age = age;
    }

    /**
     * 抽象类有构造器
     */
    public Person() {
        System.out.println("Person 父类 的无参数构造器");
    }

    /**
     * this 用在方法中，哪个对象调用这个方法，this就代表谁,可以省略
     */

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


}
