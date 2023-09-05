package com.example.myCore;

import java.util.ArrayList;
import java.util.Objects;

/**
 * 继承抽象方法，必须重写父类的抽象方法
 * 实现类实现接口，必须实现接口中的所有抽象方法
 *
 * 12. static block
 *
 *  代码块按照有无static 修饰，分为静态代码块、实例代码块
 *  静态代码块，必须用static修饰。属于类，会与类一起优先加载，而且自动触发执行一次！
 *  静态代码块用于在执行方法之前的进行静态资源的初始化操作。
 *  Static block code executes only once during the class loading.
 *
 *  13. final
 *
 *  final 是"最终"的含义。 The word final means that cannot be changed.
 *  final simply makes the object reference unchangeable.
 *  final 可以用于修饰类、方法、变量。 final:在运行中不能被修改。
 *  1,final修饰类：类不能被继承。The purpose of the final class is to make the class immutable like the
 *      String class.Remember that the final class cannot be extended.
 *  2,final修饰方法：方法不能被重写。
 *  3,final修饰变量，变量有且仅能被赋值一次。但是可以在子类中重新 赋值。
 *   abstract 与 final的关系？  互斥！不能同时出现修饰成员！
 *
 *   14.  types of variables  变量的种类
 *
 *   成员变量：Member variables
 *      1,静态成员变量 Static ：有static修饰，属于类，所以也称为类变量，只加载一份。Static variable = Class Variables
 *      Static variable / Class Variables : This variable is initialized only once, just when the program execution starts.
 *      2,实例成员变量 Instance Variables (Non-Static Fields) ：无static修饰，属于每个对象，与对象一起加载。
 *      Instance variable: This Java variable is defined without the STATIC keyword, but as outside of a method declaration.
 *   3,局部变量 Local variable：只能在方法中，构造器中，代码块中，for循环中，用完作用范围就消失。
 *   Local variable: This is a variable that is declared inside the body of a method.
 *   final 修饰局部变量，让值被固定或者保护起来，执行过程防止被修改。
 *   There are several kinds of variables:
 *  Member variables in a class—these are called fields.
 *  Variables in a method or block of code—these are called local variables.
 *  Variables in method declarations—these are called parameters.
 *
 *  18. inner class
 *
 *  定义在一个类里面的类就是内部类
 *  作用：可以提供更好的封装性，内部类有更多的权限修饰符， 封装性有更多的控制。 体现出组件的思想。
 *  静态内部类：有static修饰，属于外部类本身，只会加载一次。内部类特点与外部类是完全一致的。
 *  静态内部类可以直接访问外部类的静态成员。
 *  静态内部类不可以直接访问外部类的实例成员。外部类的成员必须用外部类对象访问。
 *  匿名内部类（重点）
 *      就是一个没有名字的内部类。目的：简化代码。
 *      匿名内部类一旦写出来，就会立即创建一个匿名内部类的对象返回。
 *      匿名内部类的对象类型相当于是当前new的那个的类型的子类型。
 *
 *      相同包下的类可以直接访问，不同包下的类必须导包才可以访问。
 *
 *  19. Access Modifiers
 *
 *  访问修饰符有4种，private -> default -> protected -> public
 *  可以修饰 成员变量，方法，构造器，内部类。
 *  private: 仅在本类中可以访问；
 *  default: 本类、本包中可访问；
 *  protected: 本类、本包、其他包下的子类中可访问；
 *  public: 所有地方都可访问；
 *
 *  20. Class Object
 *
 *  Object 类是JAVA中的祖宗类。 一个类要么默认继承、要么间接继承Object.
 *  toString()方法：默认输出的是地址信息；
 *  toString() 存在意义就是被子类重写，以便返回对象的内容信息。
 *  equals(Object obj): 比较两个对象的地址是否相等。 可以用 == 代替。
 *  String 的equals() 重写了object的equals()，比较的是内容。
 *  equals()存在的意义也是被重写，目的是对比两个对象的内容是否一样。
 *
 *  在Java中，数组和String字符串都不是基本数据类型，它们被当作类来处理，是引用数据类型。
 *
 *  Objects的方法：
 *         public static boolean equals(object a, object b) 底层进行了非空判断，更安全！也是比较的地址。
 *          return (a == b) || (a != null && a.equals(b));
 *         public static boolean isNull(Object obj)  判断是否为空
 *   "=="
 *      对于基本数据类型(8种)，比较内容是否相等；
 *      对于引用数据类型，判断对象的内存地址是否相等
 *
 *   null:
 *     null是Java中的关键字，像public、static、final,它是大小写敏感的. 任何引用类型的默认值都会被设置为null.
 *     就像每种原始类型都有默认值一样，int默认值为0，boolean的默认值为false，null是任何引用类型的默认值
 *     要澄清一些误解，null既不是对象也不是一种类型，它仅是一种特殊的值，你可以将其赋予任何引用类型
 *     可以使用== 或者 != 操作来比较null值
 *
 * 注意：string str = "abc"; 与 string str = new String("abc");
 *
 */
public final class Teacher extends Person implements Worker {

    /**
     * final 修饰静态变量，变成常量。不能再被赋值
     * 只能在定义的时候或在静态代码块中赋值一次！！！
     */
    public static final String HOME_COUNTRY = "CHINA";
    /**
     * final 修饰实例成员变量,无意义。因为创建对象后也不能修改final修饰的username
     */
    public final String userName = "David";
   // userName = "DavidZhu"； 错误，不能再被赋值

    private String name;
    /**
     * 子类重新赋值父类变量
     */
    public String address = "Teacher address";

