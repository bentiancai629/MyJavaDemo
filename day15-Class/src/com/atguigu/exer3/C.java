package com.atguigu.exer3;



interface A{
    String X = "A";
}

class B {
    String X = "B";
}
public class C extends B implements A{
    public void pX(){
        System.out.println(A.X);

        System.out.println(super.X);
    }

    public static void main(String[] args) {
        new C().pX();
    }
}
