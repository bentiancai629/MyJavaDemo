package com.atguigu.java;

/**
 * @author Eric Ni
 * @create 2020-05-31 17:57
 *
 * 使用继承thread类实现
 * 因为单继承 class不能继承别的类
 * 不容易公用对象 不能共享数据
 */
public class WindowTest  {
    public static void main(String[] args) {
        Window t1 = new Window("窗口1：");
        Window t2 = new Window("窗口2：");
        Window t3 = new Window("窗口3：");

        t1.start();
        t2.start();
        t3.start();
    }
}

class Window extends Thread {
    private static int ticket = 100;

    @Override
    public void run(){
        while (true){
            if (ticket >0){
                System.out.println(getName() + ": 卖票，票号："+ticket);
                ticket --;
            }else {
                break;
            }
        }
    }

    public Window(String name) {
        super(name);
        this.ticket = ticket;
    }
}
