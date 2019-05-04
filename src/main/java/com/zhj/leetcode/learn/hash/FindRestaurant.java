package com.zhj.leetcode.learn.hash;

import java.util.*;

/**
 * 两个列表的最小索引总和
 *
 * 假设Andy和Doris想在晚餐时选择一家餐厅，并且他们都有一个表示最喜爱餐厅的列表，每个餐厅的名字用字符串表示。
 *
 * 你需要帮助他们用最少的索引和找出他们共同喜爱的餐厅。
 * 如果答案不止一个，则输出所有答案并且不考虑顺序。 你可以假设总是存在一个答案。
 *
 * 示例 1:
 *
 * 输入:
 * ["Shogun", "Tapioca Express", "Burger King", "KFC"]
 * ["Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun"]
 * 输出: ["Shogun"]
 * 解释: 他们唯一共同喜爱的餐厅是“Shogun”。
 *
 * 示例 2:
 *
 * 输入:
 * ["Shogun", "Tapioca Express", "Burger King", "KFC"]
 * ["KFC", "Shogun", "Burger King"]
 * 输出: ["Shogun"]
 *
 * 解释: 他们共同喜爱且具有最小索引和的餐厅是“Shogun”，它有最小的索引和1(0+1)。
 *
 * 提示:
 * 两个列表的长度范围都在 [1, 1000]内。
 * 两个列表中的字符串的长度将在[1，30]的范围内。
 * 下标从0开始，到列表的长度减1。
 * 两个列表都没有重复的元素。
 *
 */
public class FindRestaurant {
    public String[] findRestaurant(String[] list1, String[] list2) {

        Map<String,Integer> map1 = new HashMap<>();
        for (int i = 0; i < list1.length ; i++) {
            map1.put(list1[i],i);
        }

        Map<String,Integer> map2 = new HashMap<>();
        for (int i = 0; i < list2.length ; i++) {
            map2.put(list2[i],i);
        }

        List<String> list = new ArrayList<>();
        int min = Integer.MAX_VALUE ;
        for (String key :map1.keySet()) {
            if (map2.containsKey(key)){
                int index1 = map1.get(key);
                int index2 = map2.get(key);
                int index = index1 + index2;
                if (index <= min){
                    if (index < min){
                        list.clear();
                        min = index ;
                    }
                    list.add(key);
                }
            }
        }

        if (!list.isEmpty()){
            String [] result = new String[list.size()];
            for (int i = 0; i < list.size() ; i++) {
                result[i] = list.get(i);
            }
            return result;
        }else{
            return new String[0];
        }

    }

    public static void main(String[] args) {
        String [] list1 = {"k","KFC"};
        String [] list2 = {"k","KFC"};

        String [] strs = new FindRestaurant().findRestaurant(list1,list2);
        for (String str: strs) {
            System.out.print(str + " ");
        }
    }
}
