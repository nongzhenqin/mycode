package com.nong.designmode.factory;

/**
 * @ClassName: BlackHuman
 * @Description: 黑人
 * @author NongZhenQin
 * @date 2018-06-21 14:11:02
 */
public class BlackHuman implements Human {

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
        System.out.println("黑色皮肤");
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
        System.out.println("各种非洲语言");
    }
}
