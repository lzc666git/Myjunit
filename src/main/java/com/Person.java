package com;

/**
 * @program: maven_1
 * @description:
 * @author: 刘志成
 * @create: 2021-03-29 19:14
 */
public class Person implements Showable {
    private String name;
    private int age;
    public Person(){
        System.out.println("构造方法");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public  void show(){
        System.out.println("展示");
    }
}
