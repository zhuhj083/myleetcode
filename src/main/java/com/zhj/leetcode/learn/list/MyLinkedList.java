package com.zhj.leetcode.learn.list;


/**
 * 设计链表
 *
 * 设计链表的实现。您可以选择使用单链表或双链表。
 * 单链表中的节点应该具有两个属性：val 和 next。val 是当前节点的值，next 是指向下一个节点的指针/引用。
 * 如果要使用双向链表，则还需要一个属性 prev 以指示链表中的上一个节点。假设链表中的所有节点都是 0-index 的。
 *
 * 在链表类中实现这些功能：
 * get(index)：获取链表中第 index 个节点的值。如果索引无效，则返回-1。
 * addAtHead(val)：在链表的第一个元素之前添加一个值为 val 的节点。插入后，新节点将成为链表的第一个节点。
 * addAtTail(val)：将值为 val 的节点追加到链表的最后一个元素。
 * addAtIndex(index,val)：在链表中的第 index 个节点之前添加值为 val  的节点。如果 index 等于链表的长度，则该节点将附加到链表的末尾。如果 index 大于链表长度，则不会插入节点。
 * deleteAtIndex(index)：如果索引 index 有效，则删除链表中的第 index 个节点。
 *
 * 提示：
 * 所有值都在 [1, 1000] 之内。
 * 操作次数将在  [1, 1000] 之内。
 * 请不要使用内置的 LinkedList 库。
 */
public class MyLinkedList {

    class Node{
        private int val;
        private Node next;

        public Node(){
        }

        public Node(int val){
            this.val = val;
        }
    }

    private Node head;
    private Node tail;
    private int size;

    /** Initialize your data structure here. */
    public MyLinkedList() {
        head = new Node();
        tail = new Node();
    }

    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        if(index < 0 || index > size - 1 ){
            return -1;
        }
        if (head != null && head.next != null){
            int i = 0 ;
            Node cur = head.next ;
            while (i != index){
                if (cur.next != null){
                    i++;
                    cur = cur.next ;
                }else{
                    return - 1;
                }
            }
            return cur.val ;
        }
        return -1;
    }

    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        Node node = new Node(val);
        if (head.next != null ){
            node.next = head.next;
            head.next = node;
        }else{
            //新插入空链表
            tail.next = node;
            head.next = node;
        }
        size++;
    }

    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        Node node = new Node(val);
        if (tail.next != null){
            tail.next.next = node;
            tail.next = node;
        }else{
            //新插入空链表
            tail.next = node;
            head.next = node;
        }
        size++;
    }

    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        if (index <= 0 ){
            addAtHead(val);
        }else{
            if (index == size){
                addAtTail(val);
            } else if (index < size){
                Node before = findBeforeIndex(index);
                if (before != null){
                    Node node = new Node(val);
                    node.next = before.next;
                    before.next = node;
                    size++;
                }
            }
        }

    }

    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        if (index < 0 || index > size - 1 ){
            return ;
        }else{
            Node before = findBeforeIndex(index);
            if (before != null && before.next != null){

                if (before.next == tail.next){
                    tail.next = before;
                }

                before.next = before.next.next;
                size--;
            }
        }
    }

    private Node findBeforeIndex(int index){
        Node  before ;
        if (index == 0 ){
            before = head;
        }else {
            int i = 1;
            before = head.next;
            while (i < index) {
                if (before.next != null) {
                    i++;
                    before = before.next;
                } else {
                    return null;
                }
            }
        }
        return before;
    }

    @Override
    public String toString() {
        Node cur = head.next;
        StringBuilder sb = new StringBuilder("linkedList:");
        while (cur != null){
            sb.append(cur.val + "->");
            cur = cur.next;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
//
//        ["MyLinkedList",,"addAtTail","addAtHead","addAtTail","addAtTail","addAtTail","addAtIndex","get",
//[[],,,[24],[15],[0],[13],[1],[6,33],[6],

        MyLinkedList linkedList = new MyLinkedList();

        linkedList.addAtHead(8);
        linkedList.addAtTail(81);

        linkedList.deleteAtIndex(2);

        linkedList.addAtHead(26);
        linkedList.deleteAtIndex(2);

        System.out.println("26->8:"+linkedList);

        linkedList.addAtTail(24);

        System.out.println(linkedList);

        linkedList.addAtHead(15);
        linkedList.addAtTail(0);
        linkedList.addAtTail(13);
        linkedList.addAtTail(1);

        System.out.println(linkedList);

        linkedList.addAtIndex(6,33);

        System.out.println(linkedList);
        System.out.println(linkedList.get(6));

    }
}
