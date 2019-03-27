package com.zhj.leetcode.medium;

import java.util.PriorityQueue;

/**
 * 在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 *
 * 示例 1:
 *
 * 输入: [3,2,1,5,6,4] 和 k = 2
 * 输出: 5
 *
 *
 * 示例 2:
 *
 * 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
 * 输出: 4
 * 说明:
 *
 * 你可以假设 k 总是有效的，且 1 ≤ k ≤ 数组的长度。
 */
public class No_215_findKthLargest {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(k);
        for (int num: nums) {
            if (priorityQueue.size() < k ){
                priorityQueue.offer(num);
            }else{
                if (priorityQueue.peek() < num){
                    priorityQueue.poll();
                    priorityQueue.offer(num);
                }
            }
        }
        return priorityQueue.peek();
    }

    public static void main(String[] args) {
        int[] nums = {3,2,1,5,6,4};
        System.out.println(new No_215_findKthLargest().findKthLargest(nums,2));
    }
}
