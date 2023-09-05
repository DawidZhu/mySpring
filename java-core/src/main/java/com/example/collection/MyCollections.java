package com.example.collection;

import java.util.*;
import java.util.function.Consumer;

/**
 * 22. Collection
 *
 *
 *  Collection 集合是JAVA中集合list,set的祖宗类。 Sort(), forEach(),removeIf(),stream()
 *  集合和范型Generics都只支持引用数据类型，集合完全可以称为对象容器，存储的都是对象。
 *  public interface Collection<E> extends Iterable<E>
 *  一个 Collection 代表一组 Object，即 Collection 的元素
 *
 *  集合是一个大小可变的容器，容器中的每个数据（只能是对象）成为一个元素。 数组可以是基本数据类型。
 *  任何对象加入集合类后，自动转变为Object类型，所以在取出的时候，需要进行强制类型转换。
 *  特点：类型可以不确定，大小不固定。集合有很多种，不同的集合特点和使用场景不同。
 *  数组：类型和长度一旦定义出来就固定了。
 *  集合的用处：元素的个数不确定，并且经常进行元素的增、删、改、查操作。
 *  Collections 不属于集合，是操作集合的工具类。 API都是static，直接class. 使用。
 *
 *  23.Collections
 *
 *  Collections 并不属于集合，是用来操作集合的工具类。
 *  Collections 有几个常用的API：
 *  public static <T> boolean addAll() :给集合对象批量添加元素；
 *   public static <T> void sort(List<T> list) :
 *   将集合元素按照默认顺序排序；对于自定义的数据类型，直接报错，需要提供比较规则Comparable 或重写 Comparator
 *   public static <T> void sort(List<T> list, Comparator<? super T> c) :
 *   将集合元素按照指定顺序排序,自带比较器
 *   如果比较规则comparable和比较器comparator 同时存在，优先使用比较器
 *
 *   以上都是对List 集合排序，List底层是基于数组的。
 *   Set集合底层是根据hashCode来计算的位置，排序后又恢复类hashcode，无法排序。
 *
 *                                     { HashSet<E> (实现类)  --> LinkedHashSet<> (实现类)
 *                     {  Set<E> (接口)
 *                                     { TreeSet<E> (实现类)
 * Collection<E>(接口)
 *                                     { ArrayList<E> (实现类)
 *                    {  List<E> (接口)
 *                                    { LinkedList<E> (实现类)
 *
 * Set 系列集合：
 *         添加的元素是无序的，不重复，无索引。
 *            HashSet：添加的元素是  无序的，不重复，无索引。 Set <String> set = new HashSet<>();
 *            LinkedHashSet ：添加的元素是  有序的，不重复，无索引。
 *            TreeSet ：不重复，无索引，按照大小默认升序排序！所以放进去的元素必须是可排序的。
 *                      对象要实现comparable接口(可排序集合)
 * List 系列集合：
 *       添加的元素是有序的，可重复，有索引。
 *             ArrayList：有序的，可重复，有索引。底层基于数组存储数据，查询快，增删慢！ArrayList 功能几乎与List一致。
 *                      List<String> arrayList = new ArrayList<>();
 *             LinkedList：有序的，可重复，有索引。底层是基于链表的， 查询慢，增删快！LinkedList 多了很多基于链表的功能。
 *
 *  24.  traverse  遍历
 *
 *  Collection 集合的遍历方式是全部集合都可以使用的。集合的遍历有3种：
 *  1，迭代器。 Iterator
 *    public Iterator iterator(): 获取集合对应的迭代器，用来遍历集合中的元素。
 *    1.获取当前集合的迭代器，iterator = lists.iterator()。
 *    2.定义一个while()循环，通过 iterator.hasNext(), 用 iterator.next()取出。
 *  2，foreach (增强for循环)
 *     foreach 遍历是迭代器遍历的简化写法。
 *     for(被遍历集合或数组中元素的类型 变量名称 ： 被遍历集合或数组){ } //变量名称可随便写
 *
 *  3，JDK1.8以后的新技术。forEach()方法 Lambda 表达式
 *
 *
 *   接口名	        Java8新加入的方法
 * Collection   	removeIf() spliterator() stream() parallelStream() forEach()
 * List	          replaceAll() sort()
 * Map	       getOrDefault() forEach() replaceAll() putIfAbsent() remove() replace() computeIfAbsent() computeIfPresent() compute() merge()
 *
 * forEach():
 * 该方法的签名为void forEach(Consumer<? super E> action)，作用是对容器中的每个元素执行action指定的动作，
 * 其中Consumer是个函数接口，里面只有一个待实现方法void accept(T t).
 * Consumer 是接口名称， accept 是方法名称，用Lambda表达式这两个都不需要写
 *
 * 堆(heap):先进先出,栈(stack)先进后出
 *
 *  使用java.util.concurrent 包提供的线程安全的并发集合可以大大简化多线程编程：
 *  多线程同时读写并发集合是安全的；
 *  尽量使用Java标准库提供的并发集合，避免自己编写同步代码。
 *
 *   interface	  non-thread-safe	      thread-safe
 *    List	        ArrayList	      CopyOnWriteArrayList
 *     Map	         HashMap	      ConcurrentHashMap
 *    Set	   HashSet / TreeSet	  CopyOnWriteArraySet
 *   Queue	ArrayDeque / LinkedList	  ArrayBlockingQueue / LinkedBlockingQueue
 *
 */
public class MyCollections {

    public static void main(String[] args){
        /**
         * LinkedList
         */
        LinkedList<Integer> linkedList1 = new LinkedList();
        linkedList1.add(100);
        linkedList1.add(200);
        linkedList1.add(0,10000);


        /**
         * LinkedList, 入：addLast(), 出：removeFirst()
         */
        LinkedList linkedList = new LinkedList();
        //入队
        linkedList.addLast("1 号");
        linkedList.addLast("2 号");
        linkedList.addLast("3 号");
        linkedList.addLast("4 号");
        System.out.println(linkedList);
        //出队
        System.out.println(linkedList.removeFirst());
        System.out.println(linkedList.removeFirst());
        /**
         *  public E getFirst()	返回第一个元素。
         * public E getLast()	返回最后一个元素。
         * public int indexOf(Object o)	查找指定元素从前往后第一次出现的索引。
         */
        linkedList.getFirst();
        linkedList.getLast();
        int i = linkedList.indexOf("4 号");
        System.out.println("linkedList.indexOf: "+ i);
        /**
         * For-each 循环
         */
        System.out.println("For-each 循环:");
        linkedList.forEach(new Consumer() {
            @Override
            public void accept(Object o) {
                System.out.println(o);
            }
        });
        linkedList.forEach(o -> System.out.println(o));

        /**
         * Collections 集合工具类的使用
         *   public static <T> boolean addAll() :给集合对象批量添加元素
         *  *   public static <T> void sort(List<T> list) :将集合元素按照默认顺序排序
         *     public static <T> void sort(List<T> list, Comparator<? super T> c)
         */
       // Collections.addAll();
         // Collections.sort();



    }
}
