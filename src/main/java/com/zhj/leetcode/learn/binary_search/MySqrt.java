package com.zhj.leetcode.learn.binary_search;

/**
 * x 的平方根
 *
 * 实现 int sqrt(int x) 函数。计算并返回 x 的平方根，其中 x 是非负整数。
 *
 * 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
 *
 * 示例 1:
 * 输入: 4
 * 输出: 2
 *
 * 示例 2:
 * 输入: 8
 * 输出: 2
 * 说明: 8 的平方根是 2.82842...,
 *
 * 由于返回类型是整数，小数部分将被舍去。
 */
public class MySqrt {

    public int mySqrt(int x) {
        int start = 0;
        int end = x ;
        int mid = 0;
        while (start <= end){
            mid = start +  (end - start) / 2 ;
            if (mid == 0){
                if (mid * mid  <= x   &&  ( mid + 1 ) * (mid + 1) > x ){
                    return mid ;
                }else if (mid * mid  > x){
                    end = mid - 1;
                }else {
                    start = mid + 1 ;
                }
            }else{
                if (mid <= x / mid  &&  ( mid + 1 ) > x / (mid + 1) ){
                    return mid ;
                }else if (mid > x / mid){
                    end = mid - 1;
                }else {
                    start = mid + 1 ;
                }
            }
        }
        return mid;
    }

    public static void main(String[] args) {
//        System.out.println(new MySqrt().mySqrt(2147395599));
        System.out.println(new MySqrt().mySqrt(1));
    }
}
