package com.example.myCore;

/**
 * 6. Inheritance
 *
 * extends 一个类只能继承一个直接父类，支持多层继承（类似家谱）
 * 一个类都是直接、间接继承了Object类
 * 继承 Inheritance 是一种子类到父类的关系"is a "的关系。 SuperClass SubClass
 * 私有成员变量、方法不能被继承。Private members can’t be inherited. 父类中的private修饰的属性是不能被子类继承的，
 * 父类中提供了public或者protected修饰的方法来访问该属性，比如set，get方法，这样在子类中是可以通过方法来使用该private属性的。
 * ******需要注意的是这里不能被子类继承并非指的是不能被子类使用，父类private属性是会存在于子类对象中的*****
 *
 * 继承后： 静态变量和方法可以直接使用，无需 new
 * 继承后：子类全部构造器会先 调用父类的无参构造器，再执行自己的构造器。 因为子类构造器默认有 super();
 *        逻辑：先有父类对象，再有子类对象。
 * 作用：提高代码复用，reused code
 * 子类更强大，除了继承父类的功能，还有自己特有的功能
 * 继承后成员变量/方法 访问：就近原则 当前方法内 > 子类 > 父类
 * 子类的构造器中，有默认的super(),需要访问父类构造器。
 *
 * this：代表当前对象，用于访问当前子类对象的成员变量/方法。 this代表当前调用的对象
 * super： 代表父类对象，用于访问父类中的成员变量/方法。 Super代表父类
 *
 * 7. Method Overriding  & Method Overloading
 *
 * 方法重写 Overriding：子类继承了父类，子类就得到了父类中的方法，但是子类觉得父类中的方法无法满足自己的要求
 * 子类重写了一个和父类名称、参数、返回值一样 的方法来覆盖父类中的方法
 * Method name should be the same, the argument should be the same, return type should also be the same.
 * 原则：申明不变，重新实现
 * 方法重载： method Overloading
 * Same method name, different argument types, there may be different return types.
 * 静态方法和私有方法不能被重写！编译不通过
 *
 * 8. reference type & primitive type
 *
 *  数据类型: 引用类型 & 原始类型
 *  The main difference between primitive and reference type is that primitive type always has a value,
 *  it can never be null but reference type can be null
 *  Java提供了两类数据类型：一种是基本类型 primitive（原始类型byte short int long,char,boolean），一种是引用类型（string, class、interface、array）。
 *  除了基本类型都是引用类型。引用类型存放的是地址
 *
 *  17. Polymorphism
 *
 *  多态： 同一个类型的对象，执行同一个方法，在不同的状态下会表现出不同的行为特征。方法存在重写，有多态；变量没有重写概念，不存在多态。
 *  The polymorphism means many forms.
 *  A single object can refer to the super-class or sub-class depending on the reference type which is called polymorphism.
 *  Polymorphism is applicable for overriding and overloading.
 *  Inheritance lets us inherit properties and methods from another class.
 *  Polymorphism uses those methods to perform different tasks.
 *  对于方法调用：编译看左边，运行看右边；
 *  对于变量的调用：编译看左边，运行看左边；
 *  方法存在重写，有多态；变量没有重写概念，不存在多态。
 *  多态使用前提：1，必须存在或实现继承；2，必须存在父类类型的变量引用子类类型的对象；3，必须存在方法重写。
 *  优势：
 *      1，多态形式下，右边对象可以实现组件化切换，业务也随之改变，便于维护，实现类与类之间的解耦。
 *      2，开发过程中，父类类型作为方法形式参数，可以传入一切子类对象进行方法调用，扩展性和便利性。
 *  劣势：
 *      1，多态形式下，不能直接调用子类特有的功能。编译看左边！
 *      可以通过强制类型转换完成。
 *  类型转换：自动类型转换、 强制类型转换
 *
 *  建议：JAVA 建议在进行强制类型转换之前先判断变量的真实类型。
 *  使用 instanceof ，返回true才可以。
 *
 *  18. String
 *
 *  public final class String
 *  String is a sequence of characters. But in Java, string is an object that represents a sequence of characters.
 *  The java.lang.String class is used to create a string object.
 *  Strings are constant; their values cannot be changed after they are created.?
 *
 *  we can't perform any changes in the existing object. It is nothing but Immutability of a String object.
 *  String is an immutable class. This means that once you instantiate an instance of a string like so:
 *  String str1 = "hello";
 *  The object in memory cannot be altered. Instead you will have to create a new instance,
 *  copy the old String and append whatever else as in this example:
 *  String str1 = "hello";
 *  str1 = str1 + " world!";
 *  What is really happening hear is that we are NOT updating the existing str1 object...
 *  we are reallocating new memory all together, copying the "hello" data and appending " world!" to the end,
 *  then settings the str1 reference to point to this new memory. So it really looks more like this under the hood:
 *  String str1 = "hello";
 *  String str2 = str1 + " world!";
 *  str1 = str2;
 *
 *  String buffers support mutable strings. Because String objects are immutable they can be shared.
 *  String 是引用数据类型，String 对象
 *  "==" 对于对象，比较的是地址
 *  String 的equals() 重写了object的equals()，比较的是内容。
 *   * 当使用引号赋值，系统会检查该字符串在串池中是否存在，不存在创建新的，存在就复用。
 *   * 当使用new 赋值，每次都创建新对象。
 *
 * Memory allocations in JVM
 *
 *  1.线程共享：  Method Area, Heap
 *      Heap ： 是 JVM 所管理的内存中最大的一块。线程共享，主要是存放对象实例和数组。 Garbage Collector 负责回收
 *      堆：存放引用数据类型的数据与new出来的对象，注意创建出来的对象只包含各自的成员变量，不包括成员方法。
 *      Method Area ： 一个JVM 只有一个 空间，被所有线程共享， static，constant, class信息
 *      在方法区中，存储了每个类的信息（包括类的名称、方法信息、字段信息）、静态变量、常量以及编译器编译后的代码等
 *  2.非线程共享：Stack, native Method Area, Program Counter
 *      Stack: new Thread()会创建一个新的Stack 空间，存储基本数据类型，Heap中对象的地址存储在Stack中；
 *      栈：栈是运行时的单位，Java 虚拟机栈，线程私有，生命周期和线程一致.
 *      描述的是 Java 方法执行的内存模型：每个方法在执行时都会创建一个栈帧(Stack Frame)用于存储各种基本数据类型、对象引用(reference 类型)
 *      和 returnAddress 类型(指向了一条字节码指令的地址), 方法出口等信息。
 *      存放基本数据类型的数据、引用数据类型的变量名及对象的引用，但是引用的数据与对象并不放在栈中，而是放在堆中。
 *
 *    堆Heap 和栈Stack 的对比
 *   一、栈解决程序的运行问题，即程序如何执行，或者说如何处理数据；堆解决的是数据存储的问题，即数据怎么放、放在哪儿。
     二、栈因为是运行单位，因此里面存储的信息都是跟当前线程相关的信息。包括：局部变量、程序运行状态、方法返回值等等；而堆只负责存储对象信息。
     三、在方法中定义的一些基本类型的变量和对象的引用变量都是在函数的栈内存中分配。堆内存用于存放由new创建的对象和数组。
     四、在Java中一个线程就会相应有一个线程栈与之对应，这点保证了程序的并发运行。
     而堆则是所有线程共享的，也可以理解为多个线程访问同一个对象，比如多线程去读写同一个对象的值
    堆(heap):先进先出,栈(stack)先进后出
 *
 *  String str = “abcdef” ; 会先在Heap 中 常量池 找是否有字符串 “abcdef”,有的话，直接把 Heap 中 常量池的"abcdef"地址赋值给 str ,
 *  没有的话就在Heap 中 常量池开辟一块空间，储存 "abcdef"并赋值"abcdef"的地址给str，
 *  String的内容是存放在堆中的字符串常量池（StringPool，也可叫StringTable）中的，字符串常量池中相同的字符串只会创建一份，
 *  所以无论如何str的地址是指向Heap 中 常量池,因为不是基本 数据类型
 *
 *  String str2 = new String（“abcdef”），新建一个对象，str2的地址是指向堆空间的对象
 *
 *   Use String--->If you require immutabilty
 *  Use StringBuffer---->If you require mutable + threadsafety
 *  Use StringBuilder--->If you require mutable + with out threadsafety
 *
 */

