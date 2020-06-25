package com.atguigu.exer3;

public class InterfaceTest {
    public static void main(String[] args) {
        System.out.println(Flyable.MAX_SPEED);
        System.out.println(Flyable.MIN_SPEED);
    }
}

interface Flyable {
    //全局常量
    public static final int MAX_SPEED = 9000;
    int MIN_SPEED = 7000;

    public abstract void fly();

    void stop();
}

interface Attackable{
    void attack();
}

class Plane implements Flyable {

    @Override
    public void fly() {
        System.out.println("飞机起飞");
    }

    @Override
    public void stop() {
        System.out.println("飞机停止");
    }
}

abstract class Kite implements Flyable{
    @Override
    public void fly() {
        System.out.println("风筝起飞");
    }
}

class Bullet extends Object implements Flyable,Attackable,CC{
    @Override
    public void fly() {

    }

    @Override
    public void stop() {

    }

    @Override
    public void attack() {

    }

    @Override
    public void method1() {

    }

    @Override
    public void method2() {

    }
}

interface AA{
    void method1();
}

interface BB {
    void method2();

}

interface CC extends AA,BB{

}