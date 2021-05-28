package com.nong.designmode.decorator.correct;

import com.nong.designmode.decorator.SchoolReport;

/**
 * @ClassName: HeightScoreDecorator
 * @Description: 高分装饰类
 * @author NongZhenQin
 * @date 2018-06-27 21:46:15
 */
public class HeightScoreDecorator extends Decorator {

    public HeightScoreDecorator(SchoolReport report) {
        super(report);
    }

    private void heightScoreReport(){
        System.out.println("语文最高90分，数学最高95分");
    }

    /**
     * @ClassName: SchoolReport
     * @Description: 打印成绩单
     * @author NongZhenQin
     * @date 2018-06-27 20:54:50
     */
    @Override
    public void report() {
        this.heightScoreReport();
        super.report();
    }
}
