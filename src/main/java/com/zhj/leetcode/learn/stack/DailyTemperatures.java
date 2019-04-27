package com.zhj.leetcode.learn.stack;

import java.util.Stack;

/**
 * 每日温度
 *
 * 根据每日 气温 列表，请重新生成一个列表，对应位置的输入是你需要再等待多久温度才会升高的天数。
 * 如果之后都不会升高，请输入 0 来代替。
 *
 * 例如，给定一个列表 temperatures = [73, 74, 75, 71, 69, 72, 76, 73]，
 * 你的输出应该是 [1, 1, 4, 2, 1, 1, 0, 0]。
 *
 * 提示：气温 列表长度的范围是 [1, 30000]。每个气温的值的都是 [30, 100] 范围内的整数。
 */
public class DailyTemperatures {

    /**
     * 使用 递减栈 来做
     *
     * 例如，当遍历到第2个元素 75 的时候，Stack中的元素是这样的
     * |       |
     * |       |
     * | 3(71) |
     * | 5(72) |
     * | 6(76) |  <-- 这就是要找的元素 6
     * |_______|
     *
     */
    public int[] dailyTemperatures(int[] T) {
        int[] dailys = new int[T.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = T.length - 1 ; i >= 0 ; i--){
            while (!stack.isEmpty() && T[i]>= T[stack.peek()] ) {
                //当新的元素进栈时会将:从栈顶开始将所有比它小的元素挤出去,注意是所有
                stack.pop();
            }

            if(stack.isEmpty()) {
                dailys[i] = 0 ;
            } else {
                //计算出新入栈的元素和第一个比它大的元素的索引差值,再放入数组
                dailys[i] = stack.peek() - i ;
            }

            stack.push(i);
        }

        return dailys;
    }

    public static void main(String[] args) {
        int[] T = {73, 74, 75, 71, 69, 72, 76, 73};
        int[] d = new DailyTemperatures().dailyTemperatures(T);
        for (int i : d){
            System.out.print(i + " ");
        }
    }
}
