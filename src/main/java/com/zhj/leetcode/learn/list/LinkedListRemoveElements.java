package com.zhj.leetcode.learn.list;

import com.zhj.leetcode.base.ListNode;

/**
 *  删除链表中等于给定值 val 的所有节点。
 */
public class LinkedListRemoveElements {
    public ListNode removeElements(ListNode head, int val) {
        if (head == null ){
            return null;
        }


        //删除头节点中的给定值
        while ( head != null && head.val == val ){
            head = head.next;
        }

        //删除其他节点中的
        ListNode cur = head;
        while(cur != null &&  cur.next != null){
            if (cur.next.val == val){
                cur.next = cur.next.next;
            }else{
                cur = cur.next;
            }
        }

        return head;

    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
//        ListNode node2 = new ListNode(2);
//        ListNode node3 = new ListNode(2);
//        ListNode node4 = new ListNode(1);
//        node1.next = node2;
//        node2.next = node3;
//        node3.next = node4;

        System.out.println(new LinkedListRemoveElements().removeElements(node1,2));

    }
}
