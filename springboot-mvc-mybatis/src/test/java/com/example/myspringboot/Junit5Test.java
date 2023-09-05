package com.example.myspringboot;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

/**
 *  1.JUnit 5 注解
 *
 *  单元测试框架 JUnit,可以快速测试代码的正确性。
 *  Disabled 表示测试类或测试方法不执行
 *  DisplayName 为测试类或测试方法设置展示名称
 *
 *  Springboot 2.4以后不能再使用junit 4
 *
 *  2.Assertions
 *
 *  用来对测试需要满足的条件进行验证。
 *  断言： 执行失败后，后面的代码不会再执行
 *      * assertEquals()：判断两个对象或两个原始类型是否相等，前面参数是期望的值，后面是真是的值
 *      * assertSame：判断两个对象引用是否指向同一个
 */

@DisplayName("For JUnit5 Test")
public class Junit5Test {

    /**
     * Disabled 表示测试类或测试方法不执行
     * DisplayName 为测试类或测试方法设置展示名称
     */
    @Disabled
    @DisplayName("test 1 方法")
    @Test
    public void test1(){
        System.out.println("JUnit5 test111111 ....");
    }

    /**
     * RepeatedTest：表示方法重复执行
     */

    @RepeatedTest(5)
    @DisplayName("test 2 方法")
    @Test
    public void test2(){
        System.out.println("JUnit5 test2222222 ....");
    }

    /**
     * BeforeEach：表示在每个测试方法之前执行
     */
    @BeforeEach
    void testBeforeEach(){
        System.out.println("Begining....");
    }

    /**
     * AfterEach：表示在每个测试方法之后执行
     */
    @AfterEach
    void testAfterEach(){
        System.out.println("ending....");
    }

    /**
     * BeforeAll：表示在所有单元测试之前执行
     */
    @BeforeAll
    static void testBeforeAll(){
        System.out.println("BeforeAll Begining....");
    }
    /**
     * AfterAll：表示在所有单元测试之后执行
     */
    @AfterAll
    static void testAfterAll(){
        System.out.println("AfterAll ending....");
    }

    /**
     * Timeout 表示测试方法如果超过了指定的时间将会返回错误
     * @throws InterruptedException
     */
    @Disabled
    @Timeout(value = 100,unit = TimeUnit.MILLISECONDS)
    @Test
    public void testTimeout() throws InterruptedException {
        Thread.sleep(1000);
    }

    /**
     * 断言： 执行失败后，后面的代码不会再执行
     * assertEquals()：判断两个对象或两个原始类型是否相等，前面参数是期望的值，后面是真是的值
     * assertSame：判断两个对象引用是否指向同一个
     */
    @Test
    @DisplayName("Test Assertion...")
    void  testSimpleAssertion(){
        int cal = cal(2,3);
        Assertions.assertEquals(5,cal,"业务逻辑失败");

        Object obj1 = new Object();
        Object obj2 = new Object();

        Assertions.assertSame(obj1,obj2,"两个对象不一样");

    }

    int cal(int i, int j){
        return i+j;
    }

    /**
     * 组合断言，assertAll 所有断言需要都成功
     * assertAll：
     */
    @Test
    @DisplayName("Test AssertAll...")
    void testAssertAll(){
        Assertions.assertAll("test ALL ...",
                () -> assertTrue(1 > 0),
                () -> assertEquals(1,2));

    }

    @DisplayName("TEST Fail ...")
    @Test
    void testFail(){
        if(1 == 2){
            fail("test Fail !!!");
        }

    }

    @DisplayName("test Assumptions")
    @Test
    void testAssumptions(){

        Assumptions.assumeTrue(false, "结果不是 true！！！");
    }

    /**
     * 参数化测试：ParameterizedTest
     */
    @DisplayName("test ParameterizedTest")
    @ParameterizedTest
    @ValueSource(ints = {0,1,2,3})
    void testParameters(int i){
        System.out.println("ParameterizedTest: "+i);

    }


    static Stream<String> stringProvider(){
        return Stream.of("abc","ade","wer");
    }

    /**
     * 参数化测试： MethodSource 从方法中获取参数
     * @param str
     */
    @ParameterizedTest
    @MethodSource("stringProvider")
    void testMethodSource(String str){
        System.out.println("testMethodSource: "+ str);
    }

}
