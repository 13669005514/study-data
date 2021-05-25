package com.study;


import com.study.printer.BinaryTreeInfo;

import java.util.Comparator;

public class Tree<E> implements ITree<E>, BinaryTreeInfo {

    protected Node<E> root;

    private int size;

    private Comparator comparator;


    public Tree() {
    }

    public Tree(Comparator comparator) {
        this.comparator = comparator;
    }


    protected static class Node<E>{
        E element;
        Node<E> left;
        Node<E> right;
        Node<E> parent;
        public Node(E element, Node<E> parent) {
            this.element = element;
            this.parent = parent;
        }
        public boolean hasTwoChildren() {
            return left != null && right != null;
        }

        public boolean isLeftChild() {
            return parent != null && this == parent.left;
        }

        public boolean isRightChild() {
            return parent != null && this == parent.right;
        }
    }

    protected Node<E> createNode(E element, Node<E> parent) {
        return new Node<>(element, parent);
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public void add(E element) {
        elementNotNull(element);
        if (root == null) {
            root = createNode(element,null);
            afterAdd(root);
            size++;
        } else {
            Node currentNode = root;
            Node<E> parent = null;
            int cmp = 0;
            while (currentNode != null) {
                parent = currentNode;
                int cmpTo = compareTo(element, (E) currentNode.element);
                if (cmpTo < 0) {
                    currentNode = currentNode.left;
                    cmp = -1;
                } else if (cmpTo > 0) {
                    currentNode = currentNode.right;
                    cmp = 1;
                } else {
                    return;
                }
            }
            Node<E> eNode = createNode(element, parent);
            if (cmp < 0) {
                parent.left =  eNode;
            } else {
                parent.right = eNode;
            }

            afterAdd(eNode);

            size++;
        }
    }

    protected void afterAdd(Node<E> eNode) {



    }

    private void elementNotNull(E element) {
        if (element == null) {
            throw new IllegalArgumentException("参数异常");
        }

    }

    private int compareTo(E e1,E e2) {
        if (comparator != null) {
            comparator.compare(e1,e2);
        }
        return ((Comparable<E>)e1).compareTo(e2);
    }

    @Override
    public void remove(E element) {
        //找到node
        remove(node(element));
    }

    private void remove(Node<E> node) {
        if (node == null) return ;
        size--;
        //判断node的度
        //度为2
        if (node.hasTwoChildren()) { // 度为2的节点
            // 找到后继节点
            Node<E> s = successor(node);
            // 用后继节点的值覆盖度为2的节点的值
            node.element = s.element;
            // 删除后继节点
            node = s;
        }
        Node<E> replaceElment = node.left != null? node.left:node.right;
        if (replaceElment != null) {
            //度为1
            replaceElment.parent = node.parent;
            if (replaceElment.parent == null) {
                root = replaceElment;
            } else if (replaceElment == node.left) {
                node.parent.left = replaceElment;
            } else {
                node.parent.right = replaceElment;
            }

        } else if (node.parent == null) {
            root = null;
        } else {
            //度为0
            if (node == node.parent.left) {
                node.parent.left = null;
            } else {
                node.parent.right = null;
            }
        }
    }
    private Node<E> successor(Node<E> node) {
        if (node == null) return null;

        // 前驱节点在左子树当中（right.left.left.left....）
        Node<E> p = node.right;
        if (p != null) {
            while (p.left != null) {
                p = p.left;
            }
            return p;
        }

        // 从父节点、祖父节点中寻找前驱节点
        while (node.parent != null && node == node.parent.right) {
            node = node.parent;
        }

        return node.parent;
    }

    private Node<E> node(E element) {
        Node<E> node = this.root;
        while (node != null) {
            int cmp = compareTo(node.element, element);
            if (cmp == 0) {
                return node;
            } else if (cmp > 0) {
                node = node.left;
            } else if (cmp < 0) {
                node = node.right;
            }
        }
       return null;

    }

    @Override
    public boolean contains(E element) {
        return false;
    }

    @Override
    public void preOrder() {
        preOrder(root);
    }

    private void preOrder(Node<E> node) {
        if (node == null) {
            return;
        }
        System.out.println(node.element);
        preOrder(node.left);
        preOrder(node.right);
    }

    @Override
    public void inOrder() {
        inOrder(root);
    }

    private void inOrder(Node<E> node) {
        if (node == null) {
            return;
        }
        inOrder(node.left);
        System.out.println(node.element);
        inOrder(node.right);
    }

    @Override
    public void postOrder() {
        postOrder(root);
    }

    private void postOrder(Node<E> node) {
        if (node == null) {
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.element);
    }

    @Override
    public void fzOrder() {
        fzOrder(root);
    }

    private void fzOrder(Node<E> node) {
        if (node == null) {
            return;
        }
        Node<E> ls = node.left;
        node.left = node.right;
        node.right = ls;
        fzOrder(node.left);
        fzOrder(node.right);
    }
    @Override
    public Object root() {
        return root;
    }

    @Override
    public Object left(Object node) {
        return ((Node<E>) node).left;
    }

    @Override
    public Object right(Object node) {
        return  ((Node<E>) node).right;
    }

    @Override
    public Object string(Object node) {
        return ((Node<E>) node).element;
    }

}
