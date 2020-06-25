package com.atguigu.exer3;

public class UsbTest {
    public static void main(String[] args) {
        Computer computer = new Computer();
        Flash flash = new Flash();
        computer.transferData(flash);

        USB phone = new USB() {

            @Override
            public void start() {
                System.out.println("mp3开始工作");
            }

            @Override
            public void stop() {
                System.out.println("mp3结束工作");
            }
        };

        computer.transferData(phone);

    }
}


class Computer {
    public void transferData(USB usb) {
        usb.start();
        System.out.println("具体传输数据");
        usb.stop();
    }

}

class Flash implements USB {


    @Override
    public void start() {
        System.out.println("内存开始工作");
    }

    @Override
    public void stop() {
        System.out.println("内存结束工作");
    }
}

class Phone implements USB {


    @Override
    public void start() {
        System.out.println("手机开始工作");
    }

    @Override
    public void stop() {
        System.out.println("手机结束工作");
    }
}

interface USB {
    void start();

    void stop();
}