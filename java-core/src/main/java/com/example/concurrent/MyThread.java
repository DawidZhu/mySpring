package com.example.concurrent;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 *  Process & Thread
 *  A process is an instance of a program that is being executed.
 *  Each process contains its own memory space and does not share it with the other processes.
 *  Each process is independent and treated as an isolated process by the OS.
 *  A proper synchronization between processes is not required. In contrast,
 *  threads need to be synchronized in order to avoid unexpected scenarios.
 * 进程： 程序是静止的，运行中的程序就是进程。
 * 进程的三个特征： 动态性，独立性，并发性。
 *
 * A thread is the subset of a process and is also known as the lightweight process.
 * A process can have more than one thread, and these threads are managed independently by the scheduler.
 * If a single thread executes in a process, it is known as a single-threaded
 * And if multiple threads execute simultaneously, then it is known as multithreading.
 * 线程：线程是属于进程的，一个进程可包含多个线程，这就是多线程。
 * 线程是进程中的独立执行单元，创建开销比较小，支持并发。
 * 作用：
 *      提高效率，多线程可解决很多业务模型，高并发的核心技术。
 *  实现多线程：extends Thread / implements Runnable()
 *      1，定义一个类继承Thread，重写run()方法，方法中是需要多线程的业务，创建线程对象并调用start()启动线程；
 *          优点：编码简单；缺点：继承Thread后无法继承其他类
 *      2，定义一个线程任务类实现Runnable()接口，重写run()方法，方法中是需要多线程的业务，创建线程任务对象（不是线程对象），
 *          把线程任务对象包装成线程对象，调用start()方法。
 *          Thread thread = new Thread(runnable);
 *          优点：同一个线程任务对象可以被包装成多个线程对象，适合多个线程取共享同一个资源；实现解耦。
 *
 *  Thread API
 *  setName(); getName(); currentThread(); sleep(long time);
 *
 *  线程安全问题：多个线程操作同一个共享资源的时候可能会出现线程安全的问题。
 *  线程同步：让多个线程实现先后依次访问共享资源，解决线程安全问题。
 *  线程同步的做法：
 *      1。同步代码块；synchronized(锁对象this){}
 *      2。同步方法； 方法上加 public synchronized void
 *      3。lock显示锁。
 *
 *     synchronized是Java中的关键字，是一种同步锁。它修饰的对象有以下几种：
 * 1. 修饰一个代码块，被修饰的代码块称为同步语句块，其作用的范围是大括号{}括起来的代码，作用的对象是调用这个代码块的对象；
 * 2. 修饰一个方法，被修饰的方法称为同步方法，其作用的范围是整个方法，作用的对象是调用这个方法的对象；
 * 3. 修改一个静态的方法，其作用的范围是整个静态方法，作用的对象是这个类的所有对象；
 * 4. 修改一个类，其作用的范围是synchronized后面括号括起来的部分，作用主的对象是这个类的所有对象。
 *
 *  Life Cycle Of Thread
 *  New:新创建状态，当new一个Thread对象，但未调用start方法后就处于该状态
 *  Runnable:可运行状态，可运行状态实际上分为两种状态一种时Running(正在运行)，另 一种是Ready（已准备）,
 *  这两种状态统称为可运行状态，当线程的start方法被调用后 就会处于reedy状态，此时线程会等待分配CPU时间片，当获取到时间片之后就处于 running状态
 *  Waiting:等待，处于该状态时线程不会被分配CPU执行时间,要等待被显示的唤醒，否则 会无限期的等待。
 *  Blocked:被阻塞，等待获取锁对象进入synchronized代码块或方法
 *  Terminated:已终止状态，线程正常运行完成或抛出异常后会到达已终止状态
 *
 *  1.New State: in this state, code has not yet been run and the execution process is not yet initiated.
 *  2.Runnable State: The Thread is ready to run at any given time and it’s the job of the Thread Scheduler to provide the thread time for the runnable state preserved threads.
 *  3.Running State: When The Thread Receives CPU allocated by Thread Scheduler, it transfers from the “Runnable” state to the “Running” state.
 *  4.Waiting/Blocked State :If a Thread is inactive but on a temporary time
 *  5.Timed Waiting State: sleep(time)
 *  6.Terminated State:a Thread when it finishes its task Normally, or means it is dead and no longer available.
 *
 *  Thread Pool  线程池
 *  Java Thread pool represents a group of worker threads that are waiting for the job and reused many times.
 *  1。降低资源消耗，减少创建和销毁线程的次数。
 *  2。提高响应速度，直接取线程池的线程。
 *  3。提高线程的可管理性，设置最大线程数。
 *  线程池的核心思想：线程复用，同一个线程被多次重复使用，来处理多个任务。
 *  创建线程池：
 *   ExecutorService pools = Executors.newFixedThreadPool(5);
 *   pools.submit(runnable);
 *
 *   Deadlock 死锁
 *   两个或两个以上的线程持有不同系统资源的锁，线程彼此都等待获取对方的锁来完成自己的任务，但是没有让出自己持有的锁，线程就会无休止等待下去
 *  synchronized keyword is used to make the class or method thread-safe which means only one thread
 *  can have lock of synchronized method and use it, other threads have to wait till the lock releases and anyone of them acquire that lock.
 *
 *  Volatile
 *
 *  问题：多个线程访问共享变量，会出现一个线程修改变量的值后，其他线程看不到变量最新值的情况。
 *  Volatile keyword is used to modify the value of a variable by different threads.
 *  It is also used to make classes thread safe.
 *  变量不可见的内存语意：
 *  JMM：Java Memory Model, java 内存模型，是java虚拟机规范中所定义的一种内存模型。
 *  描述了JAVA程序中各种变量的访问规则，以及在JVM中将变量存储到内存和从内存中读取变量这样的底层细节。
 *  所有的共享变量存在主内存。
 *  每个线程有自己的工作内存，读写发生在工作内存，不能直接读写主内存。
 *  线程间变量的值传递需要通过主内存中转来完成。
 *  解决方案：
 *      1，加锁；synchronized, 执行加锁代码块前后都会与主内存交换变量数据
 *      2，对共享的变量进行volatile 关键字修饰。
 *
 *   volatile & synchronized
 *   volatile：只能修饰实例变量和类变量，只保证变量可见性，不保证原子性 atomic，不保证线程安全
 *   synchronized：不可修饰变量，用来修饰方法，代码块，是一种排他互斥的机制，可实现线程安全
 *   Atomic 原子性  concurrency 并发性
 *
 *   java.util.concurrent.atomic package
 *   这个包的原子操作类提供了一种用法简单，性能高效，线程安全地更新一个变量的方式。
 *
 *   atomic variables and operations used in concurrency 并发性.
 *   The multi-threading environment leads to a problem when concurrency is unified.
 *   java provides a java.util.concurrent.atomic package in which atomic classes are defined.
 *   The atomic classes provide a lock-free and thread-safe environment or programming on a single variable.
 *   All the atomic classes have the get() and set() methods that work on the volatile variable.
 *  Class ：AtomicBoolean，AtomicInteger... 原子型的boolean 、Integer
 *
 *  多线程是程序设计的逻辑层概念，它是进程中并发运行的一段代码，可以实现线程间的切换执行。
 *  异步和同步是相对的，异步就是彼此独立，在等待某事件的过程中继续做自己的事，不需要等待这一事件完成后再工作。
 *  多线程就是实现异步的一个方式。异步是让调用方法的主线程不需要同步等待另一线程的完成，从而可以让主线程干其它的事情。
 *  所以本质上，异步和多线程并不是一个同等关系，异步是最终目的，多线程只是实现异步的一种手段。
 *
 */
