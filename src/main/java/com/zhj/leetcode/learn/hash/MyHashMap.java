package com.zhj.leetcode.learn.hash;

import java.util.Map;

import static java.util.Objects.hash;

/**
 * 设计哈希映射
 * 不使用任何内建的哈希表库设计一个哈希映射
 *
 * 具体地说，你的设计应该包含以下的功能
 *
 * put(key, value)：向哈希映射中插入(键,值)的数值对。如果键对应的值已经存在，更新这个值。
 * get(key)：返回给定的键所对应的值，如果映射中不包含这个键，返回-1。
 * remove(key)：如果映射中存在这个键，删除这个数值对。
 *
 * 示例：
 *
 * MyHashMap hashMap = new MyHashMap();
 * hashMap.put(1, 1);
 * hashMap.put(2, 2);
 * hashMap.get(1);            // 返回 1
 * hashMap.get(3);            // 返回 -1 (未找到)
 * hashMap.put(2, 1);         // 更新已有的值
 * hashMap.get(2);            // 返回 1
 * hashMap.remove(2);         // 删除键为2的数据
 * hashMap.get(2);            // 返回 -1 (未找到)
 *
 * 注意：
 *
 * 所有的值都在 [1, 1000000]的范围内。
 * 操作的总数目在[1, 10000]范围内。
 * 不要使用内建的哈希库。
 *
 */
public class MyHashMap {

    MyEntry[] data ;
    int capacity ;

    /** Initialize your data structure here. */
    public MyHashMap() {
        capacity = 1024 ;
        data = new MyEntry[capacity];
    }

    /** value will always be non-negative. */
    public void put(int key, int value) {
        int hash = hashFunction(key);
        if (contains(key)){
            MyEntry head = data[hash];
            while (head != null){
                if (head.key == key){
                    head.value = value;
                }
                head = head.next;
            }
        }else{
            MyEntry entry = new MyEntry(key,value);
            MyEntry head = data[hash];
            entry.next = head;
            data[hash] = entry;
        }
    }

    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int hash = hashFunction(key);
        MyEntry cur = data[hash];
        while (cur != null){
            if (cur.key == key){
                return cur.value;
            }
            cur = cur.next;
        }
        return -1;
    }

    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int hash = hashFunction(key);
        MyEntry head = data[hash];
        if (head != null){
            if (head.key == key){
                head = head.next;
                data[hash] = head ;
            }else{
                MyEntry cur = head;
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

    public boolean contains(int key) {
        int hash = hashFunction(key);
        MyEntry cur = data[hash];
        while (cur != null){
            if (cur.key == key){
                return true;
            }
            cur = cur.next;
        }
        return false;
    }


    private int hashFunction(int key){
        return key % capacity;
    }

    class MyEntry{
        int key ;
        int value;

        MyEntry next;

        public MyEntry(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    public static void main(String[] args) {
        MyHashMap hashMap = new MyHashMap();
        hashMap.put(1, 1);
        hashMap.put(2, 2);
        System.out.println(hashMap.get(1));            // 返回 1
        System.out.println(hashMap.get(3));            // 返回 -1 (未找到)
        hashMap.put(2, 1);         // 更新已有的值
        System.out.println(hashMap.get(2));            // 返回 1
        hashMap.remove(2);         // 删除键为2的数据
        System.out.println(hashMap.get(2));            // 返回 -1 (未找到)
    }
}
