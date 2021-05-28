package com.nong.designmode.decorator;

import com.nong.designmode.decorator.correct.HeightScoreDecorator;
import com.nong.designmode.decorator.correct.SortDecorator;

/**
 * @ClassName: Father
 * @Description: 家长：装饰器调用者
 * @author NongZhenQin
 * @date 2018-06-27 21:00:07
 */
public class Father {
    public static void main(String[] args) {
        // 1、
//        SchoolReport report = new FouthGradeSchoolReport();
//        report.report();
//        report.sign("张三");

        // 2、
//        SchoolReport report = new SugarFouthGradeSchoolReport();
//        report.report();
//        report.sign("张三");

        // 3、
        // 原装成绩单
        SchoolReport report = new FouthGradeSchoolReport();
        // 高分装饰类
        report = new HeightScoreDecorator(report);
        // 排名装饰类
        report = new SortDecorator(report);

        // 这里为什么会执行到HeightScoreDecorator的report方法：
        // 因为SortDecorator的超类持有的是HeightScoreDecorator对象，
        // 调用SortDecorator的report方法时，会调用super.report，则会先调用到HeightScoreDecorator类的report方法
        // 而HeightScoreDecorator对象持有的是FouthGradeSchoolReport对象，
        // 所以调用super.report时又调用了FouthGradeSchoolReport对象的report方法
        // 达到装饰FouthGradeSchoolReport的目的
        report.report();
        report.sign("李四");
    }
}
