package com.zhj.leetcode.learn.stack;

/**
 * 目标和
 *
 * 给定一个非负整数数组，a1, a2, ..., an, 和一个目标数，S。
 * 现在你有两个符号 + 和 -。对于数组中的任意一个整数，你都可以从 + 或 -中选择一个符号添加在前面。
 *
 * 返回可以使最终数组和为目标数 S 的所有添加符号的方法数。
 *
 * 示例 1:
 * 输入: nums: [1, 1, 1, 1, 1], S: 3
 * 输出: 5
 *
 * 解释:
 * -1+1+1+1+1 = 3
 * +1-1+1+1+1 = 3
 * +1+1-1+1+1 = 3
 * +1+1+1-1+1 = 3
 * +1+1+1+1-1 = 3
 *
 * 一共有5种方法让最终目标和为3。
 *
 * 注意:
 * 数组的长度不会超过20，并且数组中的值全为正数。
 * 初始的数组的和不会超过1000。
 * 保证返回的最终结果为32位整数。
 *
 */
public class FindTargetSumWays {
    public int findTargetSumWays(int[] nums, int S) {
        return findTargetSumWays(nums,0,S);
    }

    public int findTargetSumWays(int[] nums,int left,int S) {
        if (left >= nums.length - 1){
            if (S == 0 && nums[left] == 0){
                return 2;
            }

            if (nums[left] == S || -nums[left] == S ){
                return 1;
            }else{
                return 0;
            }
        }
        return findTargetSumWays(nums,left+1,S+nums[left]) + findTargetSumWays(nums,left+1,S - nums[left]) ;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1,1,1,1};
        int S = 3;

        System.out.println(new FindTargetSumWays().findTargetSumWays(nums,S));
    }

}
