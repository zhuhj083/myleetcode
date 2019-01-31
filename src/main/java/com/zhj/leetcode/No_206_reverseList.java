package com.zhj.leetcode;


/**
 * 反转一个单链表。
 *
 * 示例:
 *
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 * 进阶:
 * 你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
 *
 */
public class No_206_reverseList {

    public ListNode reverseList(ListNode head) {
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

        ListNode reverseHead = reverseList(head.next);
        head.next.next = head;
        head.next = null;

        return reverseHead;
    }

    public ListNode reverseList2(ListNode head) {
        if (head == null)
            return null;

        if (head.next == null)
            return head;

        ListNode current = head ;


        return null;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        System.out.println(head);
        System.out.println(new No_206_reverseList().reverseList2(head));

    }
}
