# 深度遍历

有两种实现 DFS 的方法。
第一种方法是进行递归，这一点你可能已经很熟悉了。这里我们提供了一个模板作为参考：

## 模板一 递归实现

```
/*
 * Return true if there is a path from cur to target.
 */
boolean DFS(Node cur, Node target, Set<Node> visited) {
    return true if cur is target;
    for (next : each neighbor of cur) {
        if (next is not in visited) {
            add next to visted;
            return true if DFS(next, target, visited) == true;
        }
    }
    return false;
}

```

当我们递归地实现 DFS 时，似乎不需要使用任何栈。
但实际上，我们使用的是由系统提供的隐式栈，也称为调用栈（Call Stack）。

## 模板二

递归解决方案的优点是它更容易实现。 
但是，存在一个很大的缺点：如果递归的深度太高，你将遭受堆栈溢出。 
在这种情况下，您可能会希望使用 BFS，或使用显式栈实现 DFS。

这里我们提供了一个使用显式栈的模板：

```
    boolean DFS(Node root, Node target) {
        Set<Node> visited = new HashSet<>();
        Stack<Node> s = new Stack<>();
        s.push(root);
        while (!s.isEmpty()) {
            Node cur = s.pop();
            if (cur == target){
                return true;
            }
            for (Node next : cur.neighbors) {
                if (!visited.contains(next)) {
                    s.push(next);
                    visited.add(next);
                }
            }
        }
        return false;
    }
```