package com.zhj.leetcode.learn.list;

import com.zhj.leetcode.base.ListNode;

/**
 * 反转一个单链表。
 */
public class LinkedListReverseList {

    /**
     * 迭代实现
     */
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode newHead = head;
        ListNode cur = head.next;
        head.next = null ;
        ListNode tmp ;
        while(cur != null){
            tmp = cur;
            cur = cur.next ;
            tmp.next = newHead;
            newHead = tmp;
        }
        return newHead;
    }

    /**
     * 递归实现
     */
    public ListNode reverseList2(ListNode head) {
        if (head == null)
            return null;
        if (head.next == null)
            return head;

        //只有2个节点的反转
        if (head.next != null && head.next.next == null){
            ListNode newHead = head.next;
            head.next = null;
            newHead.next = head ;
            return newHead;
        }

        ListNode reverseHead = reverseList2(head.next);
        head.next.next = head;
        head.next = null;

        return reverseHead;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        System.out.println(new LinkedListReverseList().reverseList(node1));

    }
}
