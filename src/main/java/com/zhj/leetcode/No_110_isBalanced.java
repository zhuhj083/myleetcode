package com.zhj.leetcode;

import com.zhj.leetcode.structure.TreeNode;

/**
 * 给定一个二叉树，判断它是否是高度平衡的二叉树。
 *
 * 本题中，一棵高度平衡二叉树定义为：
 *
 * 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过1。
 *
 * 示例 1:
 *
 * 给定二叉树 [3,9,20,null,null,15,7]
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回 true 。
 *
 *
 * 示例 2:
 *
 * 给定二叉树 [1,2,2,3,3,null,null,4,4]
 *
 *        1
 *       / \
 *      2   2
 *     / \
 *    3   3
 *   / \
 *  4   4
 * 返回 false 。
 */

public class No_110_isBalanced {
    public boolean isBalanced(TreeNode root) {
        if (root == null)
            return true;
        int depthLeft = maxDepth(root.left);
        int depthRight = maxDepth(root.right);
        return Math.abs(depthLeft - depthRight) <= 1 && isBalanced(root.left) && isBalanced(root.right) ;
    }

    public int maxDepth(TreeNode root) {
        if (root == null)
            return 0 ;
        return 1 + Math.max(maxDepth(root.left ),maxDepth(root.right) );
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);

        root.right.left = new TreeNode(15);
        root.right.left = new TreeNode(7);

        System.out.println(new No_110_isBalanced().isBalanced(root));
    }
}
