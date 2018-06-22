package com.nong.designmode.factory;

/**
 * @ClassName: NvWa
 * @Description: 女娲：使用场景
 * @author NongZhenQin
 * @date 2018-06-21 14:22:29
 */
public class NvWa {
    public static void main(String[] args) {
        HumanFactory humanFactory = new HumanFactory();

        Human human = humanFactory.createHuman(WhiteHuman.class);
        human.getColor();
        human.talk();

        Human human1 = humanFactory.createHuman(YellowHuman.class);
        human1.getColor();
        human1.talk();

        Human human2 = humanFactory.createHuman(BlackHuman.class);
        human2.getColor();
        human2.talk();
    }
}
