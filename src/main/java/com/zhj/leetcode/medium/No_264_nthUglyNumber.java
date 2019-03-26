package com.zhj.leetcode.medium;

/**
 * 编写一个程序，找出第 n 个丑数。
 *
 * 丑数就是只包含质因数 2, 3, 5 的正整数。
 *
 * 示例:
 *
 * 输入: n = 10
 * 输出: 12
 * 解释: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 是前 10 个丑数。
 * 说明:
 *
 * 1 是丑数。
 * n 不超过1690。
 *
 */
public class No_264_nthUglyNumber {
    public int nthUglyNumber(int n) {

        return 0;
    }


    public boolean isUgly(int num) {
        if (num == 1) {
            return true;
        }
        while ( num != 0 && num % 2 == 0){
            num = num / 2 ;
        }
        while (num != 0 && num % 3 == 0){
            num = num / 3 ;
        }
        while (num != 0 && num % 5 == 0){
            num = num / 5 ;
        }
        return num == 1 ;
    }
}
