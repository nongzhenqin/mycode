package com.nong.designmode.decorator.correct;

import com.nong.designmode.decorator.SchoolReport;

/**
 * @ClassName: SortDecorator
 * @Description: 排名装饰类
 * @author NongZhenQin
 * @date 2018-06-27 21:50:30
 */
public class SortDecorator extends Decorator {
    public SortDecorator(SchoolReport report) {
        super(report);
    }

    private void sortReport(){
        System.out.println("我是排名30名");
    }

    /**
     * @ClassName: SchoolReport
     * @Description: 打印成绩单
     * @author NongZhenQin
     * @date 2018-06-27 20:54:50
     */
    @Override
    public void report() {
        super.report();
        this.sortReport();
    }
}