public class Student extends Person {

    public String studentNo;
    public String className;
    // 子类重新赋值类变量 address
    public String address = "Student address";
    public static String GLOBAL_NAME = "Student_Earth"; // 不会包含在constructor

    /**
     * 子类修改父类的 常量？
     * 还是子类重新定义了常量？
     */
    public static final String HOME_NAME = "Student_HOME_NAME"; // 不会包含在constructor

    /**
     * 子类构造器，默认有super(),调用父类的构造器，因为先有父类再有子类
     */
    public Student() {
        System.out.println("Student 子类 的无参数构造器");
    }

    /**
     * 含全部参数的构造方法，调用父类的构造方法
     */
    public Student(String address, String name, City city, int age, String studentNo, String className) {
        super(address, name, city, age);
        this.studentNo = studentNo;
        this.className = className;
    }

    public Student(String studentNo, String className) {
        this.studentNo = studentNo;
        this.className = className;
    }

    /**
     * 重写父类的静态方法, 编译不通过
     */
    // @Override
    public static void doEat(){
        System.out.println("Student do eating ...");
        System.out.println("Student do eating ...");
    }

    /**
     * static final 方法，不能被重写
     */
//    public static final void doIniate(){
//        System.out.println("Student do Iniate ...");
//    }

    /**
     * 重写了父类Person的方法 override
     */
    @Override
    public void doSleep(){
        System.out.println(" Student doSleep ...重写了父类Person");
    }

