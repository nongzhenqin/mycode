package com.nong.designmode.factory;

/**
 * @ClassName: HumanFactory
 * @Description: 人类生产工厂类
 * @author NongZhenQin
 * @date 2018-06-21 14:19:59
 */
public class HumanFactory extends AbstractHumanFactory {
    /**
     * createHuman()
     *
     * @param clazz
     * @return T
     * @Title: createHuman
     * @Description: 生产方法
     * @author NongZhenQin
     */
    @Override
    public <T extends Human> Human createHuman(Class<T> clazz) {
        T t = null;
        try {
            t = clazz.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
            System.out.println("生产错误");
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            System.out.println("生产错误");
        }
        return t;
    }
}
