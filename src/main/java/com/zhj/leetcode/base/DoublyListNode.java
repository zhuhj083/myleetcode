package com.zhj.leetcode.base;

public class DoublyListNode {
    public int val;

    public DoublyListNode next;

    public DoublyListNode prev;

    public DoublyListNode(int x) {
        val = x;
    }

    @Override
    public String toString() {
        return "DoublyListNode{" +
                "val=" + val +
                ", next=" + next +
                ", prev=" + prev +
                '}';
    }
}
