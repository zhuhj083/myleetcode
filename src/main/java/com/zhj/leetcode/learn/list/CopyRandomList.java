package com.zhj.leetcode.learn.list;

import java.util.HashMap;
import java.util.Map;

/**
 * 复制带随机指针的链表
 * 给定一个链表，每个节点包含一个额外增加的随机指针，该指针可以指向链表中的任何节点或空节点。
 *
 * 要求返回这个链表的深拷贝。
 *
 * 示例：
 * 输入：
 * {"$id":"1","next":{"$id":"2","next":null,"random":{"$ref":"2"},"val":2},"random":{"$ref":"2"},"val":1}
 *
 * 解释：
 * 节点 1 的值是 1，它的下一个指针和随机指针都指向节点 2 。
 * 节点 2 的值是 2，它的下一个指针指向 null，随机指针指向它自己。
 *
 * 提示：
 * 你必须返回给定头的拷贝作为对克隆列表的引用。
 */
public class CopyRandomList {
    private Node copyNode(Map<Node,Node> visited , Node node){
        Node copyNode = null;
        if (node != null ){
            if (visited.containsKey(node)){
                copyNode = visited.get(node);
            }else{
                copyNode = new Node();
                copyNode.val = node.val;

                visited.put(node,copyNode);
            }

            Node random = node.random;
            Node copyRandom = null;
            if (random != null ){
                if (visited.containsKey(random)){
                    copyRandom = visited.get(random);
                }else {
                    copyRandom = new Node();
                    copyRandom.val = random.val;

                    visited.put(random,copyRandom);
                }
            }
            copyNode.random = copyRandom;
        }

        return copyNode;
    }

    public Node copyRandomList(Node head) {

        Map<Node,Node> visited = new HashMap<>();

        Node copyHead = copyNode(visited,head);
        Node cur = head;
        Node copyCur = copyHead ;
        while (cur != null && cur.next != null ){
            cur = cur.next;
            Node copyCurNode = copyNode(visited,cur);

            copyCur.next = copyCurNode ;
            copyCur = copyCur.next;

        }
        return copyHead;
    }
}

// Definition for a Node.
class Node {
    public int val;
    public Node next;
    public Node random;

    public Node() {
    }

    public Node(int _val, Node _next, Node _random) {
        val = _val;
        next = _next;
        random = _random;
    }
}
