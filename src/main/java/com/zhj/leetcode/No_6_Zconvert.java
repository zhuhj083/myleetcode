package com.zhj.leetcode;

/**
 * 将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
 *
 * 比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：
 *
 * L   C   I   R
 * E T O E S I I G
 * E   D   H   N
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。
 *
 * 请你实现这个将字符串进行指定行数变换的函数：
 *
 * string convert(string s, int numRows);
 *
 *
 *
 * 示例 1:
 *
 * 输入: s = "LEETCODEISHIRING", numRows = 3
 * 输出: "LCIRETOESIIGEDHN"
 *
 *
 * 示例 2:
 *
 * 输入: s = "LEETCODEISHIRING", numRows = 4
 * 输出: "LDREOEIIECIHNTSG"
 * 解释:
 *
 * L     D     R
 * E   O E   I I
 * E C   I H   N
 * T     S     G
 *
 */
public class No_6_Zconvert {

//    0        6       12
//    1     5  7    11 13
//    2  4     8 10    14  16
//    3        9       15
//
//    一共17个，分为4行   6 + 6 + 5
//    0 6 12 1 5 7 11 13 2 4 8 10 14 16 3 9 15
//
//    0        8            16
//    1      7 9         15
//    2    6   10     14
//    3  5     11  13
//    4        12
//    总数a=17
//    n=5  m= 2n - 2 = 8   k = 3(0,1,2)=a/
//    17个     8 + 8 + 1
//    0          k*m            -->  k*m
//    1   7      k*m+1 + n      -->  k*m + 1     k*m+  m-1
//    2   6      k*m+2 + n - 1  -->  k*m + 2     k*m+  m-2
//    3   5      k*m+3 + n - 2  -->  k*m + 3     k*m+  m-3
//    4          k*m+4          -->  k*m + 4


    public String convert(String s, int numRows) {
        int a = s.length();
        int m = 2 * numRows - 2  ;
        if (m <=0){
            m = 1 ;
        }
        int zNum = a / m  + 1 ;   //每个z 几个数
        StringBuilder sb = new StringBuilder();
        for (int i = 0 ; i < numRows ; i ++){
            for (int k = 0 ; k < zNum ; k++){
                if (i == 0){
                    int index = k * m ;
                    if ( index < s.length()){
                        sb.append(s.charAt( index ));
                    }
                }else if (i == numRows - 1){
                    int index = k * m + i ;
                    if (  index < s.length() ){
                        sb.append(s.charAt( index ));
                    }
                }else{
                    int index1 = k * m + i  ;
                    int index2 = k * m + m - i ;
                    if (  index1 < s.length()){
                        sb.append(s.charAt( index1 ));
                    }
                    if (  index2 < s.length()){
                        sb.append(s.charAt( index2 ));
                    }
                }
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String s1 = "AB";
        System.out.println(new No_6_Zconvert().convert(s1,1));
    }


}