public class MyThread {
    /**
     * 对共享的变量进行volatile 关键字修饰。
     * 解决多个线程间变量可见性问题
     */
    private volatile boolean flag = false;

    /**
     * ConcurrentHashMap : 解决HashMap的线程安全问题
     */
    public static Map<String,String> maps = new ConcurrentHashMap<>();

    /**
     * 启动后的MyThread 当成一个进程
     * main方法是由主线程执行的，理解成main方法就是一个主线程
     * @param args
     */
    public static void main(String[] args){

        /**
         * AtomicInteger 原子性的int 类型
         * 默认加了 volatile
         */
        AtomicInteger atomicInteger = new AtomicInteger(); //默认为0
        atomicInteger.get();
        atomicInteger.incrementAndGet();

        // 1. 创建一个线程对象，new NewThread
        Thread thread = new NewThread();
        //调用start()方法启动线程，最终还是运行run()
        thread.start();// 启动了子线程

        System.out.println(thread.getName());
        /**
         * 如果调用run()，会当成普通类处理
         */
        // thread.run();
        /**
         * 2. 通过Runnable接口创建 线程，new RunnableThread
         */
        Runnable runnable = new RunnableThread();
        //把线程任务对象包装成线程对象
        Thread t = new Thread(runnable);
        t.start();

        // 创建一个线程对象
        Thread thread1 = new NewThread("线程2 "); //通过构造方法初始化
        thread1.start();
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        /**
         * 获取当前线程的名称
         */
        String name = Thread.currentThread().getName();
        System.out.println(name);

        for(int i=0;i<10;i++){
            System.out.println(name + " 主线程的打印：" +i);
        }
        /**
         * 创建线程池
         */
        ExecutorService pools = Executors.newFixedThreadPool(5);
        pools.submit(runnable);
    }
}

/**
 * 定义一个线程类，继承Thread
 * public class Thread implements Runnable
 */
class NewThread extends Thread{

    /**
     * 通过构造器初始化名字
     * @param name
     */
    public NewThread(String name) {
        super(name);
    }

    public NewThread() {
    }

    //volatile：只能修饰实例变量和类变量，只保证变量可见性，不保证原子性 atomic，不保证线程安全
    volatile int count = 0;
    /**
     * 重写run()方法
     */
    @Override
    public void run() {
        super.run();
        //线程的执行方法

        for(int i=0;i<10;i++){
            System.out.println(Thread.currentThread().getName() + " 方法内线程的打印：" +i);
        }
        //synchronized 代码块，同时只能有一个线程使用
        synchronized(this){
            for(int i=0;i<10;i++){
                System.out.println(Thread.currentThread().getName() + " synchronized代码块， 方法内线程的打印：" +i);
            }
        }
        //synchronized 方法，同时只能有一个线程使用
//        public synchronized void test123(){
//            for(int i=0;i<10;i++){
//                System.out.println(Thread.currentThread().getName() + " synchronized 方法内线程的打印：" +i);
//            }
//        }
    }
}

/**
 * 定义一个线程任务类，实现Runnable()接口
 * @ FunctionalInterface
 * public interface Runnable {
 *      public abstract void run();
 * }
 */
 class RunnableThread implements Runnable{

    @Override
    public void run() {
        //线程的执行方法
        for(int i=0;i<10;i++){
            System.out.println(Thread.currentThread().getName() + " RunnableThread 方法内线程的打印：" +i);
        }

    }
}
