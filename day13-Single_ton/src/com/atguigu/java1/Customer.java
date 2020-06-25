package com.atguigu.java1;


public class Customer {
    private String name;
    private int age;

    public Customer(){

    }

    public Customer(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (!(o instanceof Customer)) return false;
//        Customer customer = (Customer) o;
//        return age == customer.age &&
//                Objects.equals(name, customer.name);
//    }

    @Override
    public boolean equals(Object obj){
        if (this == obj){
            return true;
        }

        if(obj instanceof Customer) {
            Customer customer = (Customer)obj;
            // 比较对象的属性
//            if(this.age == customer.age && this.name.equals(customer.name)){
//                return true;
//            }else{
//            return false;
// }

            return this.age == customer.age && this.name.equals(customer.name);
        }

        return false;

    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
//    @Override
//    public String toString(){
//        return  "Customer[name= "+name + ",age="+age+ "]";
//    }

}
