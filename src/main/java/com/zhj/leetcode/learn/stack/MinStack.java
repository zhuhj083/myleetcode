package com.zhj.leetcode.learn.stack;

import java.util.ArrayList;
import java.util.List;

/**
 * 最小栈
 *
 * 设计一个支持 push，pop，top 操作，并能在常数时间内检索到最小元素的栈。
 *
 * push(x) -- 将元素 x 推入栈中。
 * pop() -- 删除栈顶的元素。
 * top() -- 获取栈顶元素。
 * getMin() -- 检索栈中的最小元素。
 * 示例:
 *
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin();   --> 返回 -3.
 * minStack.pop();
 * minStack.top();      --> 返回 0.
 * minStack.getMin();   --> 返回 -2.
 *
 */
public class MinStack {

    private List<Integer> data;
    int minIndex = -1;

    /** initialize your data structure here. */
    public MinStack() {
        data = new ArrayList<>();
    }

    public void push(int x) {
        data.add(x);
        if (data.size() == 1){
            minIndex = 0 ;
        }else{
            if (x < data.get(minIndex)){
                minIndex = data.size() - 1 ;
            }
        }
    }

    public void pop() {
        if (data.isEmpty()) {
            return;
        }

        data.remove(data.size() - 1);

        if (data.isEmpty()){
            minIndex = - 1;
        }else{
            if (minIndex == data.size() ){
                int min = data.get(0) ;
                minIndex = 0 ;
                for (int i = 0; i < data.size() ; i++) {
                    if (data.get(i) < min){
                        min = data.get(i);
                        minIndex = i;
                    }
                }
            }
        }

    }

    public int top() {
        return data.get(data.size() - 1);
    }

    public int getMin() {
        return data.get(minIndex);
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.top());
        System.out.println(minStack.getMin());
    }
}
