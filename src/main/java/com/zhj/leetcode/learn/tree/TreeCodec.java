package com.zhj.leetcode.learn.tree;

import com.sun.tools.javac.util.StringUtils;
import com.zhj.leetcode.base.TreeNode;

import java.util.*;

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
 *
 * 序列化为 "[1,2,3,null,null,4,5]"
 * 说明: 不要使用类的成员 / 全局 / 静态变量来存储状态，你的序列化和反序列化算法应该是无状态的。
 *
 */
public class TreeCodec {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null){
            return "";
        }

        //先按层遍历
        StringBuilder sb = new StringBuilder();

        int maxIndex = 0 ;
        Map<TreeNode,Integer> nodeIndexmap = new HashMap<>();
        Map<Integer,TreeNode> indexNodeMap = new HashMap<>();

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        TreeNode last = root;
        TreeNode nLast = root;
        nodeIndexmap.put(root,0 );
        indexNodeMap.put(0,root );
        while (!queue.isEmpty()){
            TreeNode node = queue.poll();

            int i = nodeIndexmap.get(node);

            if (node.left != null){
                nLast = node.left;
                queue.offer(node.left);
                maxIndex = 2 * i + 1;
            }
            nodeIndexmap.put(node.left , 2 * i + 1);
            indexNodeMap.put(2*i+1,node.left);

            if (node.right != null){
                nLast = node.right;
                queue.offer(node.right);
                maxIndex = 2 * i + 2 ;
            }
            nodeIndexmap.put( node.right , 2 * i + 2 );
            indexNodeMap.put(2*i+2,node.right);

            //到达这一行的最后一个节点
            if (node == last){
                last = nLast ;
            }
        }

        for (int i = 0 ; i <= maxIndex ; i ++){
            if (indexNodeMap.containsKey(i)){
                TreeNode node = indexNodeMap.get(i);
                if (node != null){
                    sb.append(node.val);
                }else{
                    sb.append("#");
                }
                if (i != maxIndex){
                    sb.append(",");
                }
            }
        }

        return  sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        TreeNode root = null ;
        if (data != null && ! "".equals(data) ){
            String[] strs = data.split(",");

            Map<Integer,TreeNode> indexNodeMap = new HashMap<>();
            Map<TreeNode,Integer> nodeIndexMap = new HashMap<>();

            if (strs.length > 0 ){
                String s = strs[0];
                if (!"#".equals(s) && !"".equals(s)){
                    root = new TreeNode(Integer.parseInt(s));
                    indexNodeMap.put(0,root);
                    nodeIndexMap.put(root,0);
                }
                if (strs.length > 1){
                    for (int i = 1 ; i < strs.length ; i++) {
                        // i节点 的两个子节点分别为  2i + 1 和 2i + 2
                        // i节点的父节点为  (i-1) / 2 ;
                        String str = strs[i];
                        if (!"#".equals(str) && !"".equals(str)){
                            TreeNode node = new TreeNode(Integer.parseInt(str));
                            indexNodeMap.put(i,node);
                            nodeIndexMap.put(node,i);

                            int parentIndex = (i - 1) / 2;


                            TreeNode parent = indexNodeMap.get(parentIndex);
                            if (parent != null ){
                                boolean isLeft = (i - 1) % 2 == 0 ;
                                if (isLeft){
                                    parent.left = node ;
                                }else{
                                    parent.right = node ;
                                }
                            }else{
                                return null;
                            }
                        }
                    }
                }
            }
        }
        return root ;
    }

}
// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));