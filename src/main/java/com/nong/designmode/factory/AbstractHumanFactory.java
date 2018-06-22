package com.nong.designmode.factory;

/**
 * @ClassName: AbstractHumanFactory
 * @Description: 生产人类的抽象工厂类
 * @author NongZhenQin
 * @date 2018-06-21 14:16:19
 */
public abstract class AbstractHumanFactory {

    /**
     * createHuman()
     *
     * @Title: createHuman
     * @Description: 生产方法
     * @param clazz
     * @return T
     * @author NongZhenQin
     */
    public abstract <T extends Human> Human createHuman(Class<T> clazz);
}
