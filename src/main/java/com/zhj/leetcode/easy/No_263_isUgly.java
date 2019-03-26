package com.zhj.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * 编写一个程序判断给定的数是否为丑数。
 *
 * 丑数就是只包含质因数 2, 3, 5 的正整数。
 *
 * 示例 1:
 *
 * 输入: 6
 * 输出: true
 * 解释: 6 = 2 × 3
 *
 *
 * 示例 2:
 *
 * 输入: 8
 * 输出: true
 * 解释: 8 = 2 × 2 × 2
 *
 *
 * 示例 3:
 *
 * 输入: 14
 * 输出: false
 * 解释: 14 不是丑数，因为它包含了另外一个质因数 7。
 * 说明：
 *
 * 1 是丑数。
 * 输入不会超过 32 位有符号整数的范围: [−2^31,  2^31 − 1]。
 *
 */
public class No_263_isUgly {
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


    // 找出一个数的所有质因子
    public List<Integer> getAll(int num){
        List<Integer> result = new ArrayList<>();
        for(int i = 2 ; i <= num ;) {
            if(num % i == 0 ) {
                result.add(i);
                num /= i ;
            }
            else i++;
        }

        return result;
    }


    public static void main(String[] args) {
        System.out.println(new No_263_isUgly().isUgly(0));

        new No_263_isUgly().getAll(905391974).forEach(System.out::println);

    }
}
