package com.zhj.leetcode.learn.list;

import com.zhj.leetcode.base.ListNode;

/**
 * 请判断一个链表是否为回文链表。
 *
 * 示例 1:
 *      输入: 1->2
 *      输出: false
 *
 * 示例 2:
 *      输入: 1->2->2->1
 *      输出: true
 *
 * 进阶：
 * 你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
 */
public class LinkedListIsPalindrome {

    /**
     *  思路：
     *      借鉴“判断链表是否有环”思想利用快慢指针法找到链表中点，
     *      然后一个将后半部分就地反转，
     *      分别再从头、中点遍历判断是否相等，该方法时间复杂度O(n)、空间复杂度O(1).
     */
    public boolean isPalindrome(ListNode head) {
        //1、找到链表中点,注意奇数个节点 和 偶数个节点不一样
        ListNode fast = head;
        ListNode slow = head;
        ListNode middle  ;
        while(fast != null && fast.next !=null){
            fast = fast.next.next;
            slow = slow.next;
        }
        middle = slow;

        //反转后半部分
        ListNode r = reverse(middle);

        //分别从头、中点遍历，判断是否相等
        ListNode p1  = head , p2 = r ;
        while(p1 != null && p2 != null){
            if (p1.val != p2.val ){
                return false;
            }
            p1 = p1.next;
            p2 = p2.next;
        }

        return true ;
    }

    public ListNode reverse(ListNode head){
        if (head == null || head.next == null){
            return head;
        }

        //至少有2个节点
        ListNode newHead = head;
        ListNode cur = head.next;
        head.next = null ;
        ListNode tmp ;
        while(cur != null){
            tmp = cur;
            cur = cur.next;
            tmp.next = newHead;
            newHead = tmp;
        }

        return newHead;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(2);
        ListNode node4 = new ListNode(1);
//        ListNode node5 = new ListNode(1);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
//        node4.next = node5;

        boolean isPalindrome =  new LinkedListIsPalindrome().isPalindrome(node1);
        System.out.println(isPalindrome);
    }
}
