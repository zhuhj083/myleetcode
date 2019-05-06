package com.zhj.leetcode.medium;

import com.zhj.leetcode.base.ListNode;

/**
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 *
 * 示例：
 *
 * 给定一个链表: 1->2->3->4->5, 和 n = 2.
 *
 * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
 * 说明：
 *
 * 给定的 n 保证是有效的。
 *
 * 进阶：
 *
 * 你能尝试使用一趟扫描实现吗？
 */
public class No_19_removeNthFromEnd {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode curr = head;
        ListNode tail = curr;
        while(curr != null){
            //向后移动n次，如果到达尾节点，则删除当前节点的下一个节点
            for (int i = 0; i < n ; i++) {
                tail = tail.next;
            }

            if (tail == null){
                //要删除的是头节点
                head = head.next;
                break;
            }else if (tail.next == null){
                //删除当前节点的下一个节点
                curr.next = curr.next.next;
                break;
            }
            curr = curr.next;
            tail = curr;
        }
        return head ;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        System.out.println(new No_19_removeNthFromEnd().removeNthFromEnd(head,5));

    }
}
