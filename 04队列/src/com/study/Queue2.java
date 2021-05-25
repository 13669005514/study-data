package com.study;

import java.util.ArrayList;

/**
 * 双向队列
 * @param <E>
 */
public class Queue2<E>{

    private int font;

    private int size;

    private E[] elements;

    public Queue2() {
        elements = (E[]) new Object[10];
    }

    /**
     * 元素的数量
     * @return
     */
    public int size() {
        return size;
    }

    /**
     * 是否为空
     * @return
     */
    public boolean isEmpty() {
        return size == 0;
    }
    public void push(E element) {
        elements[(size+font)%elements.length] = element;
        size ++;
    }

    public E pop() {
        E element = elements[font];
        elements[font] = null;
        font = (font+1)%elements.length;
        size--;
        return element;
    }

    public E top() {
        return elements[font];
    }

}
