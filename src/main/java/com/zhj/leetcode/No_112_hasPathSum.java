package com.zhj.leetcode;

import com.zhj.leetcode.structure.TreeNode;

/**
 *  给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例:
 * 给定如下二叉树，以及目标和 sum = 22，
 *
 *               5
 *              / \
 *             4   8
 *            /   / \
 *           11  13  4
 *          /  \      \
 *         7    2      1
 * 返回 true, 因为存在目标和为 22 的根节点到叶子节点的路径 5->4->11->2。
 */

public class No_112_hasPathSum {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null)
            return false;

        if (root.left == null && root.right == null ){
            return root.val == sum ;
        }

        boolean hasLeft ;
        boolean hasRight ;
        if (root.left != null){
            hasLeft = hasPathSum(root.left,sum-root.val);
            if (hasLeft)
                return true;

        }
        if (root.right != null){
            hasRight = hasPathSum(root.right,sum-root.val);
            if (hasRight)
                return true;
        }

        return false ;
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);

        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);

        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);

        root.right.right.right = new TreeNode(1);

        System.out.println(new No_112_hasPathSum().hasPathSum(root,22));
    }
}
