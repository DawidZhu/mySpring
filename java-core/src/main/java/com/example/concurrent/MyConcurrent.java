package com.example.concurrent;

/**
 *  java.util.concurrent
 *  参考 My-order-service
 *  包提供的线程安全的并发集合可以大大简化多线程编程，多线程同时读写并发集合是安全的；
 *  尽量使用Java标准库提供的并发集合，避免自己编写同步代码。
 *
 *   interface	  non-thread-safe	      thread-safe
 *    List	        ArrayList	      CopyOnWriteArrayList
 *    Set	   HashSet / TreeSet	  CopyOnWriteArraySet
 *
 *    Map	        HashMap	         ConcurrentHashMap
 *   Queue	ArrayDeque / LinkedList	  ArrayBlockingQueue / LinkedBlockingQueue
 *
 *    线程安全： 多个线程同时操作，如对数据进行++操作， 可保证大量操作后的正确性。变量在线程内存和主内存的同步。
 *    Callable是类似于Runnable的接口，实现Callable接口的类和实现Runnable的类都是可被其他线程执行的任务。
 *
 */
public class MyConcurrent {
}
