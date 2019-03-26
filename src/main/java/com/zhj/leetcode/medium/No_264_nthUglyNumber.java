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

        List<Integer> nthUglyNumbers =  new ArrayList<>();
        nthUglyNumbers.add(1);


        int k = 1;
        while ( k <= n  ){
            int curMax = nthUglyNumbers.get(nthUglyNumbers.size()-1);
            int num2 = Integer.MAX_VALUE;
            int num3 = Integer.MAX_VALUE;
            int num5 = Integer.MAX_VALUE;
            for (int i = 0 ; i < nthUglyNumbers.size() ; i ++){
                if (num2 == Integer.MAX_VALUE  && nthUglyNumbers.get(i) * 2 > curMax){
                    num2 = nthUglyNumbers.get(i) * 2 ;
                }

                if (num3 == Integer.MAX_VALUE && nthUglyNumbers.get(i) * 3 > curMax){
                    num3 = nthUglyNumbers.get(i) * 3 ;
                }

                if (num3 == Integer.MAX_VALUE && nthUglyNumbers.get(i) * 5 > curMax){
                    num5 = nthUglyNumbers.get(i) * 5 ;
                }

                if (num2 != Integer.MAX_VALUE || num3 != Integer.MAX_VALUE  || num5 != Integer.MAX_VALUE ){
                    break;
                }
            }
            nthUglyNumbers.add(Math.min(Math.min(num2,num3),num5));
            k++;
        }
        return nthUglyNumbers.get(nthUglyNumbers.size()-1);
    }

    public static void main(String[] args) {
        System.out.println(new No_264_nthUglyNumber().nthUglyNumber(10));
    }
}
