package com.annotation;

import java.lang.annotation.*;

//要声明它的特征  Target 表示这个注解可以加到类的哪个地方
//              Retention：表示这个注解在什么时候还保留
//              Documented:表示在文档中是否保留
//              Inherited:子类是否可以继承注解
@Target(value={ElementType.TYPE,ElementType.FIELD})
@Retention(value=RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface MyHelloWorld {
}
