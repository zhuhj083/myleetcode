package com.zhj.leetcode.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 *
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 *
 *
 * 示例:
 *
 * 输入："23"
 * 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * 说明:
 * 尽管上面的答案是按字典序排列的，但是你可以任意选择答案输出的顺序。
 */
public class No_17_letterCombinations {
    public List<String> letterCombinations(String digits) {
        Map<Integer, char[]> map = new HashMap<>();
        map.put(2,new char[]{'a','b','c'});
        map.put(3,new char[]{'d','e','f'});
        map.put(4,new char[]{'g','h','i'});
        map.put(5,new char[]{'j','k','l'});
        map.put(6,new char[]{'m','n','o'});
        map.put(7,new char[]{'p','q','r','s'});
        map.put(8,new char[]{'t','u','v'});
        map.put(9,new char[]{'w','x','y','z'});
        List<String> list = new ArrayList<>();
        for(int i = 0 ; i < digits.length();i++){
            int c = digits.charAt(i) - '0';
            if (c <= 9 && c >= 2){
                char[] alphabets = map.get(c);
                if (alphabets != null && alphabets.length > 0 ) {
                    list = func(list, alphabets);
                }
            }
        }
        return list ;
    }
    public List<String> func (List<String> list , char[] alphabets){
        List<String> result = new ArrayList<>();
        if (alphabets != null){
            for ( char c : alphabets){
                if (list != null && list.size() > 0 ){
                    for (String s : list){
                        String str = s + c;
                        result.add(str);
                    }
                }else{
                    String str =  String.valueOf(c) ;
                    result.add(str);
                }

            }
        }
        return result;
    }

    public static void main(String[] args) {
        String digits = "27";
        List<String> list = new No_17_letterCombinations().letterCombinations(digits);
        for (String str : list){
            System.out.println(str + " ");
        }
    }
}
