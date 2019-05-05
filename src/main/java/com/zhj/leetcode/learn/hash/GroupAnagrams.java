package com.zhj.leetcode.learn.hash;

import java.util.*;

/**
 * 字母异位词分组
 * 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
 *
 * 示例:
 *
 * 输入: ["eat", "tea", "tan", "ate", "nat", "bat"],
 * 输出:
 * [
 *   ["ate","eat","tea"],
 *   ["nat","tan"],
 *   ["bat"]
 * ]
 * 说明：
 *
 * 所有输入均为小写字母。
 * 不考虑答案输出的顺序。
 */
public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] chs = str.toCharArray();
            Arrays.sort(chs);
            StringBuilder key = new StringBuilder();
            for (char c:  chs) {
                key.append(c);
            }

            List<String> list ;
            if (map.containsKey(key.toString())){
                list = map.get(key.toString());
                list.add(str);
            }else{
                list = new ArrayList<>();
                list.add(str);
                map.put(key.toString(),list);
            }
        }

        List<List<String>> result = new ArrayList<>();
        for (String key : map.keySet()){
            result.add(map.get(key));
        }

        return result;
    }

    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> list = new GroupAnagrams().groupAnagrams(strs);
        System.out.println(list.size());
    }

}
