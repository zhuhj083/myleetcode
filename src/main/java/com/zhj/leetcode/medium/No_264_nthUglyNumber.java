package com.zhj.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

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
        if (n == 1)
            return 1;

        int[] nthUglyNumbers = new int[n];
        nthUglyNumbers[0]=1;

        int x2 = 0 ;
        int x3 = 0 ;
        int x5 = 0 ;

        for (int i = 1 ; i < n ; i++) {
            nthUglyNumbers[i] = Math.min(Math.min(nthUglyNumbers[x2] * 2, nthUglyNumbers[x3] * 3 ) ,nthUglyNumbers[x5] * 5 );
            if (nthUglyNumbers[i] == nthUglyNumbers[x2]*2)
                x2++;
            if (nthUglyNumbers[i] == nthUglyNumbers[x3]*3)
                x3++;
            if (nthUglyNumbers[i] == nthUglyNumbers[x5]*5)
                x5++;
        }
        return nthUglyNumbers[n-1];
    }

    public static void main(String[] args) {
        System.out.println(new No_264_nthUglyNumber().nthUglyNumber(16));
    }
}
