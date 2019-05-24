package com.zhj.leetcode.learn.binary_search;

/**
 * 寻找峰值
 * 峰值元素是指其值大于左右相邻值的元素。
 *
 * 给定一个输入数组 nums，其中 nums[i] ≠ nums[i+1]，找到峰值元素并返回其索引。
 *
 * 数组可能包含多个峰值，在这种情况下，返回任何一个峰值所在位置即可。
 *
 * 你可以假设 nums[-1] = nums[n] = -∞。
 *
 * 示例 1:
 *
 * 输入: nums = [1,2,3,1]
 * 输出: 2
 * 解释: 3 是峰值元素，你的函数应该返回其索引 2。
 *
 * 示例 2:
 *
 * 输入: nums = [1,2,1,3,5,6,4]
 * 输出: 1 或 5
 * 解释: 你的函数可以返回索引 1，其峰值元素为 2；
 *      或者返回索引 5， 其峰值元素为 6。
 *
 * 说明:
 *
 * 你的解法应该是 O(logN) 时间复杂度的。
 */
public class FindPeakElement {

    public int findPeakElement(int[] nums) {
        if(nums == null || nums.length == 0) {
            return -1;
        }

        if(nums == null || nums.length == 1) {
            return 0 ;
        }

        return findPeakElement(nums,0 , nums.length);
    }

    private int findPeakElement(int[] nums,int start , int end) {
        int left = start , right = end ;
        while (left < right){
            int mid = left + (right - left) / 2 ;
            if (isPeak(nums,mid)){
                return mid;
            }else {
                right = mid - 1;
                int leftFind = findPeakElement( nums,start,mid - 1 );
                if (leftFind != -1){
                    return leftFind;
                }
                left = mid + 1;
                int rightFind = findPeakElement(nums,mid + 1 , end );
                if (rightFind != -1){
                    return rightFind;
                }
            }
        }

        if (right == left && right >= 0  && right < nums.length){
            if (isPeak(nums,right)){
                return right;
            }
        }

        return - 1 ;
    }

    private boolean isPeak(int[] nums,int index){
        int val = nums[index];
        if (index == 0 ){
            return val > nums[index + 1];
        }else if (index == nums.length - 1 ){
            return val > nums[index - 1];
        }else{
            if ( val > nums[index -1] && val > nums[index + 1] ){
                return true ;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {-2147483648};
        System.out.println(new FindPeakElement().findPeakElement(nums));
    }

}
