package com.nong.designmode.decorator.wrong;

import com.nong.designmode.decorator.FouthGradeSchoolReport;

/**
 * @ClassName: SugarFouthGradeSchoolReport
 * @Description: 错误的示范：如果用继承的方式扩展report的能力，当有其他扩展条件或因子时，将导致子类增多（爆炸），不利于维护管理
 * @author NongZhenQin
 * @date 2018-06-27 21:29:29
 */
public class SugarFouthGradeSchoolReport extends FouthGradeSchoolReport {

    private void heightScoreReport(){
        System.out.println("语文最高90分，数学最高95分");
    }

    private void sortReport(){
        System.out.println("我是排名30名");
    }

    /**
     * @ClassName: SchoolReport
     * @Description: 打印成绩单，我想装饰报告方法，先告诉班级最高分情况
     * @author NongZhenQin
     * @date 2018-06-27 20:54:50
     */
    @Override
    public void report() {
        this.heightScoreReport();
        super.report();
        this.sortReport();
    }
}
