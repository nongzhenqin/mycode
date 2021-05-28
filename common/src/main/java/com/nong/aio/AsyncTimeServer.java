package com.nong.aio;

/**
 * 异步IO测试：时间服务器服务端
 */
public class AsyncTimeServer {

    public static void main(String[] args){
        AsyncTimeServerHandler asyncTimeServerHandler = new AsyncTimeServerHandler(8080);
        new Thread(asyncTimeServerHandler, "AIO-AsyncTimeServerHandler-001").start();
    }
}
