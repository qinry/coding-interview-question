# Queue

## 基础知识

队列是一种先入先出的线性存储结构。

Java 中 Queue 是个接口。常用操作：

<table>
    <tr>
        <td>操作</td>
        <td>抛异常</td>
        <td>不抛异常</td>
    </tr>
    <tr>
        <td>插入元素</td>
        <td>add</td>
        <td>offer</td>
    </tr>
    <tr>
        <td>删除元素</td>
        <td>remove</td>
        <td>poll</td>
    </tr>
    <tr>
        <td>返回最前面的元素</td>
        <td>element</td>
        <td>peek</td>
    </tr>
</table>

实现 Queue 接口的类有 LinkedList、ArrayDeque等等，PriorityQueue虽然实现 Queue接口，但它不是队列，其实使用堆实现的。

## 应用

1. 表示数组的滑动窗口
2. 实现二叉树的广度优先搜素

二叉树的广度优先搜索

```
// O(n) time | O(n) space
public List<Integer> bfs(TreeNode root) {
    Queue<Integer> queue = new LinkedList<>();
    if (root != null) {
        queue.offer(root);
    }
    List<Integer> result = new ArrayList<>();
    while (!queue.empty()) {
        TreeNode cur = queue.poll();
        result.add(cur.val);
        if (cur.left != null) {
            queue.offer(cur.left);
        }
        if (cur.right != null) {
            queue.offer(cur.right);
        }
    }
    return result;
}
```

## 题目

* [滑动窗口](src/main/java/io/dure/coding/queue/MovingAverage.java)
* [最近请求次数](src/main/java/io/dure/coding/queue/RecentAverage.java)
* [在完全二叉树中添加节点](src/main/java/io/dure/coding/queue/CBTInserter.java)
* [二叉树中每层最大值](src/main/java/io/dure/coding/queue/LargestValues.java)
* [二叉树最底层最左边的值](src/main/java/io/dure/coding/queue/FindBottomLeftValue.java)
* [二叉树的右侧视图](src/main/java/io/dure/coding/queue/RightSideView.java)