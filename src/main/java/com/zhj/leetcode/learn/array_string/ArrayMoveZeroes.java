package com.zhj.leetcode.learn.array_string;

/**
 * 移动零
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 *
 * 示例:
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * 说明:
 *
 * 必须在原数组上操作，不能拷贝额外的数组。
 * 尽量减少操作次数。
 */
public class ArrayMoveZeroes {
    public void moveZeroes(int[] nums) {
        if (nums.length > 0 ){
            int index0 = 0;
            int indexNot0 = 0 ;

            while (index0 < nums.length && indexNot0 < nums.length){

                while (index0 < nums.length && nums[index0] != 0 ){
                    index0 ++;
                }

                indexNot0 = index0;
                while ( indexNot0 < nums.length &&  nums[indexNot0] == 0 ){
                    indexNot0++;
                }

                if (index0 < nums.length && indexNot0 < nums.length){
                    //交换
                    int temp = nums[indexNot0];
                    nums[indexNot0] = nums[index0];
                    nums[index0] = temp ;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {0,1,0,3,12};
        new ArrayMoveZeroes().moveZeroes(nums);

        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
    }
}
