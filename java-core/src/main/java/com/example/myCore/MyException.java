package com.example.myCore;

/**
 *  1. Exception
 *
 * 异常的父类 Throwable class
 * The Throwable class is the superclass of all errors and exceptions in the Java language.
 * 异常是程序编译或运行的过程中可能出现的错误。
 * 作用：处理代码问题，防止程序终止，提高健壮性和安全性。
 * 分为两类：
 *  编译时异常 compile-time ，继承了Exception ：IOException, ClassNotFoundException，NoSuchMethodException
 *  运行时异常：继承了RuntimeException
 *  throws ：用在方法上
 *  throw：出现异常的地方，从此处抛出
 *
 *  默认异常机制：一旦出现异常，JAVA会 自动创建异常对象，并抛给JVM，终止程序。
 *  编译异常的处理方式 1 ：
 *  抛出异常，throws Exception{}, 最终还是抛给JVM，导致程序终止。
 *  编译异常的处理方式 2 ：
 *  try {} catch (Exception e){ e.printStackTrace() },
 *      程序会捕获、打印异常信息，并继续执行后续代码,上层调用者不清楚异常情况。
 *  编译异常的处理方式 3：
 *  在出现异常的地方把异常抛出去，交给调用者处理，最外层调用者集中捕获异常！（规范做法）
 *
 *  运行时异常处理规范： 直接在最外层捕获处理即可，底层会自动抛出运行时异常！！！
 *
 *  2. finally
 *  用在捕获处理的异常格式中，放在最后面。
 *  作用： 可以在代码执行完毕后进行资源的释放操作。
 *  try{
 *  }catch(Exception e){
 *      e.printStackTrace();
 *  }finally {无论是否出现异常，都会执行} 比如IO 流的关闭
 *  finally 中可继续进行try catch
 *
 *  3. 自定义异常
 *  继承 Exception，重写构造器
 *
 */
public class MyException extends Exception{
    public static void main(String[] args) throws Exception{ //throws 用在方法上

        /**
         * 1. 数组越界异常： ArrayIndexOutOfBoundsException
         */
        int[] array = {1,2,3,4,5};
       // System.out.println(array[5]);
        /**
         * 2.空指针异常：NullPointerException
         */
        String name = null;
        //System.out.println(name.length());
        /**
         * 3. 类型转换异常：ClassCastException
         */
        Object obj = "David";
       // Integer integer = (Integer) obj;
        /**
         * 4. 迭代器遍历没有此元素：NoSuchElementException
         */

        /**
         * 5. 数学操作异常： ArithmeticException
         */
       // int i = 10 / 0;

        /**
         * 6.数字转换异常：NumberFormatException
         */
        String str = "DavidZhu";
//        Integer integer = Integer.valueOf(str);
//        System.out.println(integer);
        /**
         * 其他异常：
         * ClassNotFoundException, IllegalArgumentException，NoSuchFieldException,
         * NoSuchMethodException,FileNotFoundException
         */

        /**
         * try catch 捕获异常
         */
        try {
            String str1 = "DavidZhu";
            Integer integer1 = Integer.valueOf(str);
        }catch (Exception e){
            e.printStackTrace(); //打印异常印象

    }
        /**
         *  finally
         */
        try{
            int[] array1 = {1,2,3,4,5};
            System.out.println(array1[5]);
        }catch (Exception e){
            e.printStackTrace();
        }finally { //无论是否出现异常，都会执行
            System.out.println("==== Finally 执行 ====");
        }


        System.out.println("出现异常后继续执行了代码.....");

}
}
