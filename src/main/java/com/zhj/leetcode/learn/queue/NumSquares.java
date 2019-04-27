package com.zhj.leetcode.learn.queue;

/**
 *  完全平方数
 *
 * 给定正整数 n，找到若干个完全平方数（比如 1, 4, 9, 16, ...）使得它们的和等于 n。
 * 你需要让组成和的完全平方数的个数最少。
 *
 * 示例 1:
 * 输入: n = 12
 * 输出: 3
 * 解释: 12 = 4 + 4 + 4.
 *
 * 示例 2:
 * 输入: n = 13
 * 输出: 2
 * 解释: 13 = 4 + 9.
 *
 */
public class NumSquares {


    /**
     * 动规解法：对一个数字n而言，
     * 组成的它的完全平方数的最少个数,可以根据它减去i*i（这里i*i<n）后对应的那个数的最少完全平方数加一，
     * 通过改变i的值最终取得最小值。
     *
     * 还是从简单情况开始
     * 1   1>=1*1 所以1对应等于0对应的最小个数加1,这里0对应的个数为0
     * 2   2>=1*1 所以2对应等于1对应的最小个个数加1，因为之前已经记录了1对应的最小值为1，所以这里最小为2
     * 3   3>=1*1 所以3对应等于2对应的最小个个数加1，因为之前已经记录了2对应的最小值为1，所以这里最小为3
     * 4   4>=1*1和4>=4 所以4对应等于3或者0对应的最小个个数加1，因为之前已经记录了3对应的最小值为3，0对应的最小值为0，所以最终的最小值为1。
     * 往后的情况依次类推。。。
     *
     */
    public int numSquares(int n) {
        int [] dp= new int[n+1]; // 0 到 n
        for (int i = 0; i < n + 1 ; i++) {
            dp[i] = i ;
        }

        for ( int i = 1 ; i <= n ; i++ ){
            int j = 1 ;
            while (i - j*j >= 0 ){
                dp[i] = Math.min(dp[i],dp[i-j*j]+1);
                j++;
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(new NumSquares().numSquares(12));
    }
}
