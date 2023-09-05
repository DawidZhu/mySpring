package com.example.stream;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 *  Stream
 *
 *  Java 8 API添加了一个新的抽象称为流Stream，可以让你以一种声明的方式处理数据。
 *  Stream（流）是一个来自数据源的元素队列并支持聚合操作
 *  核心： 先得到集合或者数组的Stream流（就是一根传送带）
 *       然后用这个Stream流操作集合或者数组的元素
 *       然后用Stream流简化替代集合操作的API
 *  Stream流 目的：用来简化集合类库或数组API的弊端。
 *
 * Stream流常用API：
 *  1. forEach ：逐一处理（遍历） Stream 提供了新的方法 'forEach' 来迭代流中的每个数据
 *   接收的是一个 Consumer（Java 8 新增的一个函数式接口，接受一个输入参数并且无返回的操作）类型的参数
 *  2. count：统计个数
 *  3. filter()： 过滤元素
 *   接收的是一个 Predicate（接受一个输入参数返回一个布尔值结果）类型的参数
 *  4. limit：取前几个元素,limit 方法用于获取指定数量的流
 *  5. Skip： 跳过前几个
 *  6. map：加工方法, 把原来的元素加工以后，重新放上去
 *   接收的是一个 Function（接受一个输入参数 T，返回一个结果 R）类型的参数
 *   如果想通过某种操作把一个流中的元素转化成新的流中的元素，可以使用 map() 方法。
 *  7. concat：合并流
 *  8. Sorted() 排序
 *  9. anyMatch(), allMatch() :Stream 类提供了三个方法可供进行元素匹配
 *
 * 数据源 流的来源。 可以是集合，Map，数组，I/O channel， 产生器generator 等。
 * 聚合操作 类似SQL语句一样的操作， 比如filter, map, reduce, find, match, sorted等。
 * 这种风格将要处理的元素集合看作一种流， 流在管道中传输， 并且可以在管道的节点上进行处理， 比如筛选， 排序，聚合等。
 *  +--------------------+       +------+   +------+   +---+   +-------+
 * | stream of elements +-----> |filter+-> |sorted+-> |map+-> |collect|
 * +--------------------+       +------+   +------+   +---+   +-------+
 * 解决已有集合类库或者数组API的弊端。
 *
 * 在 Java 8 中, 集合接口有两个方法来生成流：
 * stream() − 为集合创建串行流。
 * parallelStream() − 为集合创建并行流。
 *
 *  终结方法：一旦strean调用了终结方法，流的操作就全部终结了，不能继续使用。如：foreach，count
 *  非终结方法： 每次调用完成后返回一个新的流对象，可以继续使用。
 *
 *   收集Stream 流 collect ：就是把Stream流的数据转回到集合中
 *   Stream 流是手段，集合才是目的
 *
 *   Stream不是集合元素，也不保存数据，它更像是一个高级的Iterator，如同水流一样，单向，不可重复。
 *   对于一个流来说，我们的操作一般分为两种类型：
 *   Intermediate(中间)：一个流可以进行零次/多次的Intermediate操作，每次Intermediate操作返回一个新的流，
 *   交给下一个操作使用。这类操作是lazy的，也就是说没有Terminal操作不会被执行。
 *   Terminal(终止)：一个流只能有一次Terminal操作，所以Terminal操作必定是一个流的最后一个操作。
 *
 *   除了这一类操作，还有一类Short-circuiting操作。主要指：
 *   对于一个 intermediate 操作，如果它接受的是一个无限大（infinite/unbounded）的 Stream，
 *   但返回一个有限的新 Stream。(e.g.:limit)
 *   对于一个 terminal 操作，如果它接受的是一个无限大的 Stream，但能在有限的时间计算出结果。(e.g.:findAny、findFirst)
 *
 *   对于这三种操作类型的分类：
 *   Intermediate：
 *    map (mapToInt, flatMap 等)、 filter、 distinct、 sorted、 peek、 limit、 skip、
 *    parallel、 sequential、 unordered
 *   Terminal：
 *    forEach、 forEachOrdered、 toArray、 reduce、 collect、 min、 max、 count、 anyMatch、
 *    allMatch、 noneMatch、 findFirst、 findAny、 iterator
 *   Short-circuiting：
 *    anyMatch、 allMatch、 noneMatch、 findFirst、 findAny、 limit
 *
 *    flatMap：
 *    flat 是平铺的意思，flatMap 即对流中每个元素进行平铺后，形成多个流合在一起
 *    map 适用于对每个元素进行简单的转换，flatMap 适用于对数组流进行平铺后合并，两个方法的应用场景不一样。
 *    Stream.flatMap, as it can be guessed by its name, is the combination of a map and a flat operation.
 *    That means that you first apply a function to your elements, and then flatten it.
 *    Stream.map only applies a function to the stream without flattening the stream.
 *    To understand what flattening a stream consists in, consider a structure like
 *    [ [1,2,3],[4,5,6],[7,8,9] ] which has "two levels".
 *    Flattening this means transforming it in a "one level" structure : [ 1,2,3,4,5,6,7,8,9 ].
 *
 *    有二箱鸡蛋，每箱5个，现在要把鸡蛋加工成煎蛋，然后分给学生。
 *    map做的事情：把二箱鸡蛋分别加工成煎蛋，还是放成原来的两箱，分给2组学生；
 *    flatMap做的事情：把二箱鸡蛋分别加工成煎蛋，然后放到一起【10个煎蛋】，分给10个学生；
 */
