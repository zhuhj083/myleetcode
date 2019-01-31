package com.zhj.leetcode;

import java.util.*;


/**
 * 给定一个二叉树，返回其节点值的锯齿形层次遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 *
 * 例如：
 * 给定二叉树 [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回锯齿形层次遍历如下：
 *
 * [
 *   [3],
 *   [20,9],
 *   [15,7]
 * ]
 */
public class No_103_zigzagLevelOrder {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null)
            return Collections.emptyList();

        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> odd = new LinkedList<>();
        Queue<TreeNode> even = new LinkedList<>();
        odd.add(root);
        while(!odd.isEmpty() || !even.isEmpty()){
            List<Integer> nList = new ArrayList<>();
            if (!odd.isEmpty()){
                while (!odd.isEmpty()) {
                    TreeNode node = odd.poll();
                    if (node != null){
                        nList.add(node.val);
                    }
                    if (node.left != null)
                        ((LinkedList<TreeNode>) even).addFirst(node.left);
                    if (node.right != null)
                        ((LinkedList<TreeNode>) even).addFirst(node.right);
                }
            }else{
                while (!even.isEmpty()) {
                    TreeNode node = even.poll();
                    if (node != null){
                        nList.add(node.val);
                    }
                    if (node.right != null)
                        ((LinkedList<TreeNode>) odd).addFirst(node.right);
                    if (node.left != null)
                        ((LinkedList<TreeNode>) odd).addFirst(node.left);
                }
            }
            result.add(nList);
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);

        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

//        root.right.left.left = new TreeNode(1);
//        root.right.left.right = new TreeNode(2);

        List<List<Integer>> list = new No_103_zigzagLevelOrder().zigzagLevelOrder(root);
        for (List<Integer> ls : list ){
            for (int i : ls ){
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
