package com.zhj.leetcode.medium;

import java.util.Arrays;

/**
 * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。
 *
 * 例如，给定数组 nums = [-1，2，1，-4], 和 target = 1.
 *
 * 与 target 最接近的三个数的和为 2. (-1 + 2 + 1 = 2).
 *
 */
public class No_16_threeSumClosest {
    public int threeSumClosest(int[] nums, int target) {
        if (nums != null && nums.length >= 3){
            Arrays.sort(nums);   //  [ -3 0 1 2]
            int closest = nums[0] + nums[1] + nums[ 2 ] ; //-2
            for (int i = 0 ; i < nums.length ; i++){
                int l = i + 1 , r = nums.length - 1 ;
                while( l < r){
                    int sum = nums[i] + nums[l] + nums[r];
                    if (sum == target){
                        return sum ;
                    }else if (sum < target){
                        l++;
                        if ( target - sum < Math.abs( closest - target)){
                            closest = sum ;
                        }
                    }else if (sum > target){
                        r--;
                        if (sum - target < Math.abs(closest - target)){
                            closest = sum ;
                        }
                    }
                }
            }
            return closest;
        }
        return 0 ;
    }

    public static void main(String[] args) {
        int[] nums = {0,2,1,-3};
        int target = 1 ;
        System.out.println("closest = " + new No_16_threeSumClosest().threeSumClosest(nums,target));

    }
}
