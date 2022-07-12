package com.my.fridademo;

//静态内部类
public class StaticInnerClass {
    int num = 88;

    // 静态内部类和非静态内部类最大的区别是：非静态内部类编译后隐式保存着外部类的引用（就算外部类对象没用了也GC不掉）,但是静态内部类没有
    static class Inner {
        int num = 99;

        public Inner() {
            System.out.println("=== public Inner() ===");
        }

        public String func1(String param) {
            int num1 = new StaticInnerClass().num;
            return "StaticInnerClass_func1-> num = " + (num + num1) + "parma:" + param;
        }
    }

}
