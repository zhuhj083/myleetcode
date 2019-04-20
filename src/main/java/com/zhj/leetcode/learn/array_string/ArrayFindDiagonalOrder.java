package com.zhj.leetcode.learn.array_string;

import java.util.ArrayList;
import java.util.List;

/**
 * 对角线遍历
 *
 * 给定一个含有 M x N 个元素的矩阵（M 行，N 列），请以对角线遍历的顺序返回这个矩阵中的所有元素，对角线遍历如下图所示。
 *
 * 输入:
 * [
 *  [ 1, 2, 3 ],
 *  [ 4, 5, 6 ],
 *  [ 7, 8, 9 ]
 * ]
 *
 * 输出:  [1,2,4,7,5,3,6,8,9]
 */
public class ArrayFindDiagonalOrder {
    public int[] findDiagonalOrder(int[][] matrix) {

        if (matrix.length == 0 ){
            return new int[]{};
        }

        int m = matrix.length;
        int n = matrix[0].length;
        int length = m * n;

        int[] result = new int[ length ];
        int index = 0;

        int i = 0 , j = 0 ;
        int flag = 0 ;
        result[index++] = matrix[i][j];
        while( index < length){
            //(0,+1) --> (+1 ,-1) --> ç --> (-1,+1) --> (0,+1)
            switch ( flag % 4 ){
                case 0:
                    // (0,+1) or  (+1 ,0)
                    if (j + 1 < n && index < length){
                        result[index++] = matrix[i][++j];
                    }else if (i + 1 < m && index < length){
                        result[index++] = matrix[++i][j];
                    }
                    flag++;
                    break;
                case 1:
                    // (+1 ,-1)
                    while(i + 1  < m && j - 1 >= 0 && index < length){
                        result[index++] = matrix[++i][--j];
                    }
                    flag++;
                    break;
                case 2:
                    // (+1 ,0) or (0,+1)
                    if (i + 1 < m && index < length){
                        result[index++] = matrix[++i][j];
                    }else if (j + 1 < n && index < length){
                        result[index++] = matrix[i][++j];
                    }
                    flag++;
                    break;
                case 3:
                    // (-1,+1)
                    while( i - 1  >= 0  && j + 1 < n  && index < length ){
                        result[index++] = matrix[--i][++j];
                    }
                    flag++;
                    break;
                 default:
                     break;

            }
        }
        return result;
    }

    public static void main(String[] args) {
        int [][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        int [] result = new ArrayFindDiagonalOrder().findDiagonalOrder(matrix);
        for (int i:result) {
            System.out.print(i + " ");
        }
    }
}
