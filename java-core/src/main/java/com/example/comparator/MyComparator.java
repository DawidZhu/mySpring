package com.example.comparator;


import com.example.myCore.City;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.TreeSet;

/**
 *  Comparator：
 *
 *  一个 Comparator 是一个比较函数，它为没有自然排序的对象集合提供排序。String可自然排序
 *  此类的实现者需要重写抽象方法 compare() 定义在 java.util.Comparator，它比较它的两个参数的顺序。
 *  @ FunctionalInterface
 * public interface Comparator<T> {}
 *
 * Comparable：对比 Comparator
 *  public interface Comparable<T>
 *      1.Comparable provides a single sorting sequence.n other words,
 *      we can sort the collection on the basis of a single element such as id, name, and price.
 *      2.Comparable affects the original class, i.e., the actual class is modified
 *      3.Comparable provides compareTo() method to sort elements.
 *      4.We can sort the list elements of Comparable type by Collections.sort(List) method
 *      5.Comparable is present in java.lang package.
 *
 * Collections:
 *  public static <T> void sort(List<T> list, Comparator<? super T> c) :
 *  将集合元素按照指定顺序排序,自带比较器
 *  如果比较规则comparable和比较器comparator 同时存在，优先使用比较器
 *
 *  引用数据类型的排序， 对象的排序两种方法：
 *  1，为对象实现比较器规则接口Comparable，重写比较方法
 *      public class City implements Comparable<City>
 *  2，直接为集合设置比较器Comparator对象，重写比较方法
 *
 *  TreeSet 集合对自定义引用数据类型排序，默认无法进行，可通过自定义比较器实现。
 *  HashSet 无法进行排序。
 *
 *  函数式接口(Functional Interface)就是一个有且仅有一个抽象方法，但是可以有多个非抽象方法的接口。
 * 函数式接口可以被隐式转换为 lambda 表达式。
 *
 */
public class MyComparator {

public static void main(String[] args){


    /**
     * 保存 对象类型
     * 并进行排序,对象实现比较器规则接口Comparable
     */
    TreeSet<City> cities = new TreeSet<>();
    City city1 = new City(100,"GC","Ashmore","4214");
    City city2 = new City(201,"Brz","Gole","4200");
    City city3 = new City(150,"Sunshine","Benowa","4100");

    // TreeSet 对放进来的元素默认升序排序
    cities.add(city1);
    cities.add(city2);
    cities.add(city3);
    System.out.println("TreeSet 可排序：");
    System.out.println(cities);

    /**
     * 为集合设置比较器 Comparator 对象
     */
    TreeSet<City> cityTreeSet1 = new TreeSet<>(new Comparator<City>() {
        @Override
        public int compare(City o1, City o2) {
            return o1.getId() - o2.getId();
        }
    });
    /**
     * 匿名内部类 Lambda 简化写法
     */
    TreeSet<City> cityTreeSet2 = new TreeSet<>((city, t1) -> city.getId() - t1.getId());

    /**
     * 为 存放City 对象的 ArrayList 创建 comparator
     * implements Comparable
     */
    ArrayList<City> arrayList1 = new ArrayList<>();
    arrayList1.add(city1);
    arrayList1.add(city2);
    arrayList1.add(city3);


    /**
     * Comparator 是个接口，抽象方法只有一个 compare()
     * 1. 可使用匿名类，返回的是new 对象
     * 2. 可简化成 Lambda 表达式
     * 3. 可继续简化成 方法引用
     *  函数式接口
     */
    //匿名内部类，重写方法， 参数类型省略
    Comparator<Integer> c1 = new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o1.compareTo(o2);
        }
    };

    /**
     * Lambda 表达式 写法
     */
    Comparator<Integer> c2 = ( o1,  o2) -> o1.compareTo(o2);

    /**
     * 方法引用
     * 类 :: 实例方法
     * Integer::compareTo;
     */
    Comparator<Integer> c3 = Integer::compareTo;

    System.out.println("C1 :" +c1.compare(1,2));
    System.out.println("C2 :" +c2.compare(1,2));
    System.out.println("C3 :" +c3.compare(1,2));
    // System.out :: println;


    /**
     * 使用Comparator， 按照City名字对 集合进行排序
     */
    Comparator<City> cityComparator = (city, t1) -> city.getName().compareTo(t1.getName());
    System.out.println("cities>>>>>>>>" + arrayList1);
   Collections.sort(arrayList1,cityComparator);
    System.out.println("cityComparator>>>>>>>>" + arrayList1);





}
}
