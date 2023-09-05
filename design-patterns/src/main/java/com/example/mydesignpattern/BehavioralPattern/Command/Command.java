package com.example.mydesignpattern.BehavioralPattern.Command;
/**
 * Command
 *
 *  Command is a behavioral design pattern that turns a request into a stand-alone object
 *  that contains all information about the request. This transformation lets you pass requests as a method arguments,
 *  delay or queue a request’s execution, and support undoable operations.
 *  将一个请求封装成一个对象，从而让用户使用不同的请求把客户端参数化；对请求排队或记录日志，以及支持可撤销的操作。
 *
 * 命令模式的要点如下：
 * Command 接口非常简单，通常只有一个execute方法，如果要支持撤销操作的话，再加一个unexecute方法
 * 每个具体的命令类内部封装了实际执行命令的那个类（Recevier），或者那些类，以及执行需要的数据
 * 每个具体命令类只完成一个请求，有多少个请求就有多少个命令
 * Invoker类只认识接口Command，其他的都不认识
 * 客户端类负责生成命令，并通过Invoker组装执行。
 *
 * 命令接口，所有具体的命令都会实现此接口，Invoker只认识此接口
 * 其实现类包含了可以执行自己的对象（receiver），以及执行时候需要的数据
 */
public interface Command {
    void execute();
}
