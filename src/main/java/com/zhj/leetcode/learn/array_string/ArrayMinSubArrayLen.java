package com.zhj.leetcode.learn.array_string;

/**
 * 长度最小的子数组
 *
 * 给定一个含有 n 个正整数的数组和一个正整数 s ，找出该数组中满足其和 ≥ s 的长度最小的连续子数组。
 * 如果不存在符合条件的连续子数组，返回 0。
 *
 * 示例:
 * 输入: s = 7, nums = [2,3,1,2,4,3]
 * 输出: 2
 * 解释: 子数组 [4,3] 是该条件下的长度最小的连续子数组。
 *
 * 进阶:
 * 如果你已经完成了O(n) 时间复杂度的解法, 请尝试 O(n log n) 时间复杂度的解法。
 *
 */
public class ArrayMinSubArrayLen {

    /**
     * 滑动窗口法
     *
     * 注意到题目限定的条件：该数组中的元素均是正整数。
     * 因此我们可以用滑动窗口法来解决，当和小于s时，滑动窗口右端点向右移动，使窗口增大；当和大于s时，滑动窗口左端点向右移动，使窗口缩小。
     * 时间复杂度是O(n)，其中n为nums数组的长度。空间复杂度是O(1)。
     *
     */
    public  int minSubArrayLen(int s,int[] nums){
        int left = 0  , right = -1 ;
        int len = nums.length + 1 ;
        int sum = 0 ;
        while (left < nums.length){
            if (right + 1 < nums.length && sum < s){
                sum += nums[++right];
            }else{
                sum -= nums[left];
                left++;
            }

            len = Math.min(len , right - left + 1);
        }

        len = (len == nums.length + 1 ) ? 0 :len;

        return len;
    }


    /**
     * 暴力法：从左到右遍历数组寻找最小长度
     * 时间复杂度是O(n ^ 2)，其中n为nums数组的长度。
     */
    public int minSubArrayLen3(int s, int[] nums) {
        int min = 0 ;

        int sum ;
        int toRight;
        int left;
        for (int i = 0; i < nums.length ; i++) {
            left = i ;
            while(left < nums.length){
                toRight = left;
                sum = 0 ;
                while (sum < s && toRight < nums.length){
                    sum += nums[toRight++];
                }

                if (sum >= s){
                    if (min == 0 ){
                        min = toRight - left ;
                    }else{
                        min = Math.min(min,toRight-left);
                    }
                }

                left = toRight;
                left ++;
            }
        }

        return min ;
    }

    public static void main(String[] args) {
        int[] nums = {2,3,1,2,4,3};
        int s = 7;
        System.out.println(new ArrayMinSubArrayLen().minSubArrayLen(s,nums));
    }
}
