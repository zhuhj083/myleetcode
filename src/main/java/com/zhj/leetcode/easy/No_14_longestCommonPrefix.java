package com.zhj.leetcode.easy;

/**
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 *
 * 如果不存在公共前缀，返回空字符串 ""。
 *
 * 示例 1:
 *
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 * 示例 2:
 *
 * 输入: ["dog","racecar","car"]
 * 输出: ""
 * 解释: 输入不存在公共前缀。
 * 说明:
 *
 * 所有输入只包含小写字母 a-z 。
 */
public class No_14_longestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if (strs != null && strs.length > 0){
            int i = 0 ;
            char c ;
            while(true){
                for (int j = 0 ; j < strs.length ; j++ ){
                    if (i >= strs[j].length()){
                        return strs[0].substring(0,i);
                    }
                    c = strs[0].charAt(i);
                    if ( c != strs[j].charAt(i)){
                        return strs[0].substring(0,i);
                    }
                }
                i++;
            }
        }
        return "";
    }

    public static void main(String[] args) {
        String[] strs = {"flower","flow","flight"};
        String[] strs2 = {"a","cc"};
        String[] strs3 = {};
        System.out.println(new No_14_longestCommonPrefix().longestCommonPrefix(strs));
        System.out.println(new No_14_longestCommonPrefix().longestCommonPrefix(strs2));
        System.out.println(new No_14_longestCommonPrefix().longestCommonPrefix(strs3));
    }
}
