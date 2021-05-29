package com.nong.spi;

public class SpiInterfaceImpl implements TestJavaSpiInterface{
    @Override
    public void hi() {
        System.out.println("I am Java SPI-1");
    }
}
