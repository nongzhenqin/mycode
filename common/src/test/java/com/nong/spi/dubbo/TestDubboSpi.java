package com.nong.spi.dubbo;

import com.alibaba.dubbo.common.extension.ExtensionLoader;

/**
 * @author nongzhenqin
 * @version 1.0
 * @ClassName TestDubboSpi
 * @description TODO
 * @date 2021/5/29 19:14
 */
public class TestDubboSpi {
    public static void main(String[] args) {
        ExtensionLoader<DubboSpiTest> extensionLoader = ExtensionLoader.getExtensionLoader(DubboSpiTest.class);
        DubboSpiTest dubboSpiTestImpl = extensionLoader.getExtension("DubboSpiTestImpl");
        dubboSpiTestImpl.doSomething();
    }
}
