package com.zhj.leetcode.learn.tree;

import com.zhj.leetcode.base.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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
public class TreeLevelOrder {

    /**
     * 增加两个TreeNode：last和nlast
     * last：表示当前遍历层最右结点
     * nlast：表示下一层最右结点
     *
     * 遍历时，每次将nlast指向插入队列元素，最后一个插入结点时即最右结点。
     * 插入左右孩子之后，检测last是否为当前输出结点，
     * 若是，则表示需要进行换行，并将last指向下一层的nlast。
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();

        if (root != null){
            TreeNode last = root;
            TreeNode nLast = root;
            List<Integer> nList = new ArrayList<>();

            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);

            while (!queue.isEmpty()){
                TreeNode node = queue.poll();

                nList.add(node.val);

                if (node.left != null ){
                    nLast = node.left;
                    queue.offer(node.left);
                }

                if (node.right != null ){
                    nLast = node.right;
                    queue.offer(node.right);
                }

                //到达这一层的最右边
                if (node == last){
                    last = nLast ;
                    list.add(nList);
                    nList = new ArrayList<>();
                }
            }

        }

        return list;
    }
}
