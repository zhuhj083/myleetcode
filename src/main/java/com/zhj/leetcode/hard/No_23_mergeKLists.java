package com.zhj.leetcode.hard;

/**
 * 合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。
 *
 * 示例:
 *
 * 输入:
 * [
 *   1->4->5,
 *   1->3->4,
 *   2->6
 * ]
 * 输出: 1->1->2->3->4->4->5->6
 *
 */

import com.zhj.leetcode.base.ListNode;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

public class No_23_mergeKLists {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l2 == null) return l1;
        if (l1 == null) return l2;

        ListNode head = new ListNode(0);
        ListNode cur = head;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                cur.next = l1;
                cur = cur.next;
                l1 = l1.next;
            } else {
                cur.next = l2;
                cur = cur.next;
                l2 = l2.next;
            }
        }
        // 任一为空，直接连接另一条链表
        if (l1 == null) {
            cur.next = l2;
        } else {
            cur.next = l1;
        }

        return head.next;
    }

    public ListNode mergeKLists(ListNode[] lists) {

        if (lists == null || lists.length < 1){
            return null;
        }

        if (lists.length == 1){
            return lists[0];
        }

        if (lists.length == 2){
            return mergeTwoLists(lists[0],lists[1]);
        }

        int mid = lists.length / 2 ;

        ListNode[] list1 = new ListNode[mid];
        ListNode[] list2 = new ListNode[lists.length - mid];
        for (int i = 0; i < lists.length; i++) {
            if (i < mid )
                list1[i] = lists[i];
            else
                list2[i - mid] = lists[i];
        }

        return mergeTwoLists(mergeKLists(list1),mergeKLists(list2));
    }
}
