package com.zhj.leetcode.learn.stack;

import java.util.*;

/**
 * 克隆图
 * 给定无向连通图中一个节点的引用，返回该图的深拷贝（克隆）。图中的每个节点都包含它的值 val（Int） 和其邻居的列表（list[Node]）。
 *
 * 示例：
 * 输入：
 * {"$id":"1","neighbors":[{"$id":"2","neighbors":[{"$ref":"1"},{"$id":"3","neighbors":[{"$ref":"2"},{"$id":"4","neighbors":[{"$ref":"3"},{"$ref":"1"}],"val":4}],"val":3}],"val":2},{"$ref":"4"}],"val":1}
 *
 * 解释：
 * 节点 1 的值是 1，它有两个邻居：节点 2 和 4 。
 * 节点 2 的值是 2，它有两个邻居：节点 1 和 3 。
 * 节点 3 的值是 3，它有两个邻居：节点 2 和 4 。
 * 节点 4 的值是 4，它有两个邻居：节点 1 和 3 。
 *
 *
 * 提示：
 *
 * 节点数介于 1 到 100 之间。
 * 无向图是一个简单图，这意味着图中没有重复的边，也没有自环。
 * 由于图是无向的，如果节点 p 是节点 q 的邻居，那么节点 q 也必须是节点 p 的邻居。
 * 必须将给定节点的拷贝作为对克隆图的引用返回。
 */

public class CloneGraph {
    public Node cloneGraph(Node node) {
        Stack<Node> stack = new Stack<>();
        stack.push(node);

        Map<Node,Node> map = new HashMap<>();
        Set<Node> visited = new HashSet<>();

        Node cNode = new Node(node.val,new ArrayList<>());
        map.put(node,cNode);

        while (!stack.isEmpty()){
            Node cur = stack.pop();
            Node cCur = map.get(cur);

            if (!visited.contains(cur)){
                for (Node next :cur.neighbors){

                    Node cNext ;
                    if (map.containsKey(next)){
                        cNext = map.get(next);
                    }else{
                        cNext = new Node(next.val,new ArrayList<>());
                        map.put(next,cNext);
                    }

                    cCur.neighbors.add(cNext);
                    stack.push(next);

                }
                visited.add(cur);
            }
        }

        return cNode;
    }

    public static void main(String[] args) {
        Node node1 = new Node(1,new ArrayList<>());
        Node node2 = new Node(2,new ArrayList<>());
        Node node3 = new Node(3,new ArrayList<>());
        Node node4 = new Node(4,new ArrayList<>());


        node1.neighbors.add(node2);
        node1.neighbors.add(node4);

        node2.neighbors.add(node1);
        node2.neighbors.add(node3);

        node3.neighbors.add(node2);
        node3.neighbors.add(node4);

        node4.neighbors.add(node1);
        node4.neighbors.add(node3);

        System.out.println(node1);

        Node cNode1 = new CloneGraph().cloneGraph(node1);
        System.out.println(cNode1 + " "+ cNode1.hashCode());

        for (Node neighbor : cNode1.neighbors){
            System.out.println("    "+neighbor + " " + neighbor.hashCode());
            for (Node neighbor2 : neighbor.neighbors){
                System.out.println("        "+neighbor2 + " " + neighbor2.hashCode());

            }
        }

    }
}



// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {}

    public Node(int _val , List<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }

    @Override
    public String toString() {
        return "Node{" +
                "val=" + val +
                ", neighbors.size=" + neighbors.size() +
                '}';
    }
};
