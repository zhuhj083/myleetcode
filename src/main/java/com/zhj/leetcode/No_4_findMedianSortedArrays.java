package com.zhj.leetcode;

/**
 * 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。
 *
 * 请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
 *
 * 你可以假设 nums1 和 nums2 不会同时为空。
 *
 *
 * 示例 1:
 *
 * nums1 = [1, 3]
 * nums2 = [2]
 *
 * 则中位数是 2.0
 *
 *
 * 示例 2:
 *
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 *
 * 则中位数是 (2 + 3)/2 = 2.5
 *
 *
 * [1,4,5,6] -->4,5
 * [2,3,7,8] -->3,7
 * [1,2,3,4,5,6,7,8] -->4.5   4 5    3 7 --> 3 4 5 7 --> 4.5
 */
public class No_4_findMedianSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if ( (nums1 == null || nums1.length == 0) && (nums2 == null || nums2.length == 0)) {
            //nums1 和 nums2 同时为空
            throw new IllegalArgumentException("nums1 and nums2 is null");
        } else if (nums1 == null || nums1.length == 0){
            //nums1 为空
            if (nums2.length % 2 != 0 ){
                return nums2[nums2.length / 2 ]  ;
            }else{
                return ( nums2[nums2.length / 2  - 1 ]  + nums2[nums2.length / 2 ] ) / 2.0  ;
            }
        }else if (nums2 == null || nums2.length == 0){
            //nums2 为空
            if (nums1.length % 2 != 0 ){
                return nums1[nums1.length / 2 ]  ;
            }else{
                return ( nums1[nums1.length / 2  - 1 ]  + nums1[nums1.length / 2 ] ) / 2.0  ;
            }
        }

        int start1 = 0;
        int start2 = 0;

        int end1 = nums1.length - 1 ;
        int end2 = nums2.length - 1 ;

        int count = nums1.length + nums2.length;
        while( true){
            if (count <= 2){
                if (start1 <= end1 && start2 <= end2){
                    return (nums1[start1] + nums2[start2]) / 2.0 ;
                }else if (start1 < end1){
                    return (nums1[start1] + nums1[end1]) / 2.0;
                }else if (start1 == end1){
                    return nums1[start1];
                }else if (start2 < end2){
                    return (nums2[start2] + nums2[end2]) / 2.0;
                }else if (start2 == end2){
                    return nums2[start2];
                }
                return 0;
            }

            //去掉一个最小的 去掉一个最大的
            if (start1 <= end1 && start2 <= end2){
                if (nums1[start1] < nums2[start2]){
                    start1++;
                }else{
                    start2++;
                }

                if (nums1[end1] > nums2[end2]){
                    end1--;
                }else{
                    end2--;
                }
            }else if (start1 <= end1){
                start1++;
                end1--;
            }else if (start2 <= end2){
                start2++;
                end2--;
            }
            count -= 2 ;
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {1,2};
        int[] nums2 = {-1,3};
        System.out.println(new No_4_findMedianSortedArrays().findMedianSortedArrays(nums1,nums2));
    }
}
