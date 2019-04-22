package com.zhj.leetcode.learn.tree;

import com.zhj.leetcode.base.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树的后序遍历
 * 给定一个二叉树，返回它的 后序 遍历。
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
 * 输出: [3,2,1]
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 */
public class TreePostorderTraversal {


    public List<Integer> postorderTraversalByIteration(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root != null){
            list.addAll(postorderTraversal(root.left));
            list.addAll(postorderTraversal(root.right));
            list.add(root.val);
        }
        return list;
    }

    /**
     * 递归实现
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root != null){
            list.addAll(postorderTraversal(root.left));
            list.addAll(postorderTraversal(root.right));
            list.add(root.val);
        }
        return list;
    }
}