    /**
     * 子类继承父类的抽象方法
     */
    @Override
    public void doTask() {
        System.out.println(" doTask ... 子类中的，Student 的 task 是学习");
    }

    /**
     * 子类特有的方法
     */
    public void doHomework() {
        System.out.println("Student doHomework ...");
        //方法重新赋值 变量
        String address = "doHomework address";
        System.out.println(address); // 访问方法变量
        System.out.println("this.address>>>" + this.address); //访问当前类的变量 this. = object.
        System.out.println("super.address>>>>>" + super.address); //访问父类的变量
    }



    public String getStudentNo () {
            return studentNo;
        }

        public void setStudentNo (String studentNo){
            this.studentNo = studentNo;
        }

        public String getClassName () {
            return className;
        }

        public void setClassName (String className){
            this.className = className;
        }

        @Override
        public String getAddress () {
            return address;
        }

        @Override
        public void setAddress (String address){
            this.address = address;
        }

    /**
     * 测试变量的默认值
     */
    int j;
    String str;
    Integer integer;

    /**
     * 测试
     * @param args
     */
    public static void main (String[]args) throws Throwable {
        // studentNo = "";  static void main()中不能调用非静态的变量

        Student student = new Student("GC","Daniel",null,10,"00","D");
        student.doHomework();
        student.doSleep();
        //student.finalize();

        System.out.println("$$$$$$$$$$$$$$$$$$$$");
        //System.out.println("j ===" + j);
       // System.out.println("str ===" + str);
        System.out.println(student.getAddress()+student.getName());
        //student.doLecture();  不能继承父类的私有方法
        System.out.println(GLOBAL_NAME);
        /**
         * 访问 static 方法， class.method
         */
        doEat();
        Person.doEat();

        /**
         * 测试多态
         */
        System.out.println("*****测试多态*******");
        //子类实例化，先调用父类的无参构造器
        Person student1 = new Student();
        Student student2 = new Student();
        Person teacher1 = new Teacher();
        Teacher t1 = new Teacher();
        student1.doSleep();
        teacher1.doSleep();
        // 测试变量
        System.out.println("student1.address: "+ student1.address);
        System.out.println("teacher1.address: " + teacher1.address);

        System.out.println("student1.getAddress(): "+ student1.getAddress());
        System.out.println("teacher1.getAddress(): " + teacher1.getAddress()); // 和重写不重写getter,setter方法有关

        System.out.println("name : "+student2.address); //public 属性直接访问
        /**
         * 测试 extends
         * age 是private 属性，但是子类可以通过setter,getter方法使用该属性
         * 父类中的private属性是存在于子类对象中的，只是子类不能直接访问。
         */
        System.out.println("getName: "+student2.getName()); //private 属性通过get访问

        System.out.println("student2 address : "+ student2.address); // 就近原则，方法变量 > 子类变量 > 父类变量

        givePoints(student1);
        givePoints(teacher1 );
        /**
         * 多态形式下，不能调用子类特有功能
         * 可以通过强制类型转换解决
         */
        //  teacher1.work();
        t1 = (Teacher) teacher1;
        /**
         * 常量
         */

        System.out.println(HOME_NAME);
        doEat();
        student1.doSleep();
        System.out.println(student1.address);
       // HOME_NAME = "NewName";
        /**
         * String 测试
         * String is an immutable class.
         * 当使用引号赋值，系统会检查该字符串在串池中是否存在，不存在创建新的，存在就复用。
         * 当使用new 赋值，每次都创建新对象。
         */
        String str1 = "abcd";
        //当使用引号赋值，系统会检查该字符串在串池中是否存在，不存在创建新的，存在就复用
        String str2 = "abcd";
        System.out.println("str1 == str2>>>>>> " );
        str2.compareTo(str1);
        System.out.println("str2.compareTo(str1)>>>>>>"+ str2.compareTo(str1));
        System.out.println(str1 == str2);
        System.out.println("str1.hashCode>>>"+ str1.hashCode());
        System.out.println("str2.hashCode>>>"+ str2.hashCode());
        // 每次都创建新对象，所以地址不相等
        String str3 = new String("abcd");
        String str4 = new String("abcd");
        System.out.println("str3 == str4>>>>> " );
        System.out.println(str3 == str4);
        System.out.println("str3.equals(str4)>>>>" + str3.equals(str4));
        System.out.println("str3.hashCode>>>"+ str3.hashCode());
        System.out.println("str4.hashCode>>>"+ str4.hashCode());

        str1.concat("");
        str1 = str1 + str3;
        System.out.println("str1>>>>" + str1);
        StringBuffer sb = new StringBuffer("abcdefg");


    }

    /**
     * 使用多态传递形式参数
     * @param person
     */
    public static void givePoints(Person person){
        if(person instanceof Student){
            ((Student) person).doHomework();
            System.out.println("Student 打分...");
        }
        if(person instanceof Teacher){
           ((Teacher) person).doLecture();
            System.out.println("Teacher 打分...");
        }
    }
}
