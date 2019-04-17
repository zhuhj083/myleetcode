package com.zhj.leetcode;

import com.zhj.leetcode.base.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径。
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
 *          /  \    / \
 *         7    2  5   1
 * 返回:
 *
 * [
 *    [5,4,11,2],
 *    [5,8,4,5]
 * ]
 */
public class No_113_pathSum {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if (root == null)
            return Collections.emptyList();
        List<List<Integer>> pathList = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        path.add(root.val);
        pathSum(root,sum,pathList,path);
        return pathList;
    }

    public void pathSum(TreeNode root, int sum,List<List<Integer>> pathList,List<Integer> list) {
        if (root == null)
            return ;

        //判断当前节点是不是叶子节点
        if (root.left == null && root.right == null ){
            if (root.val == sum) {
                pathList.add(list);
            }
        }

        if (root.left != null){
            List<Integer> left = new ArrayList<>();
            left.addAll(list);
            left.add(root.left.val);
            pathSum(root.left,sum-root.val,pathList,left);
        }

        if (root.right != null){
            List<Integer> right = new ArrayList<>();
            right.addAll(list);
            right.add(root.right.val);
            pathSum(root.right,sum-root.val,pathList,right);
        }
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

        root.right.right.left = new TreeNode(5);
        root.right.right.right = new TreeNode(1);

        List<List<Integer>> pathList = new No_113_pathSum().pathSum(root,22);
        for (List<Integer> path : pathList){
            for (int p : path){
                System.out.print(p + " ");
            }
            System.out.println();
        }

        System.out.println("----------------");

        TreeNode root2 = new TreeNode(1);
        List<List<Integer>> pathList2 = new No_113_pathSum().pathSum(root2,1);
        for (List<Integer> path : pathList2){
            for (int p : path){
                System.out.print(p + " ");
            }
            System.out.println();
        }
    }
}
