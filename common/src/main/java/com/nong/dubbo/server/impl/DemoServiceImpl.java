package com.nong.dubbo.server.impl;

import com.nong.dubbo.server.facade.DemoService;

/**
 * @ClassName: DemoServiceImpl
 * @Description: dubbo示例
 * @author NongZhenQin
 * @date 2018-08-03 21:54:32
 */
public class DemoServiceImpl implements DemoService {
    /**
     * hello()
     *
     * @return java.lang.String
     * @Title: hello
     * @Description: 示例
     * @author NongZhenQin
     */
    @Override
    public String hello() {
        return "你好啊！";
    }
}
