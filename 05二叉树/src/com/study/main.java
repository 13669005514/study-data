package com.study;

import com.study.printer.BinaryTrees;

public class main {

    public static void main(String[] args) {
        Integer[] integers = {
                6, 4,5, 3,2, 7, 4, 8,12,1,9
        };
        Tree<Integer> tree = new Tree<Integer>();
        for (Integer integer : integers) {
            tree.add(integer);
        }
        BinaryTrees.println(tree);

        tree.preOrder();
        System.out.println("=================");
        tree.inOrder();
        System.out.println("=================");
        tree.postOrder();

        System.out.println("=================");
        //度为0
        //tree.remove(5);
        //度为1
        //tree.remove(8);
        //度为2
        tree.remove(6);
        BinaryTrees.println(tree);

    }



}
