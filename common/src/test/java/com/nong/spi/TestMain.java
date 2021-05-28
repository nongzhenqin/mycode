package com.nong.spi;

import java.util.Iterator;
import java.util.ServiceLoader;

public class TestMain {

    public static void main(String[] args) {
        ServiceLoader<TestJavaSpiInterface> serviceLoader = ServiceLoader.load(TestJavaSpiInterface.class);
        Iterator<TestJavaSpiInterface> iterator = serviceLoader.iterator();
        while (iterator.hasNext()){
            TestJavaSpiInterface next = iterator.next();
            next.hi();
        }
    }
}
