package com.zhj.leetcode.base;

/**
 * 二叉树的一个节点
 * @author zhuhj
 */
public class TreeNode {
     public int val;
     public TreeNode left;
     public TreeNode right;

     public TreeNode(int x) {
         val = x;
     }


     @Override
     public String toString() {
          return "TreeNode{" +
                  "val=" + val +
                  ", left=" + left +
                  ", right=" + right +
                  '}';
     }
}
