package com.example.demo.text;

public class ClassA {

    public static ClassA classA = new ClassA();


    static {
        System.out.println("ClassA 的静态代码块");
    }

    public ClassA() {
        System.out.println("ClassA的构造方法");
    }

    {

        System.out.println("ClassA的构造代码块");
    }


    public static void main(String[] args) {
        ClassA classA = new ClassA();
//        System.out.println(classA);

    }
}
