package com.zhj.leetcode.card.list;

import com.zhj.leetcode.base.ListNode;

/**
 * 给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null
 *
 * 如果假设整个链表的长度是L，环的长度为r
 * 入口和相遇点的距离是x，起点到入口点的距离是a，
 *
 * fast每次走2步，slow每次都1步
 * 当fast和slow相遇时，slow还没有走完链表，假设fast已经在环内循环了1圈
 * 假设slow走了s步，则fast走了2s步
 * fast走过的步数 = s + r（s + 在环上多走的1圈），则有下面的等式
 * 2s = s + r  -->  s = r
 *
 * 则有：
 * a + x  = r -- > a = r - x
 * r = L - a
 *
 * a = (L - a - x)    --> L - a - x 是相遇点到入口的距离
 *
 * 从链表起点head开始到入口点的距离a,与从slow和fast的相遇点到入口点的距离相等。
 * 因此我们就可以分别用一个指针（ptr1, prt2），
 * 同时从head与slow和fast的相遇点出发，每一次操作走一步，直到ptr1 == ptr2，此时的位置也就是入口点！
 *
 */
public class LinkedListdDetectCycle {
    public ListNode detectCycle(ListNode head) {
        // 1、找到相遇点
        if(head != null){
            ListNode fast = head;
            ListNode slow = head;
            ListNode meet = null ;
            while(fast != null && fast.next != null){
                fast = fast.next.next;
                slow = slow.next;
                if (fast == slow){
                    meet = fast ;
                    break;
                }
            }

            // 2、同时从head与slow和fast的相遇点出发，每一次操作走一步，fromHead == fromMeet，此时的位置也就是入口点
            if (meet != null ){
                ListNode fromHead = head;
                ListNode fromMeet = meet;
                while (true){
                    if (fromHead == fromMeet){
                        return fromHead;
                    }
                    fromHead = fromHead.next;
                    fromMeet = fromMeet.next;
                }
            }
        }
        return null;
    }

    public static void main(String[] args) {

        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);

        node1.next = node2;
        node2.next = node1;
//        node3.next = node4;
//        node4.next = node2;

        System.out.println(new LinkedListdDetectCycle().detectCycle(node1));

    }
}