public class MyStream {
    public static void main(String[] args){

        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("David");
        arrayList.add("Nina");
        arrayList.add("Daniel");

        HashMap<String, Integer> hashMap = new HashMap<>();
        hashMap.put("Iphone", 100);
        hashMap.put("IMac", 50);
        hashMap.put("IPad", 10);

        /**
         * 定义并赋值 数组
         */
        String[] arrayString = new String[]{"Java","Maven","Java EE","SpringBoot"};

        /**
         * ForEach()
         * //匿名内部类写法,
         * Stream 提供了新的方法 'forEach' 来迭代流中的每个数据
         */
        System.out.println("ForEach 匿名内部类写法:>>>>>>>>");
        arrayList.forEach(new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        });
        /**
         * ForEach()
         * Lambda 写法,Stream 提供了新的方法 'forEach' 来迭代流中的每个数据
         * 省去 接口名称Consumer，接口中的方法名称accept(),这些JAVA会自己推导
         */
        System.out.println("ForEach Lambda写法 :>>>>>>>>");
        arrayList.forEach(s -> System.out.println(s));
        /**
         * Stream
         * 先获取集合类的 stream流 ：collection.stream()
         * 带参数的Lambda 表达式
         * (n) -> (n%2)==0
         * 需求：获取以D开头，长度等于5的字符串
         */
        System.out.println("Stream。获取以D开头，长度等于5的字符串 :>>>>>>>>");

        arrayList.stream()
                // Stream<T> filter(Predicate<? super T> var1);
                .filter(s -> s.startsWith("D"))
                .filter(s  -> s.length() == 5)
                // forEach(Consumer<? super T> var1);
                .forEach(s -> System.out.println(s));
        //  Predicate functional interface
        Predicate<String> predicate =s -> s.length() == 5;
        Boolean b = arrayList.stream().allMatch(predicate);
        System.out.println(" predicate length == 5: " + b);

        /**
         *  创建 parallelStream 并行流
         */

        Stream<String> parallelStream = Stream.of(arrayString).parallel();
        /**
         * 获取数组的Stream 流： arrayStream =  Arrays.stream(arrayString)
         * 或者 Stream.of();
         */
        System.out.println("获取数组的Stream 流,并filter :>>>>>>>>");
        Stream<String> arrayStream =  Arrays.stream(arrayString);
        Stream<String> stream = Stream.of(arrayString);

