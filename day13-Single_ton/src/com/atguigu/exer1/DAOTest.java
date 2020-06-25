package com.atguigu.exer1;

import java.util.List;

/**
 * @author Eric Ni
 * @create 2020-05-31 14:13
 */
public class DAOTest {

    public static void main(String[] args) {
        DAO<User> dao = new DAO<User>();

        dao.save("1001", new User(100, "ack", 22));
        dao.save("1002", new User(200, "jack", 32));
        dao.save("1003", new User(300, "jjack", 42));

        dao.update("1003", new User(300, "ak47", 42));

        List<User> list = dao.list();
        list.forEach(System.out::println);

    }
}
