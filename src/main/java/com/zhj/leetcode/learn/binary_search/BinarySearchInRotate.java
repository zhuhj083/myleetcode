package com.zhj.leetcode.learn.binary_search;

/**
 * 搜索旋转排序数组
 *
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 * 搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
 * 你可以假设数组中不存在重复的元素。
 *
 * 你的算法时间复杂度必须是 O(log n) 级别。
 *
 * 示例 1:
 * 输入: nums = [4,5,6,7,0,1,2], target = 0
 * 输出: 4
 *
 * 示例 2:
 * 输入: nums = [4,5,6,7,0,1,2], target = 3
 * 输出: -1
 */
public class BinarySearchInRotate {

    public int search(int[] nums, int target) {
        int start = 0  , end = nums.length - 1 ;
        int i = 0;
        while (i < nums.length){
            if (i + 1 < nums.length ){
                if (nums[i+1] < nums[i]){
                    start = i + 1 ;
                    end = i + nums.length;
                }
            }
            i++;
        }

        System.out.println("start="+start + " end="+end);

        int mid = 0 ;
        while (start <= end){
            mid = start + (end - start) / 2;
            if (nums[mid % nums.length] == target){
                return mid % nums.length ;
            }else if (nums[mid % nums.length] < target){
                start = mid + 1 ;
            }else {
                end = mid - 1;
            }
        }

        return -1 ;
    }

    public static void main(String[] args) {
        int[] nums = {3,1};
        int target = 1;

        System.out.println(new BinarySearchInRotate().search(nums,target));
    }

}
