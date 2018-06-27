package com.nong.designmode.decorator.correct;

import com.nong.designmode.decorator.SchoolReport;

/**
 * @ClassName: Decorator
 * @Description: 修饰的抽象类：装饰类把动作的执行委托给需要装饰的对象
 * @author NongZhenQin
 * @date 2018-06-27 21:41:09
 */
public abstract class Decorator extends SchoolReport {

    /**
     * 首先要知道是哪个成绩单
     */
    private SchoolReport report;

    public Decorator(SchoolReport report) {
        this.report = report;
    }

    /**
     * @ClassName: SchoolReport
     * @Description: 打印成绩单
     * @author NongZhenQin
     * @date 2018-06-27 20:54:50
     */
    @Override
    public void report() {
        report.report();
    }

    /**
     * @param name
     * @ClassName: SchoolReport
     * @Description: 家长签字
     * @author NongZhenQin
     * @date 2018-06-27 20:55:12
     */
    @Override
    public void sign(String name) {
        report.sign(name);
    }
}
