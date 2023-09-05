package com.example.mydesignpattern.BehavioralPattern.Iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Spliterator;
import java.util.function.Consumer;

/**
 * Iterator
 *
 * Iterator is a behavioral design pattern that lets you traverse elements of a collection
 * without exposing its underlying representation (list, stack, tree, etc.).
 *
 * An Iterable is a simple representation of a series of elements that can be iterated over.
 * It does not have any iteration state such as a "current element".
 * Instead, it has one method that produces an Iterator.
 *
 * An Iterator is the object with iteration state.
 * It lets you check if it has more elements using hasNext() and move to the next element (if any) using next().
 * Typically, an Iterable should be able to produce any number of valid Iterators
 *
 * 提供一种方法顺序访问一个容器对象中的各个元素，而又不需要暴露该对象的内部表示
 *  实现了Iterable 接口
 *
 *  你要使你的类可以迭代（支持foreach），就实现java.lang.Iterable接口。
 */
public class MyIterator implements Iterable<Student>{

    private final List<Student> studentList = new ArrayList<>();

    /**
     * 使用构造方法初始化对象
     */
    public MyIterator() {
        studentList.add( new Student("David", 20));
        studentList.add( new Student("Daniel", 10));
    }

    /**
     * 重写 iterator()，得到  Iterator
     * @return
     */
    @Override
    public Iterator<Student> iterator() {
        return new MyIter();
    }

    @Override
    public void forEach(Consumer<? super Student> action) {
        Iterable.super.forEach(action);
    }

    @Override
    public Spliterator<Student> spliterator() {
        return Iterable.super.spliterator();
    }

    /**
     * 内部类
     * implements Iterator
     */
    class MyIter implements Iterator<Student>{
    int index = 0;

        /**
         * 重写hasNext()
         */
        @Override
        public boolean hasNext() {
            if(index < studentList.size()){
                return true;
            }
            return false;
        }
        /**
         * 重写next()
         */
        @Override
        public Student next() {
            Student student = studentList.get(index);
            index ++;
            return student;
        }
    }

}
