package com.nong.designmode.decorator;

/**
 * @ClassName: FouthGradeSchoolReport
 * @Description: 被装饰类：被装饰主要是为了扩展其方法
 * @author NongZhenQin
 * @date 2018-06-27 21:01:48
 */
public class FouthGradeSchoolReport extends SchoolReport {
    /**
     * @ClassName: SchoolReport
     * @Description: 打印成绩单，我想装饰报告方法，先告诉班级最高分情况
     * @author NongZhenQin
     * @date 2018-06-27 20:54:50
     */
    @Override
    public void report() {
        System.out.println("尊敬的XXX家长：");
        System.out.println("语文：85 数学：90");
        System.out.println("家长签字：XXX");
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
        System.out.println("家长签字为：" + name);
    }
}
