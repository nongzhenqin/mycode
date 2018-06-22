package com.nong.designmode.factory;

/**
 * @ClassName: YellowHuman
 * @Description: 黄种人
 * @author NongZhenQin
 * @date 2018-06-21 14:12:16
 */
public class YellowHuman implements Human {
    /**
     * getColor()
     *
     * @return void
     * @Title: getColor
     * @Description: 肤色
     * @author NongZhenQin
     */
    @Override
    public void getColor() {
        System.out.println("黄色皮肤");
    }

    /**
     * talk()
     *
     * @return void
     * @Title: talk
     * @Description: 说话语言
     * @author NongZhenQin
     */
    @Override
    public void talk() {
        System.out.println("中文等语言");
    }
}
