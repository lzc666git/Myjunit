package com.yc.junit;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * @program: maven_1
 * @description:
 * @author: 刘志成
 * @create: 2021-03-31 19:57
 */
public class MyJunitRunner {
    public static void main(String[] args) throws ClassNotFoundException, InvocationTargetException, IllegalAccessException, InstantiationException {
        Class cls=Class.forName("com.yc.MyCalculatorTest");

        //1.获取这个类的所有方法
        Method []ms=cls.getDeclaredMethods();
        List<Method> testMethods=new ArrayList<Method>();
        Method beforeMethod=null;
        Method afterMethod=null;
        Method beforeClassMethod=null;
        Method afterClassMethod=null;
        //2.循环这些方法，判断上面加了哪些注解
        for(Method m:ms){
            //3.将这些方法分别存好 @Test对应的方法有多个，存到一个集合中，其他注解对应的方法只有一个，直接存
            if(m.isAnnotationPresent(MyTest.class)){
                testMethods.add(m);
            }
            if(m.isAnnotationPresent(MyBefore.class)){
                beforeMethod=m;
            }
            if(m.isAnnotationPresent(MyAfter.class)){
                afterMethod=m;
            }
            if(m.isAnnotationPresent(MyBeforeClass.class)){
                beforeClassMethod=m;
            }

            if(m.isAnnotationPresent(MyAfterClass.class)){
                afterClassMethod=m;
            }
        }
        //4.按junit的运行的生命周期来调用

        if(testMethods==null||testMethods.size()<=0){
            throw  new RuntimeException("没有要测试的方法");
        }
        Object o=cls.newInstance();
        beforeClassMethod.invoke(o,null);
        for(Method m:testMethods){
            if(beforeMethod!=null){
                beforeMethod.invoke(o,null);
            }
            if(afterMethod!=null){
                afterMethod.invoke(o,null);
            }
        }
        afterClassMethod.invoke(o,null);
    }
}
