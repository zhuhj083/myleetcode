package com.zhj.leetcode.learn.array_string;

/**
 * 二进制求和
 * 给定两个二进制字符串，返回他们的和（用二进制表示）。
 *
 * 输入为非空字符串且只包含数字 1 和 0。
 *
 * 示例 1:
 *    输入: a = "11", b = "1"
 *    输出: "100"
 *
 * 示例 2:
 *    输入: a = "1010", b = "1011"
 *    输出: "10101"
 *
 */
public class StringAddBinary {

    public String addBinary(String a, String b) {

       char[] aArray = a.toCharArray();
       char[] bArray = b.toCharArray();

       if(aArray.length >= bArray.length){
           return addBinary(aArray,bArray);
       }else{
           return addBinary(bArray,aArray);
       }
    }

    // 长数组，短数组
    private String addBinary(char[] lArray , char[] sArray ){
        int l = lArray.length;
        int s = sArray.length;
        int c = l - s ;

        StringBuilder stringBuilder = new StringBuilder();

        int j = 0 ;
        for (int i = s -1  ; i >= 0  ; i--) {
            char sChar = sArray[i];
            char lChar = lArray[ i + c ];
            int sum = (int)sChar - (int)('0') + (int)lChar - (int)('0') + j;
            stringBuilder.insert(0,sum % 2);
            j = sum / 2 ;
        }

        for (int i = c - 1  ; i >= 0 ; i--){
            char lChar = lArray[i];
            int sum = (int)lChar - (int)('0') + j;
            stringBuilder.insert(0,sum % 2 );
            j = sum / 2 ;
        }


        if ( j == 1){
            stringBuilder.insert(0,1);
        }

        return stringBuilder.toString();
    }


    public static void main(String[] args) {
        String a = "11";
        String b = "1";
        System.out.println(new StringAddBinary().addBinary(a,b));
    }
}
