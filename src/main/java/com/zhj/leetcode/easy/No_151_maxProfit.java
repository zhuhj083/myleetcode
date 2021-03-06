package com.zhj.leetcode.easy;

import java.util.Random;

/**
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 *
 * 如果你最多只允许完成一笔交易（即买入和卖出一支股票），设计一个算法来计算你所能获取的最大利润。
 *
 * 注意你不能在买入股票前卖出股票。
 *
 * 示例 1:
 *
 * 输入: [7,1,5,3,6,4]
 * 输出: 5
 * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
 *      注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格。
 *
 *
 * 示例 2:
 *
 * 输入: [7,6,4,3,1]
 * 输出: 0
 * 解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
 */
public class No_151_maxProfit {
    public int maxProfit(int[] prices) {
        int maxProfit = 0 ;
        if (prices != null){
            for (int i = 0 ; i < prices.length ; i ++){
                for (int j = i + 1 ; j < prices.length ; j++) {
                    if (prices[j] > prices[i]){
                        maxProfit = Math.max(maxProfit,(prices[j] - prices[i]));
                    }
                }
            }
        }
        return maxProfit ;
    }

    /**
     * 动态规划 前i天的最大收益 = max{前i-1天的最大收益，第i天的价格-前i-1天中的最小价格}
     */
    public int maxProfit2(int[] prices) {
        if (prices.length < 2)
            return 0;
        else if (prices.length == 2)
            return Math.max(0,prices[1]-prices[0]);
        else{
            int i = 1 ;
            int maxProfit =  Math.max(0,prices[1]-prices[0]);
            int minPrice = Math.min(prices[0],prices[1]);
            while (i < prices.length){
                maxProfit =  Math.max( maxProfit , prices[i] - minPrice);
                minPrice = Math.min(minPrice,prices[i]);
                i++;
            }
            return maxProfit;
        }
    }

    public static void main(String[] args) {
        int count = 100000;
        int[] prices2 = new int[count];
        Random random = new Random();
        for (int i = 0; i < count; i++) {
            prices2[i] = random.nextInt(50);
        }

        long start = System.currentTimeMillis();
        System.out.println(new No_151_maxProfit().maxProfit(prices2));
        System.out.println("cost1=" + (System.currentTimeMillis() - start));


        start = System.currentTimeMillis();
        System.out.println(new No_151_maxProfit().maxProfit2(prices2));
        System.out.println("cost2=" + (System.currentTimeMillis() - start));

    }
}
