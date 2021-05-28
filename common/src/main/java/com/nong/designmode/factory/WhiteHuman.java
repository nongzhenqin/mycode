package com.nong.designmode.factory;

/**
 * @ClassName: WhiteHuman
 * @Description: 白人
 * @author NongZhenQin
 * @date 2018-06-21 14:13:31
 */
public class WhiteHuman implements Human {
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
        System.out.println("白色皮肤");
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
        System.out.println("英语等语言");
    }
}
