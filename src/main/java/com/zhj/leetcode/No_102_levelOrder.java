package com.zhj.leetcode;

/**
 * 102. 二叉树的层次遍历
 */

import com.zhj.leetcode.base.TreeNode;

import java.util.*;

/**
 * 给定一个二叉树，返回其按层次遍历的节点值。 （即逐层地，从左到右访问所有节点）。
 *
 * 例如:
 * 给定二叉树: [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回其层次遍历结果：
 *
 * [
 *   [3],
 *   [9,20],
 *   [15,7]
 * ]
 */

public class No_102_levelOrder {
    public List<List<Integer>> levelOrder(TreeNode root) {
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
                result.add(nList);
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

        List<List<Integer>> list = new No_102_levelOrder().levelOrder(root);
        for (List<Integer> ls : list ){
            for (int i : ls ){
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
