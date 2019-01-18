package com.zhj.leetcode;

/**
 * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 *
 * 示例 1:
 * 输入: 121
 * 输出: true
 *
 * 示例 2:
 * 输入: -121
 * 输出: false
 * 解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
 *
 *
 * 示例 3:
 * 输入: 10
 * 输出: false
 * 解释: 从右向左读, 为 01 。因此它不是一个回文数。
 */
public class No_9_isPalindrome {

    //判断反转后的数是不是和之前的一样
    public static boolean isPalindrome(int x) {
        if (x < 0){
            return false;
        }
        int temp = x ;
        int rev = 0 ;
        while(temp != 0){
            int pop = temp % 10 ;
            temp = temp / 10 ;
            rev = rev * 10 + pop;
        }
        return rev == x ;
    }

    public static boolean isPalindrome2(int x) {
        if (x < 0){
            return false;
        }
        byte[] bytes = String.valueOf(x).getBytes();
        for (int i = 0 ; i < bytes.length / 2 ; i++){
            if ( bytes[i] != bytes[bytes.length - i -1 ])
                return false ;
        }
        return true;
    }

    //反转一半的数字
    public static boolean isPalindrome3(int x) {
        // 特殊情况：
        // 如上所述，当 x < 0 时，x 不是回文数。
        // 同样地，如果数字的最后一位是 0，为了使该数字为回文，
        // 则其第一位数字也应该是 0
        // 只有 0 满足这一属性
        if(x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        int revertedNumber = 0;
        while(x > revertedNumber) {
            revertedNumber = revertedNumber * 10 + x % 10 ;
            x /= 10 ;
        }

        // 当数字长度为奇数时，我们可以通过 revertedNumber/10 去除处于中位的数字。
        // 例如，当输入为 12321 时，在 while 循环的末尾我们可以得到 x = 12，revertedNumber = 123，
        // 由于处于中位的数字不影响回文（它总是与自己相等），所以我们可以简单地将其去除。
        return x == revertedNumber || x == revertedNumber / 10;
    }

    public static void main(String[] args) {
        int x = 121 ;
        System.out.println(isPalindrome2(x));
    }
}
