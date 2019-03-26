package com.zhj.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * 给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
 *
 * 例如，给出 n = 3，生成结果为：
 *
 * [
 *   "((()))",
 *   "(()())",
 *   "(())()",
 *   "()(())",
 *   "()()()"
 * ]
 *
 */
public class No_22_generateParenthesis {
    public static List<String> generateParenthesis(int n) {
        if (n == 1){
            return Arrays.asList("()");
        }
        List<String> result = new ArrayList<>();
        if (n > 1 ){
            List<String> preResult = generateParenthesis(n - 1);
            for (String bracket : preResult ) {
                // 包围()
                if (!result.contains( "(" + bracket + ")" ) ){
                    result.add("(" + bracket + ")");
                }
                // 中间加()
                for (int i = 0 ; i < bracket.length() ; i ++ ){
                    String newBrackt = bracket.substring(0,i) + "()"+bracket.substring(i);
                    if (!result.contains(newBrackt)){
                        result.add(newBrackt);
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<String> list = generateParenthesis(4);
        list.forEach(System.out::println);
    }
}
