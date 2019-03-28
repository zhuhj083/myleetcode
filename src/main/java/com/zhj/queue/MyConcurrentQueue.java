package com.zhj.queue;


/**
 * 使用一个单向链表来实现队列（Queue）结构，在多环境下，多个线程同时对这个队列添加元素和取出元素
 * 需要考虑采用锁的机制来进行同步，防止链表结构被破坏
 *
 * 简单的做法是：
 *     不管读取还是写入的时候都使用同一把锁来进行互斥，但是这样的方式比较低效
 *
 * 可以采用的是：
 *     采用头部锁和尾部锁的方式来分别对添加元素和取出元素进行互斥
 *     在多线程的环境中可以并行实现同时添加和取出操作（同时添加或者是同时取出必须要互斥）
 *     来达到队列数据高效读取的简单算法。
 */

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 这个类实现了一个简单的带两个同步锁的单向队列
 *
 * 头部锁（只对headNode节点的读取进行互斥）
 * 尾部锁（只对tailNode节点的读取进行互斥）
 *
 * 头部锁和尾部锁分别对poll和offer进行互斥，从而可以让offer和poll同时并行进行，大幅度提高存储效率
 *
 * 一般情况：当队列为空的时候，加入offer第一个元素和poll第一个元素的处理，
 * 会发生头部锁和尾部锁发生冲突而导致比较难处理的情况，
 * 而本实现通过在初始化队列里添加一个不起实际作用的哨兵节点来保证
 * 队列的任何时候都不会出现空的情况，从而避免了头部锁和尾部锁出现冲突的问题。
 * 也就是说这个队列里任何时候都至少有一个哨兵节点的存在。
 */
public class MyConcurrentQueue<E> {

    //头部锁用来互斥多个poll的线程
    private Lock headLock = new ReentrantLock();

    // 尾部锁用来互斥多个offer的线程
    private Lock tailLock = new ReentrantLock();

    // 指向头部节点的引用
    private Node<E> headNode;

    // 指向尾部节点的引用
    private Node<E> tailNode;

    public MyConcurrentQueue() {
        // 初始化时生成一个哨兵节点，让头和尾的引用都指向这个哨兵节点
        Node<E> sentinelNode = new Node<E>(null);
        headNode = sentinelNode;
        tailNode = sentinelNode;
    }

    //放一个元素到队列的尾端
    public boolean offer(E e){
        if (e == null)
            return false;

        //【注意3】这里生成节点的时候直接将值赋到了节点里
        Node<E> newNode = new Node<>(e);
        tailLock.lock();
        try {
            // 【注意1】
            // 此处在队列为空（只有哨兵节点）的情况下与【注意2】的处理会发生冲突
            // 冲突内容是此处要把哨兵节点的next设为新追加出来的节点
            // 而【注意2】的处理要取出哨兵节点的next节点
            // 好在冲突的处理都是单次的内存读与写，实际上在CPU层面是原子操作，所以不会破坏链表的结构。
            // 最后，如果【注意1】的线程先执行【注意2】的线程后执行的话，
            // 【注意2】的poll处理会正常获取到【注意1】里offer进去的新节点，
            // 反之【注意2】会取到一个Null节点，这都是合情合理的。
            // 唯一一点要注意的是如果没有按照【注意3】的处理进行而是先把节点加入连表里，
            // 再给节点赋值的话，就会导致poll出来的节点里的值不正确的问题出现。
            tailNode.setNext(newNode);
            tailNode = newNode;
        }finally {
            tailLock.unlock();
        }
        return true;
    }

    //从队列的头部获取
    public E poll(){
        headLock.lock();
        try{
            //【注意2】 参考注意1
            Node<E> newHeadNode = headNode.getNext();
            if (newHeadNode == null){
                return null;
            }else {
                // 这个算法巧妙在poll操作取出的实际不是第一个哨兵节点
                // 而是哨兵节点的Next节点的值，
                // 老的哨兵节点已经完成了它的任务被抛弃，现在将
                // 被poll出来的节点作为哨兵节点继续工作。
                headNode = newHeadNode;
                return newHeadNode.getValue();
            }
        }finally {
            headLock.unlock();
        }
    }
}
