package com.atguigu.java8;

public class InnerClassTest {
    public static void main(String[] args) {
        // DOG实例
        Person.Dog dog = new Person.Dog();
        dog.show();
        dog.name = "阿飞";

        //BIRD实例
        Person person = new Person();
        person.name = "jack";
        Person.Bird bird = person.new Bird();
        bird.sing();
        bird.display("不谷鸟");
    }

}

/**
 * 内部类的分类：成员内部类（静态、非静态） vs 局部内部类（方法内 代码块 构造器内）
 * 成员内部类：
 *      作为外部类成员
 *      调用外部类结构
 *      可以被static修饰
 *      可以被4个权限修饰
 *
 *      雷内可以定义属性 方法构造器
 *      可以被final修饰 表示此类不能被继承  不适用final就可以被继承
 *      可以被abstract修饰
 */


class Person {
    String name;
    int age;

    public void eat() {
        System.out.println("人吃饭");
    }

    // 静态内部类
    static class Dog {
        String name;

        public void show() {
            System.out.println("狗叫");
        }

    }

    //非静态内部类
     class Bird {
        String name ="杜鹃";

        public Bird() {
        }

        public void sing() {
            System.out.println("鸟飞");
            Person.this.eat(); // 可以调用外部类的方法
        }

        public void display(String name){
            System.out.println(name);
            System.out.println(this.name);
            System.out.println(Person.this.name);
        }

    }
}
