package com.zhj.leetcode.learn.hash;

import java.util.*;

/**
 * 常数时间插入、删除和获取随机元素
 *
 * 设计一个支持在平均 时间复杂度 O(1) 下，执行以下操作的数据结构。
 *
 * insert(val)：当元素 val 不存在时，向集合中插入该项。
 * remove(val)：元素 val 存在时，从集合中移除该项。
 * getRandom：随机返回现有集合中的一项。每个元素应该 有相同的概率 被返回。
 *
 * 示例 :
 *
 * // 初始化一个空的集合。
 * RandomizedSet randomSet = new RandomizedSet();
 *
 * // 向集合中插入 1 。返回 true 表示 1 被成功地插入。
 * randomSet.insert(1);
 *
 * // 返回 false ，表示集合中不存在 2 。
 * randomSet.remove(2);
 *
 * // 向集合中插入 2 。返回 true 。集合现在包含 [1,2] 。
 * randomSet.insert(2);
 *
 * // getRandom 应随机返回 1 或 2 。
 * randomSet.getRandom();
 *
 * // 从集合中移除 1 ，返回 true 。集合现在包含 [2] 。
 * randomSet.remove(1);
 *
 * // 2 已在集合中，所以返回 false 。
 * randomSet.insert(2);
 *
 * // 由于 2 是集合中唯一的数字，getRandom 总是返回 2 。
 * randomSet.getRandom();
 *
 */
public class RandomizedSet {

    //核心思路是用map记录数组每个值对应的下标，在插入和删除时不需要遍历数组寻找对应的数字下标，从而实现插入O(1)
    private Map<Integer,Integer> map;
    private List<Integer> list;
    private int size;

    /** Initialize your data structure here. */
    public RandomizedSet() {
        map = new HashMap<>();
        list = new ArrayList<>();
        size = 0 ;
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if(map.containsKey(val)){
            return false;
        }else{
            //这里需要用add(index,value)的重载方法，覆盖当前的size位置,这个方法在size == index也可以使用
            //不能使用set(index,value)方法，这个方法会在size == index时直接抛异常
            list.add(size,val);
            map.put(val,size);
            size++;
        }
        return true;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if(!map.containsKey(val)){
            return false;
        }else{
            int oldIndex = map.get(val);
            int lastVal = list.get(size - 1);
            list.set(oldIndex,lastVal);
            map.put(lastVal,oldIndex);
            map.remove(val);
            size--;
        }
        return true;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        int size = list.size();
        return list.get(new Random().nextInt(size));
    }

    public static void main(String[] args) {


        RandomizedSet set = new RandomizedSet();
        set.insert(0);
        set.insert(1);
        System.out.println(set.remove(0));

        set.insert(2);
        set.remove(1);
        System.out.println(set.getRandom());


    }
}
