package com.zhj.leetcode.learn.hash;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 字符串中的第一个唯一字符
 *
 * 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
 *
 * 案例:
 * s = "leetcode"
 * 返回 0.
 *
 * s = "loveleetcode",
 * 返回 2.
 *
 * 注意事项：您可以假定该字符串只包含小写字母。
 */
public class FirstUniqChar {
    public int firstUniqChar(String s) {
        Map<Character,Integer> map = new HashMap<>();
        for (int i = 0 ; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)){
                int count = map.get(c);
                map.put(c,count+1);
            }else{
                map.put(c,1);
            }
        }

        int minIndex = -1;
        if (!map.isEmpty()){
            for (Character c : map.keySet()){
                if (map.get(c) == 1){
                    int index = s.indexOf(c);
                    if (minIndex == -1){
                        minIndex = index;
                    }else{
                        if (minIndex > index){
                            minIndex = index;
                        }
                    }
                }
            }
        }
        return minIndex;
    }
}
