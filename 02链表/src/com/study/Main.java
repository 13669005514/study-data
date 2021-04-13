package com.study;

/**
 * @author : zhangfx 2021/3/17 14:58
 * @version : 1.0
 */
public class Main {

    public static void main(String[] args) {
        List<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        System.out.println(list.toString());
        list.set(1,5);
        System.out.println(list.toString());
        list.remove(0);
        System.out.println(list.toString());
        int i = list.indexOf(5);
        System.out.println(i);

    }

}
