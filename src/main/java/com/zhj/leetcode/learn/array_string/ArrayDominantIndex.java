package com.zhj.leetcode.learn.array_string;

/**
 * 在一个给定的数组nums中，总是存在一个最大元素 。
 * 查找数组中的最大元素是否至少是数组中每个其他数字的两倍。
 * 如果是，则返回最大元素的索引，否则返回-1。
 *
 * 示例 1:
 * 输入: nums = [3, 6, 1, 0]
 * 输出: 1
 * 解释: 6是最大的整数, 对于数组中的其他整数,
 * 6大于数组中其他元素的两倍。6的索引是1, 所以我们返回1.
 *
 *
 * 示例 2:
 * 输入: nums = [1, 2, 3, 4]
 * 输出: -1
 * 解释: 4没有超过3的两倍大, 所以我们返回 -1.
 *
 *
 * 提示:
 *
 * nums 的长度范围在[1, 50].
 * 每个 nums[i] 的整数范围在 [0, 99].
 */
public class ArrayDominantIndex {
    public int dominantIndex(int[] nums) {
        int max = -1;
        int maxIndex = -1 ;
        int secondMax = -1;

        for (int i = 0 ; i < nums.length ; i++) {
            if (nums[i] > max){
                secondMax = max;
                max = nums[i];
                maxIndex = i;
            }else if (nums[i] >= secondMax){
                secondMax = nums[i];
            }
            System.out.println(" i = "+i + "  "+nums[i]+" secondMax="+secondMax + " max="+max);
        }

        return max >= 2 * secondMax ? maxIndex : - 1 ;

    }

    public static void main(String[] args) {
        int [] nums = {0, 0, 1, 2};
        System.out.println(new ArrayDominantIndex().dominantIndex(nums));
    }
}
