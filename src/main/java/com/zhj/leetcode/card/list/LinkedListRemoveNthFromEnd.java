package com.zhj.leetcode.card.list;

import com.zhj.leetcode.base.ListNode;

/**
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 *
 * 示例：
 *  给定一个链表: 1->2->3->4->5, 和 n = 2.
 *  当删除了倒数第二个节点后，链表变为 1->2->3->5.
 *
 * 说明：给定的 n 保证是有效的。
 *
 * 进阶：
 *
 * 你能尝试使用一趟扫描实现吗？
 */
public class LinkedListRemoveNthFromEnd {

    /**
     * 上述算法可以优化为只使用一次遍历。
     * 我们可以使用两个指针而不是一个指针。
     * 第一个指针从列表的开头向前移动 n+1 步，
     * 而第二个指针将从列表的开头出发。
     * 现在，这两个指针被 n 个结点分开。
     * 我们通过同时移动两个指针向前来保持这个恒定的间隔，直到第一个指针到达最后一个结点。
     * 此时第二个指针将指向从最后一个结点数起的第 n 个结点。
     * 我们重新链接第二个指针所引用的结点的 next 指针指向该结点的下下个结点。
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode first = head ;
        ListNode second = head ;
        if (head != null ){
            for (int i = 0; i < n ; i++) {
                first = first.next;
            }

            //此刻，first和second之间隔着n个元素
            //first second 一起往后移
            if (first == null  ){
                //删除头节点
                head = head.next;
            }else{
                while(first.next != null){
                    first = first.next;
                    second = second.next;
                }
                //删除second的next
                second.next = second.next.next;
            }
            return head;
        }

        return null;
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

        System.out.println(new LinkedListRemoveNthFromEnd().removeNthFromEnd(node1,5));
    }
}
