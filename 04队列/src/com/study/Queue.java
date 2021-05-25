package com.study;

import java.util.ArrayList;

public class Queue<E>{

    private ArrayList<E> list = new ArrayList<>();

    /**
     * 元素的数量
     * @return
     */
    public int size() {
        return list.size();
    }

    /**
     * 是否为空
     * @return
     */
    public boolean isEmpty() {
        return list.size() == 0;
    }
    public void push(E element) {
        list.add(list.size(),element);
    }

    public E pop() {
        return list.remove(0);
    }

    public E top() {
        return list.get(0);
    }

}
