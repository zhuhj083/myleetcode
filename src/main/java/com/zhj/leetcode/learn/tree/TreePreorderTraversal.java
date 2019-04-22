package com.zhj.leetcode.learn.tree;

import com.zhj.leetcode.base.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 给定一个二叉树，返回它的 前序 遍历。
 *
 *  示例:
 *
 * 输入: [1,null,2,3]
 *    1
 *     \
 *      2
 *     /
 *    3
 *
 * 输出: [1,2,3]
 *
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 */
public class TreePreorderTraversal {


    /**
     * 迭代算法
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode node = stack.pop();
            if (node != null){
                list.add( node.val );
                //先进后出，所以先压入right
                if (node.right != null){
                    stack.push(node.right );
                }
                if (node.left != null){
                    stack.push( node.left );
                }
            }
        }

        return list;
    }


    /**
     * 递归算法
     */
    public List<Integer> preorderTraversal2(TreeNode root) {
        List<Integer> list = new ArrayList<>();

        if (root != null){
            list.add(root.val);

            list.addAll(preorderTraversal2(root.left));
            list.addAll(preorderTraversal2(root.right));
        }

        return list;
    }

    public static void main(String[] args) {
        TreeNode  root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left =  new TreeNode(3);

        System.out.println(root);

        List<Integer> list = new TreePreorderTraversal().preorderTraversal(root);
        list.forEach(e -> System.out.println(e));
    }
}
