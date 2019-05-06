package com.zhj.leetcode.easy;

/**
 * 实现 strStr() 函数。
 *
 * 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。
 *
 * 示例 1:
 *
 * 输入: haystack = "hello", needle = "ll"
 * 输出: 2
 *
 *
 * 示例 2:
 *
 * 输入: haystack = "aaaaa", needle = "bba"
 * 输出: -1
 *
 *
 * 说明:
 *
 * 当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。
 *
 * 对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与C语言的 strstr() 以及 Java的 indexOf() 定义相符。
 */
public class No_28_strStr {
    public int strStr(String haystack, String needle) {
        if (needle == null || needle.length() == 0 )
            return 0 ;

        if (haystack == null || haystack.length() == 0 || needle.length() > haystack.length())
            return -1 ;

        char startChar = needle.charAt(0);
        for (int i = 0 ; i < haystack.length() ; i++){
            boolean match = true ;
            if ( i + needle.length() > haystack.length())
                return -1 ;
            else if (haystack.charAt(i) == startChar){
                int k = i ;
                while( k < haystack.length() && k < i + needle.length()){
                    if (haystack.charAt(k) != needle.charAt(k - i)){
                        match = false;
                        break;
                    }
                    k++;
                }
                if (match)
                    return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String haystack = "mississippi", needle = "issip";
        System.out.println(new No_28_strStr().strStr(haystack,needle));
    }
}
