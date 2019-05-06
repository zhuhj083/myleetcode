package com.zhj.leetcode.medium;

import java.util.HashSet;
import java.util.Set;

/**
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 * 示例 1:
 *
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 *
 *
 * 示例 2:
 *
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 *
 *
 * 示例 3:
 *
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 */
public class No_3_lengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        if (s != null){
            int i = 0 ;
            int j = 0 ;
            Set<Character> set = new HashSet<>();
            while(i < s.length() && j < s.length()){
                char c = s.charAt(j);
                if (!set.contains(c)){
                    set.add(s.charAt(j++));
                    max = Math.max(max, j - i);
                }else{
                    set.remove(s.charAt(i++));
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
//        System.out.println(new No_3_lengthOfLongestSubstring().lengthOfLongestSubstring("dvdf"));
//        System.out.println(new No_3_lengthOfLongestSubstring().lengthOfLongestSubstring("abcabcbb"));
        System.out.println(new No_3_lengthOfLongestSubstring().lengthOfLongestSubstring("pwwkew"));
    }
}
