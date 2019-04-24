package com.zhj.leetcode.learn.tree;

import com.zhj.leetcode.base.TreeNode;

/**
 * 从中序与后序遍历序列构造二叉树
 *
 * 根据一棵树的中序遍历与后序遍历构造二叉树。
 *
 * 注意:
 * 你可以假设树中没有重复的元素。
 *
 * 例如，给出
 * 中序遍历 inorder = [9,3,15,20,7]
 * 后序遍历 postorder = [9,15,7,20,3]
 *
 * 返回如下的二叉树：
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 */
public class TreeBuildTreeFromInorderAndPostorder {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder.length > 0 && postorder.length > 0 && inorder.length == postorder.length ){
            //后序遍历 最后一个元素是 根节点
            int rootVal = postorder[postorder.length - 1 ];
            TreeNode root = new TreeNode(rootVal);

            //查找根节点 在前序数组中的位置
            int rootIndexInInOrder = 0 ;
            for (int i = 0 ; i < inorder.length ; i++){
                if (inorder[i] == rootVal){
                    rootIndexInInOrder = i ;
                    break;
                }
            }

            //有左子树，构建左子树
            if (rootIndexInInOrder > 0 ){
                //左子树的个数
                int leftCount = rootIndexInInOrder;
                int[] leftInorder = new int[leftCount];
                for (int i = 0; i < leftCount ; i++) {
                    leftInorder[i] = inorder[i];
                }
                int[] leftPostorder = new int[leftCount];
                for (int i = 0; i < leftCount ; i++) {
                    leftPostorder[i] = postorder[i];
                }
                root.left = buildTree(leftInorder,leftPostorder);
            }

            //有右子树，构建右子树
            if (rootIndexInInOrder < inorder.length - 1){
                //右子树的个数
                int rightCount = inorder.length - 1 - rootIndexInInOrder ;
                int[] rightInorder = new int[rightCount];
                for (int i = 0; i < rightCount ; i++) {
                    rightInorder[i] = inorder[i + rootIndexInInOrder + 1];
                }
                int[] rightPostorder = new int[rightCount];
                for (int i = 0; i < rightCount ; i++) {
                    rightPostorder[i] = postorder[i + rootIndexInInOrder];
                }
                root.right = buildTree(rightInorder,rightPostorder);
            }

            return root;
        }
        return null;
    }

    public static void main(String[] args) {
        int[] inorder = {9,3,15,20,7};
        int[] postOrder = {9,15,7,20,3};

        TreeNode root = new TreeBuildTreeFromInorderAndPostorder().buildTree(inorder,postOrder);
        System.out.println(root);
    }


}
