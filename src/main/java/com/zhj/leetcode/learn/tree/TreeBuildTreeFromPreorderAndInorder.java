package com.zhj.leetcode.learn.tree;

import com.zhj.leetcode.base.TreeNode;

/**
 * 根据一棵树的前序遍历与中序遍历构造二叉树。
 *
 * 注意:
 * 你可以假设树中没有重复的元素。
 *
 * 例如，给出
 *
 * 前序遍历 preorder = [3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 * 返回如下的二叉树：
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 */
public class TreeBuildTreeFromPreorderAndInorder {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length > 0 && preorder.length ==  preorder.length ){
            return buildTree(preorder,0,preorder.length - 1 , inorder,0,inorder.length - 1 );
        }
        return null;
    }

    public TreeNode buildTree(int[] preorder , int pl , int pr , int[] inorder , int il , int ir){
        if (pl <= pr && il <= ir ){
            //前序数组 第一个元素 就是根节点
            int rootVal = preorder[pl];
            TreeNode root = new TreeNode(rootVal);
            //中序数组 以rootVal 分为 2部分，分别是左子树，右子树
            int leftCount = 0 ;
            for (int i = il; i <= ir ; i++) {
                if (inorder[i] == rootVal){
                    break;
                }
                leftCount++ ;
            }

            if (leftCount > 0){
                //左子树
                root.left = buildTree(preorder,pl + 1 ,pl + leftCount ,  inorder , il ,il + leftCount - 1 );
            }
            if ( pr - pl - leftCount > 0 ){
                //右子树
                root.right = buildTree(preorder,pl + 1 + leftCount , pr , inorder,il + leftCount + 1 , ir);
            }

            return root;
        }
        return null;
    }

    public static void main(String[] args) {
        int[] inorder = {9,3,15,20,7};
        int[] preorder = {3,9,20,15,7};

        TreeNode root = new TreeBuildTreeFromPreorderAndInorder().buildTree(preorder,inorder);
        System.out.println(root);
    }
}
