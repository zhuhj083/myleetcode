package com.zhj.leetcode.learn.tree;


import java.util.LinkedList;
import java.util.Queue;

/**
 * 填充每个节点的下一个右侧节点指针
 *
 * 给定一个完美二叉树，其所有叶子节点都在同一层，每个父节点都有两个子节点。二叉树定义如下：
 *
 * struct Node {
 *   int val;
 *   Node *left;
 *   Node *right;
 *   Node *next;
 * }
 * 填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。
 *
 * 初始状态下，所有 next 指针都被设置为 NULL。
 *
 * 提示：
 *
 * 你只能使用常量级额外空间。
 * 使用递归解题也符合要求，本题中递归程序占用的栈空间不算做额外的空间复杂度。
 *
 */

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val,Node _left,Node _right,Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }

    @Override
    public String toString() {
        return "Node{" +
                "val=" + val +
                ", left=" + left +
                ", right=" + right +
                ", next=" + next +
                '}';
    }
};

public class TreeConnect {

    public Node connect(Node root) {
        if (root != null){
            Queue<Node> queue = new LinkedList();

            queue.offer(root);
            Node last = root;
            Node nlast = root;

            Node pre = null ;
            while (!queue.isEmpty()){
                Node cur = queue.poll();

                if (pre !=null ){
                    pre.next = cur;
                }
                pre = cur ;

                if (cur.left != null){
                    queue.offer(cur.left);
                    nlast = cur.left;
                }

                if (cur.right != null ){
                    queue.offer(cur.right);
                    nlast = cur.right;
                }

                if (cur == last){
                    last = nlast;
                    //换行
                    pre = null;
                }
            }
        }
        return root ;
    }



    public static void main(String[] args) {
        Node root = new Node();
        root.val = 1;

        Node left = new Node();
        left.val = 2;

        Node right = new Node();
        right.val = 3;

        root.left = left;
        root.right = right;

        System.out.println(new TreeConnect().connect(root));

    }
}


