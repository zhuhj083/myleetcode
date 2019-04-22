package com.zhj.leetcode.learn.tree;

import com.zhj.leetcode.base.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 中序遍历二叉树
 * 给定一个二叉树，返回它的中序 遍历。
 *
 * 示例:
 *
 * 输入: [1,null,2,3]
 *    1
 *     \
 *      2
 *     /
 *    3
 *
 * 输出: [1,3,2]
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 *
 */
public class TreeeInorderTraversal {
    /**
     * 递归实现中序遍历
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root != null){
            list.addAll(inorderTraversal(root.left));
            list.add(root.val);
            list.addAll(inorderTraversal(root.right));
        }
        return list;
    }

    public static void main(String[] args) {
        TreeNode  root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left =  new TreeNode(3);

        System.out.println(root);

        List<Integer> list = new TreeeInorderTraversal().inorderTraversal(root);
        list.forEach(e -> System.out.println(e));
    }
}
