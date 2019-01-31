package com.zhj.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
 *
 *
 *
 * 在杨辉三角中，每个数是它左上方和右上方的数的和。
 *
 * 示例:
 *
 * 输入: 5
 * 输出:
 * [
 *      [1],
 *     [1,1],
 *    [1,2,1],
 *   [1,3,3,1],
 *  [1,4,6,4,1]
 * ]
 */
public class No_118_generate {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        for (int row = 0 ; row < numRows ; row++) {
            // 第row行 ，有 row+1 个数
            int countRow = row + 1 ;

            //拿到前一行的数据
            List<Integer>  preRowList = null ;
            if (row > 0 && result != null && result.size() >= row ){
                preRowList  = result.get( row - 1  );
            }
            List<Integer> rowList = new ArrayList<>(countRow);
            for (int j = 0 ; j < countRow ; j++) {
                if (j == 0 || j == countRow - 1 ){
                    //第一个和最后一个都是1
                    rowList.add(1);
                }else{
                    if (preRowList != null){
                        rowList.add(preRowList.get(j-1) + preRowList.get(j));
                    }
                }
            }
            result.add(rowList);
        }
        return result;
    }

    public static void main(String[] args) {
        List<List<Integer>> list = new No_118_generate().generate(8);
        for (List<Integer> l : list){
            for (int i : l) {
                System.out.print(i+" ");
            }
            System.out.println();
        }
    }
}