    /**
     * 有参构造器赋值，仅含子类参数
     * 默认有super()
     */
    public Teacher(String name, String address) {
        this.name = name;
        this.address = address;
    }

    /**
     * 有参构造器赋值,默认有super()
     */
    public Teacher(String address, String name, City city, int age, String name1, String address1) {
        super(address, name, city, age);
        this.name = name1;
        this.address = address1;
    }


    /**
     * 静态代码块,属于类，会与类一起优先加载，而且自动触发执行一次！
     */
    static{
        System.out.println("Teacher 静态代码块执行 ...");
    }
    /**
     * 无参构造器
     */
    public Teacher() {
    }

    /**
     * 通过有参构造器赋值
     * @param name
     */
    public Teacher(String name) {

        this.name = name;
    }


    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getAddress() {
        return address;
    }

    @Override
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * 子类特有的方法
     */
    public void doLecture(){
        System.out.println(" Teacher doLecture...");
    }

    /**
     * 重写 Persons 的抽象方法
     */
    @Override
    public void doSleep (){
        System.out.println(" Teacher doSleep ...重写了父类Person");
    }

    @Override
    public void doTask() {

        System.out.println("Teacher doTask ... 子类中的，   Teacher 的 task 是 讲课");
    }

    /**
     * 重写通过接口worker实现的方法
     */
    @Override
    public void work() {
        System.out.println( name + " Teacher is working... ");
    }
    /**
     * 重写通过接口worker实现的方法
     */
    @Override
    public void rest() {
        System.out.println( name + " Teacher is resting...");
    }

    /**
     * worker接口的static方法和默认方法
     */
    // public void doTest();
    @Override
    public void testInterface() {
        System.out.println("testInterface in Teacher ......." );

    }

    /**
     * 默认重写了 object类的toString方法
     * @return
     */
    @Override
    public String toString() {
        return "Teacher{" +
                "userName='" + userName + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    /**
     * 默认重写了 equals
     * 谁调这个方法，this就代表谁！！！this = 当前对象。this. 可以省略
     * @param o
     * @return
     */
    @Override
    public boolean equals(Object o) {
        System.out.println("进入重写的equals方法>>> ");
        //this 代表当前对象，如果地址相等，返回true
        if (this == o) return true;
        //判断是否为null, 以及类型是否一样，同类型的才能比较内容是否相等。防止拿两个不同的对象去比较。比如 people & pig
        if (o == null || getClass() != o.getClass()) return false;
        // 强制类型转换
            Teacher teacher = (Teacher) o;

        return userName.equals(teacher.userName) && name.equals(teacher.name) && address.equals(teacher.address);
    }

    /**
     * 重写hashCode: 只要两个对象的内容一样，返回的hashCode值也要一样！
     * 因为入参一样，结果也一样
     * @return
     */
    @Override
    public int hashCode() {
        return Objects.hash(userName, name, address);
    }

    public static void main(String[] args){
        /**
         * final 修饰局部变量，不能被修改
         */
        final double rate = 3.14;

        char ch = 'q';
        int i = 12345678;



        Teacher teacher = new Teacher("David","Ashmore");
        Teacher teacher2 = new Teacher("David","Ashmore");
        //测试重写接口中的默认方法
        teacher.testInterface();

        teacher.work();
        teacher.rest();
        System.out.println("teacher.getClass = " + teacher.getClass());
        System.out.println("teacher2.getClass = " + teacher2.getClass());
        // teacher.getClass = class com.myCore.Teacher
        // teacher2.getClass = class com.myCore.Teacher

        Student  student1 = new Student("001","1D");
        Student  student2 = new Student("001","1D");
        Student  student3 = student1;

        int int1 = 1;
        int int2 = 1;

        /**
         * new 内部类
         */
        testInner testInner = new testInner();

        System.out.println( teacher);
        System.out.println( teacher.toString());
        // 获得对象是哪个类
        System.out.println( teacher.getClass());

        /**
         * 判断对象内容是否相等：
         * 需要重写 equals()，或者用：Objects 对象方法
         * * a != null && a.equals(b) 安全的写法
         */

        System.out.println("Objects.equals(teacher,teacher2)>>>>>>>");
        System.out.println(Objects.equals(teacher,teacher2)); // 不重写的话，Objects.equals 比较的是地址


        System.out.println("teacher.equals(teacher2)>>>>>");
        System.out.println(teacher.equals(teacher2)); //因为重写了equals(),所以比较了内容是否相等。
        System.out.println("teacher == teacher>>>>>>>");
        System.out.println(teacher == teacher);
        //System.out.println(teacher.isNull);

        /**
         *  == 比较对象的地址是否相等
         */
        System.out.println(" student1 == student3 地址是否相等: ");
        System.out.println(student1 == student3);
        System.out.println(" int1 == int2  数值是否相等>>>>>>> ");
        System.out.println(int1 == int2);

        /**
         * String 的equals() 重写了object的equals()，比较的是内容。
         */
        String str1 = "david";
        String str2 =  new String("david");
        System.out.println("str1.equals(str2)>>>>>");
        System.out.println(str1.equals(str2));

        /**
         * 范型  Generics
         */
        ArrayList list = new ArrayList();
        list.add(student1);
        list.add("123");
        // 添加范型标签 <string>后，只能放String
        ArrayList<String> lists = new ArrayList();
        lists.add("abc");

        //ArrayList<T> arrayList = new ArrayList<T>();

        /**
         * hashCode()
         */
        System.out.println( "teacher.hashCode: ");
        System.out.println( teacher.hashCode());
        System.out.println( teacher2.hashCode());

    }

    /**
     * 定义内部类,静态内部类
     */
    public static class testInner {

        private String innerName;
    }
}
