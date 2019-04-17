package com.zhj.leetcode.card.list;

import com.zhj.leetcode.base.ListNode;

/**
 * 给定一个链表，判断链表中是否有环。
 * 一个安全的选择是每次移动慢指针一步，而移动快指针两步。
 * 每一次迭代，快速指针将额外移动一步。如果环的长度为 M，经过 M 次迭代后，快指针肯定会多绕环一周，并赶上慢指针。
 */
public class LinkedListHasCycle {

    public boolean hasCycle(ListNode head) {
        if (head != null ){
            ListNode fast = head;
            ListNode slow = head;

            while (fast != null && fast.next != null){
                fast = fast.next.next;
                slow = slow.next;

                if (fast == slow ){
                    return true;
                }
            }
        }
        return false ;
    }
}
