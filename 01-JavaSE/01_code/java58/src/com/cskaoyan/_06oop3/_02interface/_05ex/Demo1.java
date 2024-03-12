package com.cskaoyan._06oop3._02interface._05ex;

/**
 * <pre>
 *
 * 1. 教练（Coach）和运动员（Sportsman）案例
 * 小试牛刀请用所学知识分析：这个案例中有哪些抽象类，哪些接口，哪些具体类。
 * 现在有乒乓球运动员和足球运动员，乒乓球教练和足球教练。
 * 为了能够出国交流，跟乒乓球相关的人员都需要学习英语。
 * 乒乓球运动员
 *      训练： 打乒乓球
 *      打比赛
 * 足球运动员
 *      训练
 *      打比赛
 *
 * 乒乓球教练
 *      指导训练
 * 足球教练
 *      指导训练
 *
 * </pre>
 * <p>
 * <p>
 * 能力：  学英语。
 * 接口： 方法。
 * <p>
 * 类、对象、抽象类、接口： 先大致有一个印象。等到写项目，这玩意用多了之后，就会理解这些东西的真正作用。
 * 先把语法搞懂。
 *
 * @author Common-zhou
 * @since 2024-03-12 14:40
 */
public class Demo1 {

}


abstract class Sportsman {
    String name;
    int age;

    // 训练： 打乒乓球
    // 打比赛
    public abstract void training();

    public abstract void competition();


}

class PingpangSportsman extends Sportsman implements LearnEnglish {

    @Override
    public void training() {
        System.out.println("乒乓球运动员，努力训练打乒乓");
    }

    @Override
    public void competition() {
        System.out.println("乒乓球运动员，打比赛");
    }

    @Override
    public void learn() {
        System.out.println("乒乓球运动员，学习英语");
    }
}

class FootballSportsman extends Sportsman {

    @Override
    public void training() {
        System.out.println("足球运动员，不知道在干啥");

    }

    @Override
    public void competition() {
        System.out.println("足球运动员，打比赛");

    }
}


abstract class Coach {
    String name;
    int age;

    public abstract void guidanceTraining();
}

class PingpangCoach extends Coach implements LearnEnglish {

    @Override
    public void guidanceTraining() {
        System.out.println("乒乓球教练，指导打乒乓");
    }

    @Override
    public void learn() {
        System.out.println("学习英语");
    }
}

class FootballCoach extends Coach {

    @Override
    public void guidanceTraining() {
        System.out.println("足球教练，指导踢足球");
    }
}


interface LearnEnglish {
    void learn();
}
