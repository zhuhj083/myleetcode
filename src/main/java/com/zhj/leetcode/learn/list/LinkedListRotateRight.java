package com.zhj.leetcode.learn.list;

import com.zhj.leetcode.base.ListNode;

/**
 * 旋转链表
 * 给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。
 *
 * 示例 1:
 * 输入: 1->2->3->4->5->NULL, k = 2
 * 输出: 4->5->1->2->3->NULL
 * 解释:
 * 向右旋转 1 步: 5->1->2->3->4->NULL
 * 向右旋转 2 步: 4->5->1->2->3->NULL
 *
 * 示例 2:
 * 输入: 0->1->2->NULL, k = 4
 * 输出: 2->0->1->NULL
 * 解释:
 * 向右旋转 1 步: 2->0->1->NULL
 * 向右旋转 2 步: 1->2->0->NULL
 * 向右旋转 3 步: 0->1->2->NULL
 * 向右旋转 4 步: 2->0->1->NULL
 */
public class LinkedListRotateRight {

    public ListNode rotateRight(ListNode head, int k) {
        // 先遍历一遍
        int count = 0 ;
        ListNode cur = head ;
        while (cur != null){
            count++;
            cur = cur.next;
        }

        if ( count == 0 || (count != 0 &&   k % count == 0 ) ){
            return head;
        }

        //向右旋转k 等价于向左旋转 count - k % count
        if (k > 0 && count > 0 ){
            int left = count - k %  count ;

            ListNode newTail = head;
            int j = 1;
            while (left > 0 && j < left ){
                newTail = newTail.next;
                j++;
            }

            ListNode newHead = newTail.next;
            ListNode next = newHead;

            while (next.next != null){
                next = next.next;
            }
            next.next = head;
            newTail.next = null;

            return newHead;
        }
        return null;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
//        ListNode node3 = new ListNode(3);
//        ListNode node4 = new ListNode(4);
//        ListNode node5 = new ListNode(5);
        node1.next = node2;
//        node2.next = node3;
//        node3.next = node4;
//        node4.next = node5;

        System.out.println(new LinkedListRotateRight().rotateRight(node1,1));
    }
}
