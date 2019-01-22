package com.zhj.leetcode;

/**
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 *
 * 你可以假设数组中无重复元素。
 *
 * 示例 1:
 *
 * 输入: [1,3,5,6], 5
 * 输出: 2
 *
 *
 * 示例 2:
 *
 * 输入: [1,3,5,6], 2
 * 输出: 1
 *
 *
 * 示例 3:
 *
 * 输入: [1,3,5,6], 7
 * 输出: 4
 *
 *
 * 示例 4:
 *
 * 输入: [1,3,5,6], 0
 * 输出: 0
 */
public class No_35_searchInsert {
    public int searchInsert(int[] nums, int target) {
        int start = 0 ;
        int end = nums.length - 1 ;
        int mid = ( start + end ) / 2;
        while (start <= end ){
            if (nums[mid] == target){
                return mid;
            }else{
                if (target > nums[end]){
                    return end + 1;
                }else if (target < nums[start]){
                    return start ;
                }else{
                    if (nums[mid] < target){
                        start = mid + 1  ;
                    }else if (nums[mid] > target){
                        end = mid - 1;
                    }
                }
            }
            mid = ( start + end ) / 2;
        }
        return mid + 1;
    }

    public static void main(String[] args) {
        int[] nums = {1,3,5,6};
        int target = 7;
        System.out.println(new No_35_searchInsert().searchInsert(nums,target));
    }
}
