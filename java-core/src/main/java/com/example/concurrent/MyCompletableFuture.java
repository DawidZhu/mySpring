package com.example.concurrent;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.RunnableFuture;
import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;

/**
 *   java.util.concurrent.CompletableFuture
 *
 *  CompletableFuture用于异步编程asynchronous，异步编程是编写非阻塞的代码，运行的任务在一个单独的线程，
 *  与主线程隔离，并且会通知主线程它的进度，成功或者失败。
 *  在这种方式中，主线程不会被阻塞，不需要一直等到子线程完成。主线程可以并行的执行其他任务。
 *   我们大部分代码，都是同步调用的，所谓同步，是指调用方必须等到方法返回后才会进行下一步，
 *   而异步，是指调用方不必等到方法(用CompletableFuture)返回，只需要方法在完成任务后通知调用方即可。
 *   异步和多线程并不是一个等价的概念，Java中的异步是依靠多线程实现的。
 *
 *   runAsync() 新建线程并异步执行，无返回值
 *   supplyAsync() 新建线程并异步执行，有返回值
 *  在异步asynchronous模型中，允许同一时间发生（处理）多个事件。程序调用一个耗时较长的功能（方法）时(用CompletableFuture)，
 *  它并不会阻塞程序的执行流程，主程序会继续往下执行。当CompletableFuture功能执行完毕时，主程序能够获得执行完毕的消息或能够访问到执行的结果。
 *  加Async的是指CompletableFuture会把下边的代码看成两个独立的任务来执行，也就是会有两个子线程执行。
 *  从Java 8开始引入了CompletableFuture，它针对Future做了改进，可以传入回调对象，当异步任务完成或者发生异常时，自动调用回调对象的回调方法。
 *
 *  多线程是程序设计的逻辑层概念，它是进程中并发运行的一段代码，可以实现线程间的切换执行。
 *  异步和同步是相对的，异步就是彼此独立，在等待某事件的过程中继续做自己的事，不需要等待这一事件完成后再工作。
 *  多线程就是实现异步的一个方式。异步是让调用方法的主线程不需要同步等待另一线程(CompletableFuture)的完成，从而可以让主线程干其它的事情。
 *  所以本质上，异步和多线程并不是一个同等关系，异步是最终目的，多线程只是实现异步的一种手段。
 *
 *  CompletableFuture实现了Future接口，既可以完成Future所有能做的事。最关键是，它还实现了CompletionStage接口，
 *  该接口描述了一个异步计算的阶段。很多计算可以分成多个阶段或步骤，此时可以通过它将所有步骤组合起来，形成异步计算的流水线。
 *  supplyAsync主要用于需要返回计算结果的异步处理；runAsync主要用于不需要返回计算结果的异步处理
 *
 */
public class MyCompletableFuture {
    //Callable是类似于Runnable的接口，实现Callable接口的类和实现Runnable的类都是可被其他线程执行的任务。

    public static  void main(String[] args){

        CompletableFuture completableFuture = new CompletableFuture();
        /**
         *  CompletableFuture.runAsync()
         *  使用 runAsync() 运行异步计算
         * 如果你想异步的运行一个后台任务并且不想改任务返回任务东西，这时候可以使用 CompletableFuture.runAsync()方法，
         * 它持有一个Runnable 对象，并返回 CompletableFuture<Void>。
         *
         */
        CompletableFuture.runAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        /**
         * CompletableFuture.supplyAsync()
         * 它持有supplier<T> 并且返回CompletableFuture<T>，T 是通过调用 传入的supplier取得的值的类型。
         */
        CompletableFuture<String> future =  CompletableFuture.supplyAsync(()-> {
            try {
                TimeUnit.SECONDS.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return "Result of the asynchronous computation";
        });

    }
}
