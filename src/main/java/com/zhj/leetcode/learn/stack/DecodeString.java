package com.zhj.leetcode.learn.stack;

import java.util.Stack;

/**
 * 字符串解码
 *
 * 给定一个经过编码的字符串，返回它解码后的字符串。
 *
 * 编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。
 *
 * 你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。
 *
 * 此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。
 *
 * 示例:
 *
 * s = "3[a]2[bc]", 返回 "aaabcbc".
 * s = "3[a2[c]]", 返回 "accaccacc".
 * s = "2[abc]3[cd]ef", 返回 "abcabccdcdcdef".
 */
public class DecodeString {
    public String decodeString(String s) {
        StringBuilder sb = new StringBuilder();
        char[] chars = s.toCharArray();
        Stack<String> stack = new Stack<>();
        int i = 0 ;
        while(i < chars.length){
            if (chars[i] - '0' >= 0 && chars[i] - '0' <= 9){
                int nums = chars[i] - '0';
                i++;
                while ( chars[i] - '0' >= 0 && chars[i] - '0' <= 9 ){
                    nums = 10 * nums + (chars[i] - '0');
                    i++;
                }
                stack.push(String.valueOf(nums));
            }else if (chars[i] == ']'){
                String str = stack.pop();
                StringBuilder sub = new StringBuilder();

                while(!"[".equals(str) && !stack.isEmpty()){
                    sub.insert(0,str);
                    str = stack.pop();
                }

                //弹出数字
                int times = Integer.parseInt(stack.pop());
                StringBuilder timesStr = new StringBuilder();
                for (int j = 0; j < times; j++) {
                    timesStr.append(sub);
                }
                stack.push(timesStr.toString());
                i++;
            }else{
                stack.push(String.valueOf(chars[i]));
                i++;
            }
        }

        while (!stack.isEmpty()){
            String str = stack.pop();
            sb.insert(0,str);
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "2[abc]3[cd]ef";
        System.out.println(new DecodeString().decodeString(s));
    }
}
