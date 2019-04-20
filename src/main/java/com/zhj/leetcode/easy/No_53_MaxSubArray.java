package com.zhj.leetcode.easy;

/**
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 *
 * 示例:
 *      输入: [-2,1,-3,4,-1,2,1,-5,4],
 *      输出: 6
 * 解释:
 *      连续子数组 [4,-1,2,1] 的和最大，为 6。
 *
 * 进阶:
 *      如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。
 */
public class No_53_MaxSubArray {

    public int maxSubArray(int[] nums) {
        int sum = nums[0];
        int cur = nums[0];
        //我们考虑如果全是负数，那么返回最大的负数，如果最后的和为正，那么就使用扫描法
        for (int i = 1 ; i < nums.length ; i++) {
            if (cur < 0 ){
                //当前数小于0,换为下一个数
                cur = nums[i];
            }else{
                //如果当前数不小于0
                cur += nums[i];
            }

            if (cur > sum){
                sum = cur;
            }
        }
        return sum;

    }


    public static void main(String[] args) {
        int[] nums = {-2,1,-3,-4,-1,1,1,-5,4};
        System.out.println(new No_53_MaxSubArray().maxSubArray(nums));
    }
}
