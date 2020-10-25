package com.mujio.dataStructure.simpleStruct;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: MyQueue
 * @Author: GZY
 * @Date: 2020/5/25 0025
 */

public class MyQueue<T> {

    private List<T> data;

    public MyQueue() {
        data = new ArrayList<>();
    }

    public boolean push(T t) {
        return data.add(t);
    }

    public T pop() {
        return data.remove(0);
    }

    public boolean isEmpty() {
        return data.size() == 0;
    }

    public T getFirst() {
        return data.get(0);
    }
}
