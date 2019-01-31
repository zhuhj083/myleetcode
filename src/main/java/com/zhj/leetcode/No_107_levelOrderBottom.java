package com.zhj.leetcode;

import java.util.*;

/**
 * 给定一个二叉树，返回其节点值自底向上的层次遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
 *
 * 例如：
 * 给定二叉树 [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回其自底向上的层次遍历为：
 *
 * [
 *   [15,7],
 *   [9,20],
 *   [3]
 * ]
 */
public class No_107_levelOrderBottom {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if (root == null)
            return Collections.emptyList();
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        TreeNode currentLast = root ;
        TreeNode nextLineLast = root;
        List<Integer> nList = new ArrayList<>();
        while(!queue.isEmpty()){
            TreeNode t = queue.poll();

            if (t != null ){
                nList.add(t.val);
            }

            if (t.left != null ){
                queue.add(t.left);
                nextLineLast = t.left;
            }

            if (t.right != null ){
                queue.add(t.right);
                nextLineLast = t.right;
            }

            if (currentLast == t ){
                currentLast = nextLineLast;
                result.add(0,nList);
                nList = new ArrayList<>();
            }
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(3);

        List<List<Integer>> list = new No_107_levelOrderBottom().levelOrderBottom(root);
        for (List<Integer> ls : list ){
            for (int i : ls ){
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

}
