package com.nong.designmode.singleton;

/**
 * @ClassName: Singleton
 * @Description: 单例模式
 * @author NongZhenQin
 * @date 2018-07-03 23:09:38
 */
public class Singleton {
    /**
     * 这里使用static，会在类加载时被初始化
     */
    private static Singleton ourInstance = new Singleton();

    public static Singleton getInstance() {
        return ourInstance;
    }

    private Singleton() {
    }
}
