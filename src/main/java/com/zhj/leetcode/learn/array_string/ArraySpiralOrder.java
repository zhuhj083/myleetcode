package com.zhj.leetcode.learn.array_string;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 螺旋矩阵
 *
 * 给定一个包含 m x n 个元素的矩阵（m 行, n 列），请按照顺时针螺旋顺序，返回矩阵中的所有元素。
 *
 * 示例 1:
 * 输入:
 * [
 *  [ 1, 2, 3 ],
 *  [ 4, 5, 6 ],
 *  [ 7, 8, 9 ]
 * ]
 * 输出: [1,2,3,6,9,8,7,4,5]
 *
 * 示例 2:
 * 输入:
 * [
 *   [1, 2, 3, 4],
 *   [5, 6, 7, 8],
 *   [9,10,11,12]
 * ]
 * 输出: [1,2,3,4,8,12,11,10,9,5,6,7]
 */
public class ArraySpiralOrder {
    public List<Integer> spiralOrder(int[][] matrix) {
        if (matrix.length == 0){
            return Collections.emptyList();
        }

        int m0 = 0 , n0 = 0 ;
        int m = matrix.length ;
        int n = matrix[0].length ;
        int length = m * n ;

        List<Integer> list = new ArrayList<>(m * n);
        int count = 0;
        int i = 0 , j = 0 ,flag = 0 ;
        list.add(matrix[i][j]);
        count++;
        while (count < length ){
            //(0,+1) --> (+1,0) --> (0,-1) --> (-1,0)
            switch ( flag % 4 ){
                case 0:
                    //(0,+1)
                    while( j + 1 < n ){
                        list.add(matrix[i][++j]);
                        count++;
                    }
                    m0++;
                    flag++;
                    break;
                case 1:
                    //(+1,0)
                    while( i + 1 < m ){
                        list.add(matrix[++i][j]);
                        count++;
                    }
                    n--;
                    flag++;
                    break;
                case 2:
                    //(0,-1)
                    while( j - 1 >= n0 ){
                        list.add(matrix[i][--j]);
                        count++;
                    }
                    m--;
                    flag++;
                    break;
                case 3:
                    //(-1,0)
                    while( i - 1 >= m0 ){
                        list.add(matrix[--i][j]);
                        count++;
                    }
                    n0++;
                    flag++;
                    break;
                default:
                    break;
            }

        }
        return list;
    }

    public static void main(String[] args) {
        int [][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        List<Integer> list = new ArraySpiralOrder().spiralOrder(matrix);
        for (int i:list) {
            System.out.print(i + " ");
        }
    }

}
