package com.study;


import org.w3c.dom.Node;

/**
 * @author : zhangfx 2021/3/17 15:04
 * @version : 1.0
 */
public class LinkedList<E> extends AbstractList<E>{

   private Node<E> firstNode;

   private static class Node<E>{
       E element;
       Node<E> nextNode;
       public Node(E element, Node<E> nextNode) {
           this.element = element;
           this.nextNode = nextNode;
       }
       public Node(E element) {
           this.element = element;
           this.nextNode = null;
       }
       @Override
       public String toString() {
           StringBuilder sb = new StringBuilder();
           sb.append("_").append(element).append("_");
           return sb.toString();
       }
   }

    /**
     * 清除所有元素
     */
    public void clear() {
        firstNode = null;
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

    /**
     * 获取index位置的元素
     * @param index
     * @return
     */
    @Override
    public E get(int index) {
        Node<E> node = node(index);
        return node.element;
    }

    @Override
    public E set(int index, E element) {
        Node<E> node = node(index);
        E old = node.element;
        node.element = element;
        return old;
    }

    @Override
    public void add(int index, E element) {
        if (index == 0) {
            firstNode = new Node<E>(element,firstNode);
        } else {
            Node<E> prevNode = node(index-1);
            Node<E> indexNode = new Node<>(element);
            indexNode.nextNode = prevNode.nextNode;
            prevNode.nextNode = indexNode;
        }
        size++;

    }


    @Override
    public E remove(int index) {
        E element = null;
        if (index == 0) {
            element = firstNode.element;
            firstNode = firstNode.nextNode;
        } else {
            Node<E> prevNode = node(index - 1);
            element = prevNode.nextNode.element;
            prevNode.nextNode = prevNode.nextNode.nextNode;
        }
        size--;
        return element;
    }


    /**
     * 查看元素的索引
     * @param element
     * @return
     */
    @Override
    public int indexOf(E element) {
        Node<E> nextNode = this.firstNode;
        if (element == null) {
            for (int i = 0; i < size; i++) {
                if (nextNode.element == null) {
                    return i;
                }
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (nextNode.element.equals(element)) {
                    return i;
                }
            }
        }
        return 0;
    }


    private Node<E> node(int index) {
        rangeCheck(index);
        Node<E> nextNode = this.firstNode;
        for (int i = 0; i < index; i++) {
            nextNode = nextNode.nextNode;
        }
        return nextNode;
    }


    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();
        string.append("size=").append(size).append(", [");
        Node<E> node = firstNode;
        for (int i = 0; i < size; i++) {
            if (i != 0) {
                string.append(", ");
            }

            string.append(node);

            node = node.nextNode;
        }
        string.append("]");
        return string.toString();
    }




}
