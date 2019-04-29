package com.zhj.leetcode.learn.array_string;

import java.util.Stack;

/**
 * 反转字符串中的单词 III
 * 给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。
 *
 * 示例 1:
 * 输入: "Let's take LeetCode contest"
 * 输出: "s'teL ekat edoCteeL tsetnoc"
 *
 * 注意：在字符串中，每个单词由单个空格分隔，并且字符串中不会有任何额外的空格。
 *
 */
public class ReverseWords2 {
    public String reverseWords(String s) {
        if (s.length() == 0){
            return s ;
        }

        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        int i= 0;
        while (i < s.length()){
            char c = s.charAt(i);
            if (c != ' '){
                stack.push(c);
            }
            if (c == ' ' || i == s.length() - 1 ) {
                while (!stack.isEmpty()){
                    sb.append(stack.pop());
                }
                if (i != s.length() - 1){
                    sb.append(' ');
                }
            }
            i++;
        }

        return sb.toString();

    }

    public static void main(String[] args) {
        System.out.println(new ReverseWords2().reverseWords("Let's take LeetCode contest"));
    }
}
