package com.zhj.leetcode.learn.tree;

import com.zhj.leetcode.base.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 二叉树的序列化与反序列化
 *
 * 序列化是将一个数据结构或者对象转换为连续的比特位的操作，进而可以将转换后的数据存储在一个文件或者内存中，
 * 同时也可以通过网络传输到另一个计算机环境，采取相反方式重构得到原数据。
 *
 * 请设计一个算法来实现二叉树的序列化与反序列化。
 * 这里不限定你的序列 / 反序列化算法执行逻辑，你只需要保证一个二叉树可以被序列化为一个字符串并且将这个字符串反序列化为原始的树结构。
 *
 * 示例:
 *
 * 你可以将以下二叉树：
 *
 *     1
 *    / \
 *   2   3
 *      / \
 *     4   5
 *      \
 *      6
 * 序列化为 "[1,2,3,null,null,4,5,null,6]"
 * 说明: 不要使用类的成员 / 全局 / 静态变量来存储状态，你的序列化和反序列化算法应该是无状态的。
 *
 */
public class TreeCodec {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        if (root != null){
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            TreeNode last = root;
            TreeNode nlast = root;

            while(!queue.isEmpty()){
                TreeNode cur = queue.poll();
                if (cur == null && cur != last){
                    sb.append("#");
                }else{
                    sb.append(cur.val);

                    if (cur.left != null){
                        queue.offer(cur.left);
                        nlast = cur.left;
                    }else{
                        queue.offer(null);
                    }

                    if (cur.right != null){
                        queue.offer(cur.right);
                        nlast = cur.right;
                    }else{
                        queue.offer(null);
                    }

                    if (cur == last){
                        last = nlast;
                    }
                }

                if (!queue.isEmpty()){
                    sb.append(",");
                }
            }
        }
        return  sb.toString();
    }

    // Decodes your encoded data to tree.
    //1,2,3,#,#,4,5,#,6
    public TreeNode deserialize(String data) {
        TreeNode root = null;
        if (data != null && data.length() > 0){
            String [] strs = data.split(",");
            if (strs.length > 0 ){
                String str = strs[0] ;
                if (!"#".equals(str)){
                    root = new TreeNode(Integer.parseInt(str));
                    Queue<TreeNode> queue = new LinkedList<>();
                    queue.offer(root);
                    int index = 1 ;
                    int childCount = 0 ;
                    while (index < strs.length && !queue.isEmpty() ){
                        TreeNode parent = queue.element();

                        String tmp = strs[index] ;
                        TreeNode childNode  = null ;
                        if (!"#".equals(tmp)){
                            childNode = new TreeNode(Integer.parseInt(tmp));
                            queue.offer(childNode);
                        }

                        if (childCount == 0 ){
                            parent.left = childNode;
                            childCount++;
                        }else if (childCount == 1){
                            parent.right = childNode ;
                            childCount++;
                        }

                        if (childCount == 2 ){
                            queue.remove();
                            childCount = 0 ;
                        }
                        index++;
                    }
                }
            }
        }
        return  root;
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
//        TreeNode node2 = new TreeNode(2);
//        TreeNode node3 = new TreeNode(3);
//        TreeNode node4 = new TreeNode(4);
//        TreeNode node5 = new TreeNode(5);
//        TreeNode node6 = new TreeNode(6);
//        node1.right = node2;
//        node1.right = node3;
//        node3.left = node4;
//        node3.right = node5;
//        node4.right = node6;

        String data = new TreeCodec().serialize(node1);
        System.out.println(data);


        TreeNode root = new TreeCodec().deserialize(data);
        System.out.println(root);
    }

}
// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));