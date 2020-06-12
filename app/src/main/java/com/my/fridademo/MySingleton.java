package com.my.fridademo;

public class MySingleton {
    private static MySingleton INSTANCE = new MySingleton();

    private MySingleton() {
    }

    public static MySingleton getInstance() {
        return INSTANCE;
    }

    public String post(String p1) {
        String result = p1 + " go post";
        return result;
    }
}
