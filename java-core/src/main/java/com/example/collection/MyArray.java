package com.example.collection;


import com.example.myCore.City;

import java.util.Arrays;

/**
 * 1. Array
 *
 *  Array 不是关键字，使用： 数组类型[] 数组名，保存基本类型 或者 对象。
 *  an array is a collection of similar type of elements which has contiguous memory location.
 *  目的：存放一组数据，基本数据类象或对象类型
 *  it can be primitive data types like int, char, double, byte, etc. or Java objects
 *  An array is a collection of similar types of data. Arrays are used to store multiple values
 *  in a single variable.
 *  In Java, array is an object of a dynamically generated class.
 *  Java array inherits the Object class, and implements the Serializable as well as Cloneable interfaces.
 *
 *  初始化后，长度不可改变
 *  Once the size of an array is declared, it's hard to change it. To handle this issue,
 *  we can use the ArrayList class. It allows us to create resizable arrays.
 *
 *  数组类型[] 数组名
 *  int[] array;
 *  int[] array = new int[5];
 *  int[] array = {1,2,3};
 *  Note that we have not provided the size of the array. In this case, the Java compiler automatically
 *  specifies the size by counting the number of elements in the array. i.e  3
 *  array[0],array[1],
 *
 * 多维数组：
 * A multidimensional array is an array of arrays.
 * Multidimensional arrays are useful when you want to store data as a tabular form,
 * like a table with rows and columns.
 * int[][] myNumbers = { {1, 2, 3, 4}, {5, 6, 7} };
 *
 *  Clone() 方法：
 *  Creates and returns a copy of this object
 * You created TWO Objects with TWO references,
 * where the second object is a copy of the first object.
 *
 *   Arrays类
 *   java.util.Arrays 此类包含用来操作数组的各种方法，比如排序和搜索等。其所有方法均为静态方法，调用起来非常简单。
 *
 */
public class MyArray {

    int[] array; // 声明数组 ，declares an array of integers
    /**
     * 静态初始化 Initialize Arrays：已明确要操作的具体数据
     * Note that we have not provided the size of the array. In this case, the Java compiler automatically
     *  specifies the size by counting the number of elements in the array. i.e  3
     */

    int[] array1 = new int[]{1,2,3,4};
    int[] array2 = {100,200,300};
    // 可保存 Object类型
    Integer integer = new Integer(10);

    City city1 = new City();
    City city2 = new City();
    City[] cities = {city1,city2};
    //数据保存对象
    City[] cities1 = new City[]{city1,city2};


    String[] arrayStr1 = new String[]{"David","David1"};
    String[] arrayStr2 = {"David1","David2"};

    /**
     * 动态初始化 Initialize Arrays：只明确元素个数，不确定具体值
     * @param args
     */

    int[] array3 = new int[100]; // 存100 个int 类型的值

    public static void main(String[] args){

        /**
         * array 初始化以后才有长度属性
         * 使用前需要初始化，一旦初始化长度即固定。
         */
        int[] array;
       // System.out.println("array. lengh = "+ array.length); 初始化后才可以使用 array.length
        /**
         * 实例变量，需要new后才能使用
         */
        String[] str0 = new String[100]; //只能初始化固定长度的数组

        String[] arrayStr3 = {"Nina","David","David2","David3"};
        System.out.println("arrayStr3.length = " + arrayStr3.length);

        String[] arrayStr4 = arrayStr3.clone();
        System.out.println("arrayStr3 == arrayStr4 ");
        System.out.println(arrayStr3==arrayStr4); // You created TWO Objects with TWO references

        System.out.println(arrayStr3); //对象
       // 通过索引取数组的值
        System.out.println(arrayStr3[0]);
        /**
         * for loop
         */
        for(int i = 0; i< arrayStr3.length; i++){
            System.out.print(arrayStr3[i]);
        }

        /**
         *  "for-each" loop
         *  for (type variable : arrayname)
         */

        for(String str : arrayStr3 ){
            System.out.println(str);
        }

        /**
         * specify two indexes: one for the array, and one for the element inside that array.
         */

        int[][] myNumbers = { {1, 2, 3, 4}, {5, 6, 7} };
        System.out.println(myNumbers[1][0]); //5

        /**
         * Arrays类
         * java.util.Arrays 此类包含用来操作数组的各种方法，比如排序和搜索等。其所有方法均为静态方
         * 法，调用起来非常简单。
         */
        Arrays.stream(arrayStr3);
        Arrays.sort(arrayStr3); //升序
        System.out.println("arrayStr3: " + arrayStr3[0]);


    }


}
