package com.zhj.leetcode;

import com.zhj.leetcode.base.TreeNode;

/**
 * 给定一个二叉树，找出其最小深度。
 *
 * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例:
 *
 * 给定二叉树 [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回它的最小深度  2.
 *
 */
public class No_111_minDepth {
    public int minDepth(TreeNode root){
        return minDepth(root,1);
    }

    public int minDepth(TreeNode root,int layer){
        if (root == null){
            return layer - 1 ;
        }
        if (root.left == null && root.right == null){
            return layer ;
        }

        int minLeft = -1;
        int minRight = -1 ;
        if (root.left != null){
            minLeft = minDepth(root.left,layer + 1);
        }
        if (root.right != null){
            minRight = minDepth(root.right,layer + 1);
        }

        if (minLeft * minRight < 0)
            return Math.abs( minLeft * minRight );

        return Math.min( minLeft , minRight );
    }
}