        arrayStream.filter(s -> s.startsWith("Java")).forEach(s -> System.out.println(s));
        /**
         * stream().count() 获取元素的个数
         */
        long l =  arrayList.stream().count();
        System.out.println("arrayList.stream().count(): >>>>>>>>" + l);

        long l1 = arrayList.stream().filter(s -> s.length() == 5).filter(s -> s.matches("d")).count();
        /**
         *  limit(): 取前几个
         *  取长度为5，的前2个，并打印
         */
        System.out.println("limit(2): >>>>>>>>");
        arrayList.stream().filter(s -> s.length() == 5).limit(2).forEach(s -> System.out.println(s));
        /**
         * map 方法
         * 用于映射每个元素到对应的结果
         * map() :加工方法，把原来的元素加工以后，重新放上去
         */
        arrayList.stream().map(name -> "hello: >>>>>>>>" + name).forEach(name -> System.out.println(name));
        /**
         * flatMap()
         * flatMap(Function<? super T, ? extends Stream<? extends R>> var1);
         */
        System.out.println("flatMap >>>>>>");
        arrayList.stream().flatMap( s -> Stream.of(s) ).forEach(s -> System.out.println(s));
        /**
         * concat(a,b) 合并流
         * Array 和 List 两个Stream 流合并
         */
        System.out.println("concat 合并流: >>>>>>>>");
        Stream<String> s1 = Stream.of(arrayString);
        Stream<String> allStream = Stream.concat(s1,arrayList.stream());
        allStream.forEach(System.out::println);

        /**
         * sorted() 排序
         */
        System.out.println("sorted() 排序: >>>>>>>>");
        arrayList.stream().sorted().forEach(s -> System.out.println(s));


        /**
         * Collectors
         * Collectors 类实现了很多归约操作，例如将流转换成集合和聚合元素。
         * 收集Stream 流：就是把Stream流的数据转回到集合中
         * Stream 流是手段，集合才是目的
         * 流取过后会变空，需要重新拿流
         */
        Set<String> sets =  arrayList.stream().collect(Collectors.toSet());
        System.out.println("sets: >>>>>>>>"+sets);
        /**
         * collect()
         * Stream 转成List
         */
        List<String> lists = arrayList.stream().collect(Collectors.toList());

        /**
         * Map 集合的Stream 流
         * 先获取 key 的stream流
         * 再获取 value 的stream流
         */
        System.out.println("Map 集合的Stream 流: >>>>>>>>");
        Stream<String> stream1 = hashMap.keySet().stream();
        stream1.forEach(s -> System.out.println(s));
        Stream<Integer> stream2 = hashMap.values().stream();
        stream2.forEach(s -> System.out.println(s));
        /**
         * Map 集合的Stream 流
         * 直接获取key value的流,Map.Entry<String, Integer>
         *     key+value作为set集合的一个元素
         */
        System.out.println("Map 集合,直接获取key value的流 : >>>>>>>>");
        hashMap.entrySet().stream().forEach(new Consumer<Map.Entry<String, Integer>>() {
            @Override
            public void accept(Map.Entry<String, Integer> stringIntegerEntry) {
                System.out.println(stringIntegerEntry);
            }
        });
        /**
         * Stream 转回set,List集合, 使用collect
         * 处理完逻辑后，通常需要转回集合进行返回数据
         */
        System.out.println("Stream 转回set,List集合: >>>>>>>>");
        Stream stream3 = arrayList.stream().filter(s -> s.length() == 4);
        //Set<String> set = (Set<String>) stream3.collect(Collectors.toSet());
        ArrayList<String> arrayList1 = (ArrayList<String>) stream3.collect(Collectors.toList());
        arrayList1.forEach(s -> System.out.println(s));
        /**
         * Stream 转回 数组
         */
        Stream stream4 = arrayList.stream().filter(s -> s.length() == 5);
        Object[] arrays = (Object[]) stream4.toArray();

        /**
         * Supplier<T>: 供给型接口
         * 抽象方法：T get()，无参数，有返回值。
         */
        Supplier<String> supplier = () -> "这样写可以吗";
        System.out.println(supplier.get());

    }


}
