package com.zhj.leetcode.medium;

import java.util.*;

/**
 * 给定一个非空的整数数组，返回其中出现频率前 k 高的元素。
 *
 * 示例 1:
 *
 * 输入: nums = [1,1,1,2,2,3], k = 2
 * 输出: [1,2]
 *
 * 示例 2:
 *
 * 输入: nums = [1], k = 1
 * 输出: [1]
 * 说明：
 *
 * 你可以假设给定的 k 总是合理的，且 1 ≤ k ≤ 数组中不相同的元素的个数。
 * 你的算法的时间复杂度必须优于 O(n log n) , n 是数组的大小。
 */
public class No_347_topKFrequent {
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i : nums){
            int f = 0 ;
            if (map.containsKey(i)){
                f = map.get(i);
            }
            map.put(i,++f);
        }

        //按照get出来的元素对应的次数排序
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(k, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return map.get(o1).compareTo(map.get(o2));
            }
        });

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (priorityQueue.size() < k) {
                priorityQueue.offer(entry.getKey());
            } else if (entry.getValue() > map.get(priorityQueue.peek())) {
                priorityQueue.poll();
                priorityQueue.offer(entry.getKey());
            }
        }

        List<Integer> list = new ArrayList<>(k);
        list.addAll(priorityQueue);
        return list;
    }
}
