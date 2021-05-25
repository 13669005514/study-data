package com.study;

public class Test {



    public static void main(String[] args) {
        Queue2<Integer> queue = new Queue2<>();

        for (int i = 0; i < 10; i++) {
            queue.push(i);
        }

        System.out.println(queue.size());

        for (int i = 0; i < 5; i++) {
            System.out.println( queue.pop());
        }

        for (int i = 15; i < 20; i++) {
            queue.push(i);
        }

        for (int i = 0; i < 10; i++) {
            System.out.println( queue.pop());
        }

    }

}
