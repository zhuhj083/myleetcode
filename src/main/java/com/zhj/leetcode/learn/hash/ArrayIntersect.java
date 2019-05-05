package com.zhj.leetcode.learn.hash;

import java.util.HashMap;
import java.util.Map;

/**
 * 两个数组的交集 II
 *
 * 给定两个数组，编写一个函数来计算它们的交集。
 *
 * 示例 1:
 *
 * 输入: nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出: [2,2]
 *
 * 示例 2:
 * 输入: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出: [4,9]
 * 说明：
 *
 * 输出结果中每个元素出现的次数，应与元素在两个数组中出现的次数一致。
 * 我们可以不考虑输出结果的顺序。
 *
 * 进阶:
 * 如果给定的数组已经排好序呢？你将如何优化你的算法？
 * 如果 nums1 的大小比 nums2 小很多，哪种方法更优？
 * 如果 nums2 的元素存储在磁盘上，磁盘内存是有限的，并且你不能一次加载所有的元素到内存中，你该怎么办？
 *
 */
public class ArrayIntersect {

    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer,Integer> map1 = new HashMap<>();
        for (int i = 0; i < nums1.length ; i++) {
            map1.put(i,nums1[i]);
        }

        Map<Integer,Integer> map2 = new HashMap<>();
        for (int i = 0; i < nums2.length ; i++) {
            map2.put(i,nums2[i]);
        }

        Map<Integer,Integer> map = new HashMap<>();
        for (int i : map1.keySet()){
            int val1 = map1.get(i);
            for (int j : map2.keySet()) {
                int val2 = map2.get(j);
                if (val1 == val2 ){
                    if (!map.containsKey(j)){
                        map.put(j,val2);
                        break;
                    }
                }
            }
        }

        int[] ret = new int[map.size()];
        int i = 0 ;
        for (int num : map.keySet()) {
            int val = map.get(num);
            ret[i++] = val;
        }

        return ret;
    }
}
