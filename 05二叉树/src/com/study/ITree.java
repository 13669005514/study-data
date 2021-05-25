package com.study;


public interface ITree<E> {

    int size();

    boolean isEmpty();

    void clear();

    void add(E element);

    void remove(E element);

    boolean contains(E element);

    void preOrder();

    void inOrder();

    void postOrder();

    void fzOrder();







}
