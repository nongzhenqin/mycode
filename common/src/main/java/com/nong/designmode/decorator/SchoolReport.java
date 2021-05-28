package com.nong.designmode.decorator;

/**
 * @ClassName: SchoolReport
 * @Description: 装饰器模式：成绩单
 * @author NongZhenQin
 * @date 2018-06-27 20:54:02
 */
public abstract class SchoolReport {

    /**
     * @ClassName: SchoolReport
     * @Description: 打印成绩单
     * @author NongZhenQin
     * @date 2018-06-27 20:54:50
     */
    public abstract void report();

    /**
     * @ClassName: SchoolReport
     * @Description: 家长签字
     * @param name
     * @author NongZhenQin
     * @date 2018-06-27 20:55:12
     */
    public abstract void sign(String name);
}
