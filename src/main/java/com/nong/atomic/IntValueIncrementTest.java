package com.nong.atomic;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @ClassName: IntValueIncrementTest
 * @Description: 多线程自增++操作，与AtomicIntegerTest对比
 * @author NongZhenQin
 * @date 2018-06-30 17:14:14
 */
public class IntValueIncrementTest {
    public static int value = 0;

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(1000);
        long start = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            executorService.execute(() -> {
                for (int j = 0; j < 4; j++) {
//                    System.out.println(value++);
                    value++;
                }
            });
        }
        long end = System.currentTimeMillis();
        executorService.shutdown();
//        Thread.sleep(3000);
        System.out.println("最终结果是" + value);
        System.out.println("耗时："+(end - start) + "ms");
    }
}
