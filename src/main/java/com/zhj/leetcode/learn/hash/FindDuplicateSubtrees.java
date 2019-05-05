package com.zhj.leetcode.learn.hash;

import com.zhj.leetcode.base.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 寻找重复的子树
 *
 * 给定一棵二叉树，返回所有重复的子树。对于同一类的重复子树，你只需要返回其中任意一棵的根结点即可。
 * 两棵树重复是指它们具有相同的结构以及相同的结点值。
 *
 */
public class FindDuplicateSubtrees {

    /**
     * 采用子树的序列化表述 作为键
     */
    /**
     * 采用子树的序列化表述 作为键
     */
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        List<TreeNode> list = new ArrayList<>();
        Map<String,Integer> map = new HashMap<>();
        findDuplicateSubtrees(root,list,map);
        return list;
    }

    public String findDuplicateSubtrees(TreeNode node ,List<TreeNode> list, Map<String,Integer> map) {
        StringBuilder sb = new StringBuilder();
        if (node != null){
            sb.append(node.val);

            if(node.left != null || node.right != null){
                sb.append("(");

                if (node.left != null){
                    sb.append(findDuplicateSubtrees(node.left,list,map));
                }

                sb.append(",");

                if (node.right != null){
                    sb.append(findDuplicateSubtrees(node.right,list,map));
                }
                sb.append(")");
            }

            if (map.containsKey(sb.toString())){
                int count = map.get(sb.toString());
                if (count == 1){
                    list.add(node);
                }
                map.put(sb.toString(),count+1);
            }else{
                map.put(sb.toString(),1);
            }
        }
        return sb.toString();
    }
}