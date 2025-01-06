package com.example.demo.dto;


public class SingletonStudent {

    // 私有静态变量，用于持有单例的唯一实例
    private static volatile SingletonStudent instance;

    // 私有构造函数，防止外部通过new关键字创建实例
    // 可以在这里初始化单例的状态
    private SingletonStudent() {
        // 初始化代码，比如设置一些默认值或进行资源初始化
        System.out.println("Singleton instance is being initialized.");
    }

    // 公共静态方法，提供全局访问点来获取单例的唯一实例
    // 使用双重检查锁定来确保线程安全
    public static SingletonStudent getInstance() {
        if (instance == null) {
            synchronized (SingletonStudent.class) {
                if (instance == null) {
                    instance = new SingletonStudent();
                }
            }
        }
        return instance;
    }

    // 单例类可以包含其他方法，供外部使用
    public void doSomething() {
        System.out.println("Doing something with the Student instance.");
    }
}

