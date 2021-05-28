package com.nong.atomic;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @ClassName: AtomicIntegerTest
 * @Description: 原子操作类Integer
 * @author NongZhenQin
 * @date 2018-06-30 17:07:45
 */
public class AtomicIntegerTest {

    public static final AtomicInteger atomicInteger = new AtomicInteger(0);


    public static void main(String[] args) throws InterruptedException {
        atomicIntegerTest();

//        Thread.sleep(3000);
        System.out.println("最终结果是" + atomicInteger.get());
    }

    private  static void atomicIntegerTest() {
        ExecutorService executorService = Executors.newFixedThreadPool(1000);
        long start = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            executorService.execute(() -> {
                for (int j = 0; j < 4; j++) {
                    atomicInteger.getAndIncrement();
//                    System.out.println(atomicInteger.getAndIncrement());
                }
            });
        }
        long end = System.currentTimeMillis();
        executorService.shutdown();
        System.out.println("耗时："+(end - start) + "ms");
    }
}
