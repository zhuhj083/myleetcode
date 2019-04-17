package com.zhj.leetcode.card.list;

import com.zhj.leetcode.base.ListNode;

/**
 * 编写一个程序，找到两个单链表相交的起始节点。
 *
 * 如果两个链表没有交点，返回 null.
 * 在返回结果后，两个链表仍须保持原有的结构。
 * 可假定整个链表结构中没有循环。
 * 程序尽量满足 O(n) 时间复杂度，且仅用 O(1) 内存。
 */
public class LinkedListGetIntersectionNode {


    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        if (headA == null || headB == null){
            return null;
        }

        /**
         定义两个指针, 第一轮让两个到达末尾的节点指向另一个链表的头部, 最后如果相遇则为交点(在第一轮移动中恰好抹除了长度差)
         两个指针等于移动了相同的距离, 有交点就返回, 无交点就是各走了两条指针的长度
         **/
        ListNode fromA = headA;
        ListNode fromB = headB;

        // 在这里第一轮体现在pA和pB第一次到达尾部会移向另一链表的表头, 而第二轮体现在如果pA或pB相交就返回交点, 不相交最后就是null==null
        while(fromA != fromB){
            fromA = fromA == null ? headB : fromA.next;
            fromB = fromB == null ? headA : fromB.next;
        }
        return fromA ;
    }

    /**
     * 将A链表的尾 指向B链表的头
     * 则该问题转为 给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null
     *
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null){
            return null;
        }

        ListNode tailA = new ListNode(Integer.MIN_VALUE) ;

        //1.判断链表是否有环

        ListNode meet = null ;

        ListNode fast = headA;
        ListNode slow = headA;
        while(fast != null ){

            //到达链表A的尾部
            if ( fast.next == null ){
                if (tailA.next == null){
                    tailA.next = fast ;
                    tailA.next.next = headB ;
                }else{
                    break;
                }
            }else if (fast.next.next == null){
                if (tailA.next == null){
                    tailA.next = fast.next ;
                    tailA.next.next = headB ;
                }
            }

            if ( fast.next != null ){
                fast = fast.next.next;
                slow = slow.next;
                if (fast == slow){
                    meet = fast ;
                    break;
                }
            }
        }

        //2.找到交接点
        if (meet != null ){
            ListNode fromHead = headA;
            ListNode fromMeet = meet;
            while (true){
                if (fromHead == fromMeet){

                    //3.恢复链表
                    tailA.next.next = null ;
                    tailA.next = null;

                    return fromHead;
                }
                fromHead = fromHead.next;
                fromMeet = fromMeet.next;
            }
        }


        //3.恢复链表
        tailA.next.next = null ;
        tailA.next = null;

        return null ;

    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);

        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);


        ListNode node6 = new ListNode(6);
        ListNode node7 = new ListNode(7);
        ListNode node8 = new ListNode(8);


        node1.next = node2;
        node2.next = node3;
        node3.next = node6;


        node4.next = node5;
        node5.next = node6;

        node6.next = node7;
        node7.next = node8;

        System.out.println(new LinkedListGetIntersectionNode().getIntersectionNode2(node1,node4));


    }
}
