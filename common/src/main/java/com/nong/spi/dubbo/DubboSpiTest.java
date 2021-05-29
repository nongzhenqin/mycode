package com.nong.spi.dubbo;

import com.alibaba.dubbo.common.extension.SPI;

/**
 * @author nongzhenqin
 * @version 1.0
 * @ClassName DubboSpiTest
 * @description TODO
 * @date 2021/5/29 19:10
 */
@SPI
public interface DubboSpiTest {

    void doSomething();
}
