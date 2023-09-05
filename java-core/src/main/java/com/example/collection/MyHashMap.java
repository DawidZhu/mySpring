package com.example.collection;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.BiConsumer;

/**
 * 26.Map
 *
 *  Map 集合是一种双列集合，每个元素包含两个值。元素格式：key=value(键值对)
 *  ConcurrentHashMap: 不止线程安全，性能较高，目前使用最广 ！
 *  Map集合存储的信息更加具体丰富。 ConcurrentMap<K, V> extends Map<K, V>  线程安全的
 *  集合和范型都只支持引用数据类型，集合完全可以称为对象容器，存储的都是对象。
 *
 *       {  TreeMap<K,V>
 *  Map
 *      {   HaspMap<K,V> (实现类，经典的，用的最多) --> LinkedHaspMap<K,V> (实现类)
 * 特点：
 *   Map 集合的特点都是由Kay决定的。
 *   Map集合的键是无序，不重复，无索引。后面重复的键对应的元素会覆盖前面的整个元素。
 *   Map集合的值无要求。
 *   Map集合的键值都可以为null.
 *   HaspMap: 元素按照键是 无序，不重复，无索引，值不做要求。
 *   LinkedHaspMap： 元素按照键是 有序，不重复，无索引，值不做要求。
 *
 *  HashMap
 *  HashMap 是一个散列表，它存储的内容是键值对(key-value)映射。 线程不安全的
 *  ConcurrentMap<K, V> extends Map<K, V>  线程安全的
 *   public Set<Map.Entry<K, V>> entrySet()：获取key+value的set集合
 *  HashMap 实现了 Map 接口，根据键的 HashCode 值存储数据，具有很快的访问速度，最多允许一条记录的键为 null，不支持线程同步。
 *  HashMap 是无序的，即不会记录插入的顺序。不可进行排序
 *  It stores elements in key/value pairs. Here, keys are unique identifiers used to
 *  associate each value on a map.
 *  Java HashMap contains values based on the key.
 *  Java HashMap contains only unique keys.
 *  Java HashMap maintains no order.
 *
 *   并发包：Concurrency Package
 *   ConcurrentMap<K, V> extends Map<K, V>
 *   JAVA 为很多业务场景提供了性能优异，线程安全的并发包。
 *   MAP中的经典集合，HaspMap 是线程不安全的，性能很好。
 *   HashTable 是性能安全的，但是性能较差。
 *
 *   java.util.Collections工具类还提供了一个旧的线程安全集合转换器，可以这么用：
 *  Map unsafeMap = new HashMap();
 *  Map threadSafeMap = Collections.synchronizedMap(unsafeMap);
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
 *   推荐 ConcurrentHashMap: 不止线程安全，性能较高，目前使用最广 ！
 *   ConcurrentHashMap is introduced as an alternative to the HashMap.
 *   The ConcurrentHashMap is a synchronized collection class.
 *      线程安全： 多个线程同时操作，如对数据进行++操作， 可保证大量操作后的正确性。变量在线程内存和主内存的同步。
 *
 *   27. Map.Entry
 *
 *   entrySet()方法：描述在一个Map中的一个元素（键/值对）。是一个 Map 的内部接口。
 *   获取到Map集合中所有的键值对对象的集合(Set集合)。
 *   就是返回一个集合,集合里存放的是对象,创建对象的类有两个属性,分别是 键和值 也即键值对。
 *   stores both the key and value together in one class, we get them both in a single operation.
 *   entrySet() Return Value: returns a set view of all the entries of a hashmap.
 *   key+value, 作为Set的一个元素
 *   entry :[Imac=1, Iphone=3, Ipad=10]
 *   The set view means all entries of the hashmap are viewed as a set.
 *
 */
public class MyHashMap {

    public static void main(String[] args){
        //  经典代码
        HashMap<String, Integer> maps = new HashMap<>();
        maps.put("Iphone",3);
        maps.put("Imac",1);
        maps.put("Ipad",1);
        maps.put("Ipad",10);

        System.out.println(maps);
        /**
         * Concurrency HashMap
         * 线程安全的 HashMap
         */
        ConcurrentHashMap<String, Integer> concurrentHashMap = new ConcurrentHashMap<>();
        /**
         * forEach() 方法
         * forEach() 方法与 for-each 循环不同
         * 注意： 参数是两个
         * 用于对 HashMap 中的每个映射执行指定的操作。
         * hashmap.forEach(BiConsumer<K, V> action)
         * 接受两个参数
         */
        System.out.println("forEach() 方法:");
        maps.forEach(((s, integer) -> {
            s = "hello" + s ;
            integer = integer *10;
            System.out.println(s);
        }));

        /**
         * entrySet() 方法
         * 返回映射中包含的映射的 Set 视图。
         * 获取到Map集合中所有的键值对对象的集合(Set集合)。key+value, 作为Set的一个元素
         */
        Set<Map.Entry<String, Integer>> entry =  maps.entrySet();
        System.out.println("entrySet() :" + entry);
        System.out.println("entry.forEach :" );
        entry.forEach(stringIntegerEntry -> System.out.println(stringIntegerEntry));
        /**
         * isEmpty()
         *判断集合是否为空
         */
        System.out.println(maps.isEmpty());
        /**
         * 根据键获取对应的值
         */
        Integer value = maps.get("Imac");
        System.out.println(value);

        /**
         * remove()
         * 根据键删除整个元素
         */
        maps.remove("Ipad");
        System.out.println(maps);

        /**
         * containsKey()
         * 判断是否包含某个键，某个值
         */
        maps.containsKey("Iphone");
        maps.containsValue("1");
        /**
         * keySet() 方法
         * 返回映射中所有 key 组成的 Set 视图。
         * values()
         * 返回映射中所有 value 组成的 Set 视图。
         * 分开获取Map中的key 和 value
         */
        Set<String> sets = maps.keySet();
        sets.stream(); // sets的stream流
        System.out.println("keySet: " + sets);

        Collection<Integer> collection = maps.values();
        System.out.println("values,Stream filter: " );
        collection.stream().filter(integer -> integer > 100).forEach(integer -> System.out.println(integer)); // collection 的stream流
        System.out.println("values: " + collection);

        /**
         * putAll()
         *  合并其他Map集合
         */
        java.util.Map<String, Integer> maps2 = new HashMap<>();
        maps2.put("Iphone",300);
        maps2.put("Iwatch",100);

        maps.putAll(maps2);

        System.out.println(maps);

        /**
         * Iterate maps
         * iterate through keys only
         */
        System.out.println("遍历hashMap的 key：");
        for(String str : maps.keySet()){
            System.out.println(str);
        }

        /**
         * Iterate maps
         * iterate through value only
         */
        System.out.println("遍历hashMap的 value：");
        for(Integer integer : maps.values()){
            System.out.println(integer);
        }
        /**
         * iterate through key/value entries
         * Entry : It is the nested class of the Map interface that returns a view (elements) of the map.
         */
        for(java.util.Map.Entry<String, Integer> entry1 : maps.entrySet()){
            System.out.println(entry1);

        }

    }

}
