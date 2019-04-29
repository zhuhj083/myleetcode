package com.zhj.leetcode.learn.stack;

/**
 * 01 矩阵
 * 给定一个由 0 和 1 组成的矩阵，找出每个元素到最近的 0 的距离。
 *
 * 两个相邻元素间的距离为 1 。
 *
 * 示例 1:
 * 输入:
 * 0 0 0
 * 0 1 0
 * 0 0 0
 * 输出:
 * 0 0 0
 * 0 1 0
 * 0 0 0
 *
 * 示例 2:
 * 输入:
 * 0 0 0
 * 0 1 0
 * 1 1 1
 * 输出:
 * 0 0 0
 * 0 1 0
 * 1 2 1
 *
 * 注意:
 *
 * 给定矩阵的元素个数不超过 10000。
 * 给定矩阵中至少有一个元素是 0。
 * 矩阵中的元素只在四个方向上相邻: 上、下、左、右。
 *
 */
public class UpdateMatrix {
    public int[][] updateMatrix(int[][] matrix) {
        // write your code here
        int n = matrix.length, m = matrix[0].length;

        int[][] dp = new int[n][m];

        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                if (matrix[i][j] == 0) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = 1000000;
                }
                if (i > 0) {
                    //向上
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][j] + 1);
                }
                if (j > 0) {
                    //向左
                    dp[i][j] = Math.min(dp[i][j], dp[i][j - 1] + 1);
                }
            }
        }
        for (int i = n - 1; i >= 0; --i) {
            for (int j = m - 1; j >= 0; --j) {
                if (dp[i][j] > 0) {
                    if (i < n - 1) {
                        //向下
                        dp[i][j] = Math.min(dp[i][j], dp[i + 1][j] + 1);
                    }
                    if (j < m - 1) {
                        //向右
                        dp[i][j] = Math.min(dp[i][j], dp[i][j + 1] + 1);
                    }
                }
            }
        }
        return dp;
    }


    public static void main(String[] args) {

        int[][] matrix = {{1},{1} ,{1},{1},{1},{0}};
        int[][] matrix2 = new UpdateMatrix().updateMatrix(matrix);


        int n = matrix2.length;
        int m = matrix2[0].length;

        for(int i = 0 ; i < n ; i ++){
            for (int j = 0; j < m ; j++) {
                System.out.print(matrix2[i][j] +  " ");
            }
            System.out.println();
        }

    }
}
