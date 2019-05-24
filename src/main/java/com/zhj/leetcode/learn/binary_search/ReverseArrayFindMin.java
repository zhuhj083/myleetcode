package com.zhj.leetcode.learn.binary_search;

/**
 * 寻找旋转排序数组中的最小值
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 *
 * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 *
 * 请找出其中最小的元素。
 *
 * 你可以假设数组中不存在重复元素。
 *
 * 示例 1:
 *
 * 输入: [3,4,5,1,2]
 * 输出: 1
 *
 * 示例 2:
 *
 * 输入: [4,5,6,7,0,1,2]
 * 输出: 0
 */
public class ReverseArrayFindMin {

    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0){
            return -1 ;
        }

        if (nums.length == 1){
            return nums[0] ;
        }
        int n = nums.length - 1;
        int left = 0 , right = n;
        while (left < right){
            int mid = left + (right - left) / 2 ;

            if (mid == 0 || mid == n){
                return Math.min(nums[mid],nums[mid+1]);
            }

            if (nums[mid] < nums[mid-1]){
                return nums[mid];
            }

            if (nums[mid] > nums[0] && nums[mid] < nums[n]){
                return nums[left];
            }else{
                if (nums[mid] > nums[0]){
                    left = mid + 1;
                }else{
                    right = mid;
                }
            }
        }

        System.out.println(left + "  "+ right);
        if (left <= n && nums[left] < nums[0]){
            return nums[left];
        }

        return -1 ;
    }

    public static void main(String[] args) {
        int[] nums = {4,5,6,7,0,1,2};
        System.out.println(new ReverseArrayFindMin().findMin(nums));
    }
}
