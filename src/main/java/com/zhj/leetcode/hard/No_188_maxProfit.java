package com.zhj.leetcode.hard;

/**
 * 给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。
 *
 * 设计一个算法来计算你所能获取的最大利润。你最多可以完成 k 笔交易。
 *
 * 注意: 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 *
 * 示例 1:
 *
 * 输入: [2,4,1], k = 2
 * 输出: 2
 * 解释: 在第 1 天 (股票价格 = 2) 的时候买入，在第 2 天 (股票价格 = 4) 的时候卖出，
 *      这笔交易所能获得利润 = 4-2 = 2 。
 *
 *
 * 示例 2:
 *
 * 输入: [3,2,6,5,0,3], k = 2
 * 输出: 7
 * 解释: 在第 2 天 (股票价格 = 2) 的时候买入，在第 3 天 (股票价格 = 6) 的时候卖出,
 *      这笔交易所能获得利润 = 6-2 = 4 。
 *      随后，在第 5 天 (股票价格 = 0) 的时候买入，在第 6 天 (股票价格 = 3) 的时候卖出,
 *      这笔交易所能获得利润 = 3-0 = 3 。
 */
public class No_188_maxProfit {
    public int maxProfit(int k, int[] prices) {
        if (prices != null && prices.length > 1 && k > 0 ){
            if (k >= prices.length / 2 )
                return greedy(prices);

            //t[i][0]和t[i][1]分别表示第i笔交易买入和卖出时   各自的最大收益
            int[][] t = new int[k][2];
            for(int i = 0; i < k; ++i)
                t[i][0] = Integer.MIN_VALUE;

            for (int p : prices){
                //第1次买
                t[0][0] = Math.max( t[0][0] , -p);
                t[0][1] = Math.max( t[0][1] , t[0][0] + p);

                int i = 1 ;
                while(i < k ){
                    t[i][0] = Math.max( t[i][0] , t[i-1][1] -p);
                    t[i][1] = Math.max( t[i][1] , t[i][0] + p);

                    i++;
                }
            }
            return t[k-1][1];

        }
        return 0;
    }

    private int greedy(int[] prices) {
        int max = 0;
        for(int i = 1; i < prices.length; ++i) {
            if(prices[i] > prices[i-1])
                max += prices[i] - prices[i-1];
        }
        return max;
    }

    public static void main(String[] args) {
        int[] s = {2,6,8,7,8,7,9,4,1,2,4,5,8};
        System.out.println(new No_188_maxProfit().maxProfit(3,s));
    }
}
