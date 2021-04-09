package com.yc;

import com.yc.biz.Calculator;
import com.yc.junit.*;

/**
 * @program: maven_1
 * @description:
 * @author: 刘志成
 * @create: 2021-03-31 19:58
 */
public class MyCalculatorTest {
    private Calculator cal;//待测试的单元

    @MyBeforeClass
    public static void bc(){
        System.out.println("beforeclass");
    }

    @MyBefore
    public void setUp(){
        System.out.println("before");
        cal=new Calculator();
    }

    @MyAfter
    public void tearDown(){
        System.out.println("after");
    }
    @MyAfterClass
    public static void ac(){
        System.out.println("afterclass");
    }
    @MyTest
    public void add(){
        System.out.println("add");
    }
    @MyTest
    public void sub(){
        System.out.println("sub");
    }
}
