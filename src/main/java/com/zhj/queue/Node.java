package com.zhj.queue;

/**
 * 链表的节点
 * @param <E>
 */
public class Node<E> {
    //保存节点的数值
    private E value;

    //单项链表的指向下一个节点的指针
    private Node<E> next;

    public Node(E value) {
        this.value = value;
    }

    public E getValue() {
        return value;
    }

    public void setValue(E value) {
        this.value = value;
    }

    public Node<E> getNext() {
        return next;
    }

    public void setNext(Node<E> next) {
        this.next = next;
    }
}
