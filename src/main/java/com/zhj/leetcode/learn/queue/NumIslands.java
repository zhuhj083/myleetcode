package com.zhj.leetcode.learn.queue;

/**
 * 岛屿的个数
 * 给定一个由 '1'（陆地）和 '0'（水）组成的的二维网格，
 * 计算岛屿的数量。一个岛被水包围，并且它是通过水平方向或垂直方向上相邻的陆地连接而成的。
 * 你可以假设网格的四个边均被水包围。
 *
 * 示例 1:
 *
 * 输入:
 * 11110
 * 11010
 * 11000
 * 00000
 *
 * 输出: 1
 *
 * 示例 2:
 *
 * 输入:
 * 11000
 * 11000
 * 00100
 * 00011
 *
 * 输出: 3
 *
 */
public class NumIslands {

    public int numIslands(char[][] grid) {
        if (grid.length == 0){
            return 0 ;
        }

        //当数组不为空时，计算行数和列数
        int n = grid.length;
        int m = grid[0].length;
        int x = 0 ;

        for(int i = 0 ; i < n ; i ++){
            for (int j = 0; j < m ; j++) {
                if (grid[i][j] == '1' ){
                    x++ ;
                    grid = change(grid,i,j,n,m);
                }
            }
        }
        return x ;
    }

    public char[][] change(char[][]grid,int i , int j,int n , int m){
        grid[i][j] = '0';
        if (i > 0 && grid[i-1][j] == '1' ){
            //置当前点上边的点为0
            grid = change(grid,i-1,j,n,m);
        }
        if (i < n -1 && grid[i+1][j] == '1'){
            //置当前点下边的点为0
            grid = change(grid,i+1,j,n,m);
        }
        if( j < m - 1 && grid[i][j+1] == '1') {
            // 置当前点右方的点为0
            grid = change(grid, i, j + 1,n,m);
        }
        if( j > 0 && grid[i][j-1] == '1'){
            // 置当前点左方的点为0
            grid = change(grid,i,j-1,n,m);
        }
        return grid;
    }
}
