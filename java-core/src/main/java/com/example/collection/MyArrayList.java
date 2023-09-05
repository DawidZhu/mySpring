package com.example.collection;

import com.example.myCore.City;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 *  ArrayList
 *
 *  non-synchronized： ArrayList
 *  synchronized： CopyOnWriteArrayList
 *  ArrayList 类是一个可以动态修改的数组，与普通数组的区别就是它是没有固定大小的限制，我们可以添加或删除元素。
 *  It implements the List interface of the collections framework.
 *  Unlike arrays, arraylists can automatically adjust their capacity when we add or remove elements from them.
 *  Hence, arraylists are also known as dynamic arrays.
 *
 *  使用场景：元素的个数不确定，并且经常进行元素的增、删、改、查操作。
 *  ArrayList 只能存储对象类型，不能存储基础数据类型。 primitive types, such as int, float, char, etc.
 *  It is required to use the required wrapper class in such cases.
 *  ArrayList<E> objectName =new ArrayList<>();　 // 初始化
 *  E: 泛型数据类型，用于设置 objectName 的数据类型，只能为引用数据类型。
 *
 *  ArrayList<Type> arrayList= new ArrayList<>();
 *  Here, Type indicates the type of an arraylist.
 *  ArrayList<int> al = ArrayList<int>(); // does not work
 *  ArrayList<Integer> al = new ArrayList<Integer>(); // works fine
 *
 *  有序的(maintains insertion order)，可重复(duplicate elements)，有索引。
 *  底层基于数组存储数据，查询快，增删慢！(相对链表而已)
 *  List<String> arrayList = new ArrayList<>();
 *  开发中 ArrayList 用的最多！
 *
 *                                     { HashSet<E> (实现类)  --> LinkedHashSet<> (实现类)
 *                     {  Set<E> (接口)
 *                                     { TreeSet<E> (实现类)
 * Collection<E>(接口)
 *                                     { ArrayList<E> (实现类)
 *                    {  List<E> (接口)
 *                                    { LinkedList<E> (实现类)
 * List 系列集合：
 *       添加的元素是有序的，可重复，有索引。
 *             ArrayList：有序的，可重复，有索引。底层基于数组存储数据，查询快，增删慢！ArrayList 功能几乎与List一致。
 *                      List<String> arrayList = new ArrayList<>();
 *             LinkedList：有序的，可重复，有索引。底层是基于链表的， 查询慢，增删快！LinkedList 多了很多基于链表的功能。
 *
 *  相比Collection 的3中遍历方式，多了for 循环遍历,List 集合有4种遍历方式。
 *
 *  LinkedList
 *
 *  链表（Linked list）是一种常见的基础数据结构，是一种线性表，但是并不会按线性的顺序存储数据，
 *  而是在每一个节点里存到下一个节点的地址。链表可分为单向链表和双向链表。
 *  与 ArrayList 相比，LinkedList 的增加和删除的操作效率更高，而查找和修改的操作效率较低。
 * Each element in a linked list is known as a node. It consists of 3 fields:
 * Prev - stores an address of the previous element in the list. It is null for the first element
 * Next - stores an address of the next element in the list. It is null for the last element
 * Data - stores the actual data
 * 以下情况使用 ArrayList :
 * 频繁访问列表中的某一个元素。
 * 只需要在列表末尾进行添加和删除元素操作。
 * 以下情况使用 LinkedList :
 * 你需要通过循环迭代来访问列表中的某些元素。
 * 需要频繁的在列表开头、中间、末尾等位置进行添加和删除元素操作。
 *
 *    ArrayList VS LinkedList
 *
 * LinkedList internally uses a doubly linked list to store the elements.
 * Manipulation with LinkedList is faster than ArrayList because it uses a doubly linked list,
 * so no bit shifting is required in memory.
 * ArrayList is better for storing and accessing data.
 * LinkedList is better for manipulating data.
 *
 * The memory location for the elements of an ArrayList is contiguous.
 * Generally, when an ArrayList is initialized, a default capacity of 10 is assigned to the ArrayList.
 *  In LinkedList, an empty list is created when a LinkedList is initialized.
 *
 *  LinkedList Stores 3 values (previous address, data, and next address) in a single position.
 *
 *     接口名	          Java8新加入的方法
 *  Collection   	  removeIf() spliterator() stream() parallelStream() forEach()
 *  List	          replaceAll() sort()
 *
 */
public class MyArrayList {
    public static void main(String[] args){

        /**
         * ArrayList: 有序，可重复，有索引
         * ArrayList 只能放对象，是一个数组队列，提供了相关的添加、删除、修改、遍历等功能。
         */
        ArrayList<City> arrayList = new ArrayList<>();
        City city1 = new City(1,"GZ","jingtai","5000");
        City city2 = new City(2,"GC","Ashmore","4214");
        arrayList.add(city1);
        arrayList.add(city2);
        System.out.println("arrayList.forEach: >>>>>>>> ");
        arrayList.forEach(city -> System.out.println(city));

        System.out.println("arrayList.stream().forEach: >>>>>>>>");
        arrayList.stream().filter(city -> city.getName() == "GC").forEach(city -> System.out.println(city));

        /**
         * ArrayList: 有序，可重复，有索引
         * ArrayList 只能放对象，是一个数组队列，提供了相关的添加、删除、修改、遍历等功能。
         */
        ArrayList<String> arrayList1 = new ArrayList<>();
        arrayList1.add("Java 123456");
        arrayList1.add("Java 1");
        arrayList1.add("Spring boot 2");
        arrayList1.add("Maven 3");
        arrayList1.add("Git 4");
        arrayList1.set(4,"Git 100"); // 修改指定位置的值
        // arrayList1.remove(3); // 删除指定位置的值
        /**
         * 1. List 基于索引的遍历，for loop
         */
        for(int i = 0; i< arrayList1.size(); i++){
            System.out.println("for 循环，arrayList1 :>>>>>>>>"+ arrayList1.get(i));
        }

        /**
         * 2. for-each loop Syntax,  arrayList
         * forEach() 方法与 for-each 循环不同
         * the for-each loop is used to iterate through elements of arrays and collections (like ArrayList).
         * for(dataType item : array)
         * array - an array or a collection
         * item - each item of array/collection is assigned to this variable
         */
        System.out.println("使用 for-each循环：>>>>>>>>");
        for(String str : arrayList1){
           System.out.println(str);
         }
        /**
         * 3.forEach() 方法
         * forEach() 方法与 for-each 循环不同
         * 用于遍历动态数组中每一个元素并执行特定操作。
         * arraylist.forEach(Consumer<E> action)
         * action - 对每个元素执行的操作
         * Lambda 表达式 遍历
         * ->前是方法的参数，->后是方法体
         */
        System.out.println("forEach 方法：>>>>>>>>");
        arrayList1.forEach(s -> System.out.println(s));
        System.out.println("forEach, 在每个字符串前加上hello ：>>>>>>>>");
        arrayList1.forEach(s -> {
            s = "Hello, " +s;
            System.out.println(s);
        });
        /**
         *  <? extends T>和<? super T>表示java泛型中的上界和下界的概念，
         *  解释： 传入一个Consumer 类型的对象，对象 重写了accept方法
         *  然后对 arrayList1的每个值执行一遍 重写的方法
         */
        arrayList1.forEach(new Consumer<String>() {
            @Override // 函数式接口中需要重写的方法
            public void accept(String s) {
                s = "Hello!!! " + s;
                System.out.println(s);
            }
        });
        /**
         * 更简化的方式
         */
        System.out.println("System.out::println :>>>>>>>>");
        arrayList.forEach( System.out::println);

        /**
         * 4. Iterator 遍历
         * 得到集合的迭代器,游标方式
         */
        System.out.println("Iterator 遍历: >>>>>>>>");
        Iterator<String> iterator = arrayList1.iterator();

        while(iterator.hasNext()){
            String str = iterator.next();
            System.out.println(str);
        }

        /**
         * 排序方法
         *   Collections.sort() 用法
         *   1. 对String 类型进行排序，按默认自然顺序排序
         *   2. 对Object 对象进行排序，需要实现comparator 或对象实现 comparable 接口
         *
         */
        System.out.println("Collections.sort(): >>>>>>>>");
        Collections.sort(arrayList1);
        arrayList1.forEach(s -> System.out.println(s));

        /**
         *  arraylist.sort(Comparator c) 方法
         *  comparator - 顺序方式
         *  sort() 方法不返回任何值，它只是更改动态数组列表中元素的顺序。
         */
        // 以自然顺序排序
        arrayList1.sort(Comparator.naturalOrder());
        System.out.println("naturalOrder: >>>>>>>>");
        arrayList1.forEach(s -> System.out.println(s));
        // 降序
        arrayList1.sort(Comparator.reverseOrder());
        System.out.println("reverseOrder: >>>>>>>>");
        arrayList1.forEach(s -> System.out.println(s));
        /**
         *   重写 comparator  方法，自定义排序方式
         *    字符串长短排序，返回 -1 交换顺序
         */
        arrayList1.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        });
        System.out.println("自定义，字符串长短排序: >>>>>>>>");
        arrayList1.forEach(s -> System.out.println(s));

        /**
         * removeIf() 方法用于删除所有满足特定条件的数组元素。
         * arraylist.removeIf(Predicate<E> filter)
         * filter - 过滤器，判断元素是否要删除
         * 如果元素被删除则返回 true。
         * 删除包含 java的元素
         */
        arrayList1.removeIf(new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return s.contains("Java");
            }
        });

        //Lambda 表达式写法
        System.out.println("removeIf(): >>>>>>>>");
        arrayList1.removeIf(s -> s.contains("Java"));
        arrayList1.forEach(s -> System.out.println(s));
        /**
         *  replaceAll()
         *  用于将给定的操作内容替换掉数组中每一个元素。
         *  arraylist.replaceAll(UnaryOperator<E> operator)
         *  operator - 要替换到动态数组的元素或者一系列操作
         */
        System.out.println("replaceAll(), toUpperCase():>>>>>>>>>> ");
        arrayList1.replaceAll(s -> s.toUpperCase());
        arrayList1.forEach(s -> System.out.println(s));


        /**
         * 两个集合 合并
         * addAll()方法
         */
        System.out.println("合并集合，addAll()方法：>>>>>>>>");
        Collection<String> listNew = new ArrayList<>();
        listNew.add("Spring Cloud 5");
        arrayList1.addAll(listNew);
        System.out.println(arrayList1);
        /**
         * 指定位置插入元素。
         * add()
         */
        arrayList1.add(1,"NINA");
        System.out.println("new arrayList >>>>>>>>:"+ arrayList1);
        /**
         * 修改索引位置的元素
         * set()
         */
        arrayList1.set(1,"Nina");
        /**
         * ArrayList 删除元素，并返回被删除的元素。
         * remove()
         */
        // arrayList1.remove(2);

        /**
         * arrayList convert to String
         */
        System.out.println("arrayList1 convert to String: >>>>>>>>"+ arrayList1.toString());

        /**
         * arrayList convert to array
         * arraylist.toArray(T[] arr) 方法
         * Note: Here, T specifies the type of the array.
         *
         */
        String[] array = new String[arrayList1.size()];
        arrayList1.toArray(array);
        System.out.println("arraylist.toArray: >>>>>>>>");
        // 获取Array的Stream流： Arrays.stream(array)
        Arrays.stream(array).forEach(s -> System.out.println(s));

        /**
         * arrayList convert to array
         */
        Object[] obj = arrayList1.toArray();
        for(Object item : obj){
            System.out.println("arrayList1.toArray, for each:"+ item);

        }
        //线程安全的 ArrayList
        CopyOnWriteArrayList<City> copyOnWriteArrayList = new CopyOnWriteArrayList<>();

    }
}
