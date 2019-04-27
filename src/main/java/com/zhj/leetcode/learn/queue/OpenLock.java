package com.zhj.leetcode.learn.queue;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * 打开转盘锁
 *
 * 你有一个带有四个圆形拨轮的转盘锁。
 * 每个拨轮都有10个数字： '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' 。
 * 每个拨轮可以自由旋转：例如把 '9' 变为  '0'，'0' 变为 '9' 。
 * 每次旋转都只能旋转一个拨轮的一位数字。
 *
 * 锁的初始数字为 '0000' ，一个代表四个拨轮的数字的字符串。
 *
 * 列表 deadends 包含了一组死亡数字，一旦拨轮的数字和列表里的任何一个元素相同，这个锁将会被永久锁定，无法再被旋转。
 *
 * 字符串 target 代表可以解锁的数字，你需要给出最小的旋转次数，如果无论如何不能解锁，返回 -1。
 *
 *
 *
 * 示例 1:
 *
 * 输入：deadends = ["0201","0101","0102","1212","2002"], target = "0202"
 * 输出：6
 * 解释：
 * 可能的移动序列为 "0000" -> "1000" -> "1100" -> "1200" -> "1201" -> "1202" -> "0202"。
 * 注意 "0000" -> "0001" -> "0002" -> "0102" -> "0202" 这样的序列是不能解锁的，
 * 因为当拨动到 "0102" 时这个锁就会被锁定。
 * 示例 2:
 *
 * 输入: deadends = ["8888"], target = "0009"
 * 输出：1
 * 解释：
 * 把最后一位反向旋转一次即可 "0000" -> "0009"。
 * 示例 3:
 *
 * 输入: deadends = ["8887","8889","8878","8898","8788","8988","7888","9888"], target = "8888"
 * 输出：-1
 * 解释：
 * 无法旋转到目标数字且不被锁定。
 * 示例 4:
 *
 * 输入: deadends = ["0000"], target = "8888"
 * 输出：-1
 *
 *
 * 提示：
 *
 * 死亡列表 deadends 的长度范围为 [1, 500]。
 * 目标数字 target 不会在 deadends 之中。
 * 每个 deadends 和 target 中的字符串的数字会在 10,000 个可能的情况 '0000' 到 '9999' 中产生。
 *
 */
public class OpenLock {

    /**
     * 思路：这道题是典型的BFS解题模式，
     * 首先从"0000"，开始遍历，把它放到辅助队列q中，
     * 每次去除队列中元素的字符串，对其每一位都做 加减1 处理，然后放入新的队列。
     * 遍历完队列的所有元素我们把计数器加1，如果遇到target就返回计数器，
     * 如果直到队列为空都没有遇到target，那么返回-1。
     * 在处理过程中我们需要一个visited的hashset来保存已经访问过的节点，防止重复访问。
     */
    public int openLock(String[] deadends, String target) {
        String init = "0000";
        Set<String> deadendsSet = new HashSet<>(deadends.length);
        for (String str : deadends) {
            if (init.equals(str)){
                return -1;
            }
            deadendsSet.add(str);
        }
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        int step = -1 ;

        queue.offer(init);
        visited.add(init);

        while (!queue.isEmpty()){
            step = step + 1;

            int size = queue.size();
            for (int i = 0; i < size; ++i) {

                String strFromQueue = queue.poll();
                if (target.equals(strFromQueue)){
                    return step;
                }

                StringBuilder str;
                for (int j = 0; j < strFromQueue.length(); j++) {

                    // -1
                    str = new StringBuilder(strFromQueue);
                    int num = str.charAt(j) - '0';
                    int newNumMinus = num - 1 < 0 ? 9 : num - 1 ;
                    str.deleteCharAt(j);
                    str.insert(j,newNumMinus );
                    System.out.println("- "+ str);
                    if (!visited.contains(str.toString()) && !deadendsSet.contains(str.toString())){
                        queue.offer(str.toString());
                        visited.add(str.toString());
                    }

                    // +1
                    str = new StringBuilder(strFromQueue);
                    int newNumPlus = num + 1 > 9 ? 0 : num + 1 ;
                    str.deleteCharAt(j);
                    str.insert(j,newNumPlus );
                    System.out.println("+ "+ str);
                    if (!visited.contains(str.toString()) && !deadendsSet.contains(str.toString() )){
                        queue.offer(str.toString());
                        visited.add(str.toString());
                    }
                }

            }

        }

        return -1;

    }

    public static void main(String[] args) {
        String [] deadends = {"8887","8889","8878","8898","8788","8988","7888","9888"};
        String target = "8888";
        System.out.println(new OpenLock().openLock(deadends,target));
    }
}
