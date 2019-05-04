package com.zhj.leetcode.learn.hash;

/**
 * 设计哈希集合
 * 不使用任何内建的哈希表库设计一个哈希集合
 *
 * 具体地说，你的设计应该包含以下的功能
 *
 * add(value)：向哈希集合中插入一个值。
 * contains(value) ：返回哈希集合中是否存在这个值。
 * remove(value)：将给定值从哈希集合中删除。如果哈希集合中没有这个值，什么也不做。
 *
 * 示例:
 * MyHashSet hashSet = new MyHashSet();
 * hashSet.add(1);
 * hashSet.add(2);
 * hashSet.contains(1);    // 返回 true
 * hashSet.contains(3);    // 返回 false (未找到)
 * hashSet.add(2);
 * hashSet.contains(2);    // 返回 true
 * hashSet.remove(2);
 * hashSet.contains(2);    // 返回  false (已经被删除)
 *
 * 注意：
 *
 * 所有的值都在 [1, 1000000]的范围内。
 * 操作的总数目在[1, 10000]范围内。
 * 不要使用内建的哈希集合库。
 *
 */
public class MyHashSet {

    Node[] data ;
    int capacity ;

    /** Initialize your data structure here. */
    public MyHashSet() {
        capacity = 1024 ;
        data = new Node[capacity];
    }

    public void add(int key) {
        if (!contains(key)){
            int hash = hash(key);
            Node node = new Node(key);
            Node head = data[hash];
            node.next = head ;
            data[hash] = node ;
        }
    }

    public void remove(int key) {
        int hash = hash(key);
        Node head = data[hash];
        if (head != null){
            if (head.key == key){
                head = head.next;
                data[hash] = head ;
            }else{
                Node cur = head;
                while (cur != null && cur.next != null){
                    if (cur.next.key == key){
                        cur.next = cur.next.next;
                        break;
                    }else{
                        cur = cur.next;
                    }
                }
            }
        }
    }

    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int hash = hash(key);
        Node cur = data[hash];
        while (cur != null){
            if (cur.key == key){
                return true;
            }
            cur = cur.next;
        }
        return false;
    }


    private int hash(int key){
        return key % capacity;
    }

    class Node{
        int key ;

        Node next ;

        public Node(int key) {
            this.key = key;
        }
    }


    public static void main(String[] args) {
        MyHashSet hashSet = new MyHashSet();
        hashSet.add(1);
        hashSet.add(2);
        System.out.println( hashSet.contains(1) );    // 返回 true
        System.out.println( hashSet.contains(3));    // 返回 false (未找到)
        hashSet.add(2);
        System.out.println( hashSet.contains(2));    // 返回 true
        hashSet.remove(2);
        System.out.println( hashSet.contains(2));    // 返回  false (已经被删除)
    }
}
