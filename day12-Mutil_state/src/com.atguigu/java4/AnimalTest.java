package com.atguigu.java4;

public class AnimalTest {

    public static void main(String[] args) {
        Animal dog = new Dog();
        Animal cat = new Cat();

        AnimalTest animalTest = new AnimalTest();
        animalTest.func(dog);

        animalTest.func(cat);
    }


    public void func(Animal animal){
        animal.eat();
        animal.shout();
    }
}


class Animal {
    public void eat(){
        System.out.println("动物吃饭");
    }

    public void shout(){
        System.out.println("动物会叫");
    }
}


class Dog extends Animal{
    public void eat(){
        System.out.println("狗吃饭");
    }

    public void shout(){
        System.out.println("狗会叫");
    }
}

class Cat extends Animal{
    public void eat(){
        System.out.println("猫吃饭");
    }

    public void shout(){
        System.out.println("猫会叫");
    }
}