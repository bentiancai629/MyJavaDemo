package com.atguigu.exer3;

public class Ball implements Rollable {
    private String name;

    public String getName() {
        return name;
    }

    public Ball(String name) {
        this.name = name;
    }


    @Override
    public void play() {
        System.out.println("踢球");
    }
}

interface Playable {
    void play();
}

interface Bounceable {
    void play();
}

interface Rollable extends Playable, Bounceable {
    public static final Ball ball = new Ball("pingpang"); // 接口里都是常量

}
