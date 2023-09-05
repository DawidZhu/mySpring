package com.example.collection;

import com.example.myCore.City;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 25. HashSet
 *
 * HashSet 基于 HashMap 来实现的，是一个不允许有重复元素的集合。HashSet 是无序的，即不会记录插入的顺序。
 * 添加的元素是  无序的，不重复，无索引。不可进行排序， HashSet <String> hashset = new HashSet<>();
 * hashcode() x相当于对象的内存地址
 * HashSet is commonly used if we have to access elements randomly.
 * The hashcode of an element is a unique identity that helps to identify the element in a hash table.
 * HashSet allows null value.
 * HashSet不能保持其元素的顺序。因此，对HashSet进行排序是不可能的。
 * 然而，HashSet的元素可以通过转换为List或TreeSet来间接排序，但这将使元素保持在目标类型而不是HashSet类型。
 *
 *  TreeSet Vs. HashSet
 *
 *  TreeSet: 排序不重复集合, 放进去的元素默认会进行排序。
 * Both the TreeSet as well as the HashSet implements the Set interface.
 * Unlike HashSet, elements in TreeSet are stored in some order.
 * It is because TreeSet implements the SortedSet interface as well.
 * HashSet is faster than the TreeSet for basic operations like add, remove, contains and size.
 *
 * TreeSet provides some methods for easy navigation. For example, first(), last(), headSet(), tailSet(), etc.
 * It is because TreeSet also implements the NavigableSet interface.
 *
 */
public class MyHashSet {

    public static void main(String[] args ){
        /**
         * HashSet: 无序，不重复，无索引
         */
        HashSet<String> hashSets = new HashSet<>();
        hashSets.add("Java 1");
        hashSets.add("Java 1");
        hashSets.add("Spring boot 2");
        hashSets.add("Maven 3");
        hashSets.add("Git 4");
        //集合重写了toString()方法
        System.out.println("HashSet ： " + hashSets);

        /**
         * 保存 对象类型
         */
        HashSet<City> cities = new HashSet<>();
        City city1 = new City(100,"GC","Ashmore","4214");
        City city2 = new City(201,"Brz","Gole","4200");
        City city3 = new City(150,"Sunshine","Benowa","4100");;
        cities.add(city1);
        cities.add(city2);
        cities.add(city3);

    /**
     *   HashSet 进行排序
     *   HashSet不能保持其元素的顺序。因此，对HashSet进行排序是不可能的。
         然而，HashSet的元素可以通过转换为List或TreeSet来间接排序，但这将使元素保持在目标类型而不是HashSet类型。
     */

        /**
         * forEach方法
         */
        hashSets.forEach(s -> System.out.println(s));
        /**
         * for-each 循环
         */
        System.out.println("for-each 循环:");
        for(String str : hashSets){
            System.out.println(str);
        }
        /**
         * removeIf()
         * contains()
         * size()
         * stream()
         * toArray()
         */
        System.out.println("removeIf():");
        hashSets.removeIf(s -> s.length()>5);
        hashSets.forEach(s -> System.out.println(s));
        /**
         * stream()
         */
        System.out.println("stream(): ");
        hashSets.stream().filter(s -> s.startsWith("J")).forEach(s -> System.out.println(s));

        /**
         * 清空集合的元素 clear()
         */
        //hashSets.clear();

        /**
         * 判断是否为空 isEmpty()
         */
        System.out.println(hashSets.isEmpty());
        /**
         * 判断是否包含某个元素 contains(obj)
         */
        System.out.println(" contains Git 4 :" + hashSets.contains("Git 4"));
        /**
         * 删除某一个元素 remove(obj)
         */
        hashSets.remove("Maven 3");

        /**
         * hashSets to array
         * 集合转成数组 Arrays.toString(arrs)
         */
        Object[] arrs = hashSets.toArray();
        System.out.println("Arrays : " + arrs.toString());
        System.out.println("Arrays : " + Arrays.toString(arrs));


    }
}
