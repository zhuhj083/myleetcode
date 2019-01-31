package com.zhj.leetcode;

/**
 * 将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。
 *
 * 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
 *
 * 示例:
 *
 * 给定有序数组: [-10,-3,0,5,9],
 *
 * 一个可能的答案是：[0,-3,9,-10,null,5]，它可以表示下面这个高度平衡二叉搜索树：
 *
 *       0
 *      / \
 *    -3   9
 *    /   /
 *  -10  5
 */
public class No_108_sortedArrayToBST {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0){
            return null;
        }
        return sortedArrayToBST(nums,0,nums.length-1);
    }

    public TreeNode sortedArrayToBST(int[] nums , int start , int end){
        int middle = (end + start ) / 2 ;
        TreeNode root = new TreeNode(nums[middle]);
        if (middle - 1 >= start ){
            root.left = sortedArrayToBST(nums,start,middle - 1);
        }
        if (middle + 1 <= end ){
            root.right = sortedArrayToBST(nums,middle + 1 , end);
        }
        return root;
    }

    public static void main(String[] args) {
        int[] nums = {-10,-3,0,5,9};
        TreeNode root = new No_108_sortedArrayToBST().sortedArrayToBST(nums);
        System.out.println(root);
    }
}
