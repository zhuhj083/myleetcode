package com.zhj.leetcode.learn.array_string;

/**
 * 数组拆分 I
 *
 * 给定长度为 2n 的数组, 你的任务是将这些数分成 n 对,
 * 例如 (a1, b1), (a2, b2), ..., (an, bn) ，使得从1 到 n 的 min(ai, bi) 总和最大。
 *
 * 示例 1:
 * 输入: [1,4,3,2]
 * 输出: 4
 * 解释: n 等于 2, 最大总和为 4 = min(1, 2) + min(3, 4).
 *
 * 提示:
 *   n 是正整数,范围在 [1, 10000].
 *   数组中的元素范围在 [-10000, 10000].
 */
public class ArrayPairSum {


    /**
     * 实现思路：
     * 题目要求分组之后min的和最大，那么基本可以确定最小值不能和最大值同组，
     * 换句话说，同组两个数相差越小越好，所以需要先对数组进行排序后，再取偶数位的和即可。
     *
     * 快速排序，然后将偶数位的数字加起来
     */
    public int arrayPairSum(int[] nums) {

        quickSort(nums,0,nums.length - 1);

        int sum = 0 ;
        for (int i = 0; i < nums.length ; i += 2) {
            sum += nums[i];
        }
        return sum ;
    }

    public static void quickSort(int[] a , int start , int end){
        if ( a.length < 1 || start >= a.length || end <= 0  || start >= end){
            return;
        }

        int t = a[start];

        int i = start;
        int j = end ;
        while (i < j){
            //从尾部开始，找到一个比t小的元素
            while (i < j){
                if (a[j] < t) {
                    break;
                }
                j--;
            }
            //从头部开始找到一个比t大的元素
            while (i < j){
                if (a[i] > t)
                    break;
                i++;
            }
            // 交换i和j位置的元素
            int temp = a[j];
            a[j] = a[i];
            a[i] = temp;
        }

        int temp = a[j];
        a[j] = a[start];
        a[start] = temp;

        quickSort( a , start , j -1  );
        quickSort(a,j + 1 , end);
    }
}
