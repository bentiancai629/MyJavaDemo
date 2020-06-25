package com.atguigu.java;

/**
 * 静态代理举例
 *
 * 代理类和被代理类在编译期间确定
 *
 * @author Eric Ni
 * @create 2020-06-24 22:54
 */


interface ClothFactory {
    void produceCloth();
}


// 代理类
class ProxyClothFactory implements ClothFactory {

    private ClothFactory factory;

    public ProxyClothFactory(ClothFactory clothFactory) {
        this.factory = clothFactory;
    }

    @Override
    public void produceCloth() {
        System.out.println("代理工厂做一些准备工作");
        factory.produceCloth();
        System.out.println("代理工厂做一些后续的守卫工作");
    }
}



// 被代理类
class NikeClothFactory implements ClothFactory {

    @Override
    public void produceCloth() {
        System.out.println("耐克工厂生产一批运动服");
    }
}


public class StaticProxyTest {

    public static void main(String[] args) {
        // 创建被代理类对象
        NikeClothFactory nike = new NikeClothFactory();
        // 创建代理类对象
        ProxyClothFactory proxyClothFactory = new ProxyClothFactory(nike);

        proxyClothFactory.produceCloth();
    }
}