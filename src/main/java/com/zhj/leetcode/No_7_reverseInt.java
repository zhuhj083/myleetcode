package com.zhj.leetcode;

/**
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 *
 * 示例 1:
 * 输入: 123
 * 输出: 321
 *
 *  示例 2:
 * 输入: -123
 * 输出: -321
 *
 * 示例 3:
 * 输入: 120
 * 输出: 21
 * 注意:
 *
 * 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−2^31,  2^31 − 1]。
 * 请根据这个假设，如果反转后整数溢出那么就返回 0。
 */
public class No_7_reverseInt {

    //借助于字符串
    public static int reverse1(int x) {
        StringBuilder sb = new StringBuilder();
        String numStr = String.valueOf(x);
        if (x >= 0 ){
            for (int i = numStr.length() - 1  ; i >= 0 ; i-- ){
                sb.append(numStr.charAt(i));
            }
        }else{
            sb.append("-");
            for (int i = numStr.length() - 1  ; i > 0 ; i-- ){
                sb.append(numStr.charAt(i));
            }
        }
        long l = Long.parseLong(sb.toString());
        if ( l > Integer.MAX_VALUE  || l < Integer.MIN_VALUE ){
            return 0;
        }
        return (int)l;
    }

    //弹出和压入
    public static int reverse2(int x) {
        int rev = 0 ;
        int max = Integer.MAX_VALUE/10 ;
        int min = Integer.MIN_VALUE / 10;
        while(x != 0){
            int pop = x % 10 ;
            x = x / 10 ;
            if (rev > max || (rev == max / 10 && pop > 7)) return 0;
            if (rev < min || (rev == min / 10 && pop < -8)) return 0;
            rev = rev * 10 + pop;
        }
        return rev ;
    }


    public static void main(String[] args) {
        System.out.println(reverse2(123));
        System.out.println(reverse2(-123));
    }
}
