package com.nong.spi.dubbo;

/**
 * @author nongzhenqin
 * @version 1.0
 * @ClassName DubboSpiTestImpl
 * @description TODO
 * @date 2021/5/29 19:11
 */
public class DubboSpiTestImpl implements DubboSpiTest{
    @Override
    public void doSomething() {
        System.out.println("I am dubbo spi");
    }
}
