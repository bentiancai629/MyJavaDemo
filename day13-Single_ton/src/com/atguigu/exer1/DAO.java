package com.atguigu.exer1;

import java.util.*;

/**
 * @author Eric Ni
 * @create 2020-05-31 14:05
 */
public class DAO<T> {


    private Map<String, T> map = new HashMap<String, T>();

    public void save(String id, T entity) {
        map.put(id, entity);
    }

    public T get(String id) {
        return map.get(id);
    }

    public void update(String id, T eneity) {
        if (map.containsKey(id)) {
            map.put(id, eneity);
        }
    }

    public List<T> list() {
//        Collection<T> values = map.values();
//        return (List<T>) values;

        List<T> list = new ArrayList<>();
        Collection<T> values = map.values();
        for (T t : values) {
            list.add(t);
        }
        return list;

    }

    public void delete(String id) {

    }
}
