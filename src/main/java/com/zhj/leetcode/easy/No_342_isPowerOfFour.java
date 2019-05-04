package com.zhj.leetcode.easy;

/**
 * 给定一个整数 (32 位有符号整数)，请编写一个函数来判断它是否是 4 的幂次方。
 *
 * 示例 1:
 *
 * 输入: 16
 * 输出: true
 *
 * 示例 2:
 * 输入: 5
 * 输出: false
 *
 * 进阶：
 * 你能不使用循环或者递归来完成本题吗？
 */
public class No_342_isPowerOfFour {
    /**
     *  num - 1 转化为2进制，是不是都是1，且1的个数是偶数个
     */
    public boolean isPowerOfFour(int num) {
        if (num <= 0 ){
            return false;
        }

        if (num == 1 ){
            return true;
        }

        String binaryString =  Integer.toBinaryString(num - 1 );

        if (binaryString.contains("0")){
            return false;
        }

        if (binaryString.length() % 2 != 0 ){
            return false;
        }

        return true;
    }
}
