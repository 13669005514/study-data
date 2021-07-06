package com.study;

import com.study.printer.BinaryTrees;

public class main2 {

    public static void main(String[] args) {
//        Integer[] integers = {
//                10, 66, 22, 16, 95, 92, 18, 34, 97, 98, 69, 19
//        };
        Integer[] integers = {
                10, 15,9,7,8
        };
        AVLTree<Integer> tree = new AVLTree<Integer>();
        for (Integer integer : integers) {
            tree.add(integer);
        }
        BinaryTrees.println(tree);
        System.out.println(tree);
        tree.remove(15);
        BinaryTrees.println(tree);
//        tree.preOrder();
//        System.out.println("=================");
//        tree.inOrder();
//        System.out.println("=================");
//        tree.postOrder();
//
//        System.out.println("=================");
//        //度为0
//        //tree.remove(5);
//        //度为1
//        //tree.remove(8);
//        //度为2
//        tree.remove(6);
//        BinaryTrees.println(tree);

    }



}
