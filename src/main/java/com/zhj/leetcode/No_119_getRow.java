package com.zhj.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个非负索引 k，其中 k ≤ 33，返回杨辉三角的第 k 行。
 *
 *
 *
 * 在杨辉三角中，每个数是它左上方和右上方的数的和。
 *
 * 示例:
 *
 * 输入: 3
 * 输出: [1,3,3,1]
 *
 * 输入: 4
 * 输出: [1,4,6,4,1]
 *
 * 进阶：
 * 你可以优化你的算法到 O(k) 空间复杂度吗？
 *
 *
 * 0 --> 1
 * 1 --> 1 1
 * 2 --> 1 2 1
 * 3 --> 1 3 3  1
 * 4 --> 1 4 6  4  1
 * 5 --> 1 5 10 10 5  1
 * 6 --> 1 6 15 20 15 6  1
 * 7 --> 1 7 21 35 35 21 7 1
 */
public class No_119_getRow {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> result = new ArrayList<>(rowIndex);
        if (rowIndex == 0){
            result.add(1);
        }else if (rowIndex > 0 ){
            for (int row = 0 ; row < rowIndex ; row++) {
                // 第row行 ，有 row+1 个数
                int countRow = row + 1 ;
                for (int j = countRow / 2 ; j >= 0  ; j--) {
                    int val;
                    if (j == 0 ){
                        //第一个元素
                        val = 1 ;
                        if (result.size() > 0 ){
                            result.set(0,val);
                        }else{
                            result.add(0,val);
                        }
                    }else{
                        if (result.size() > j ){
                            val = result.get(j) + result.get(j-1);
                            result.set(j,val);
                        }else{
                            val = 1;
                        }
                    }

                    //如果是偶数个 且不是中间的那个元素
                    if ( j != countRow - j){
                        if (result.size() > countRow  - j)
                            result.set(countRow  - j , val);
                        else
                            result.add(countRow - j , val);
                    }
                }
            }
        }

        return result;
    }



    public static void main(String[] args) {
        List<Integer> list =  new No_119_getRow().getRow(6);
        for (int i : list)
            System.out.print(i + " ");
    }
}
