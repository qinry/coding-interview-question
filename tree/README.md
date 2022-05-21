# Tree

## 基础知识

二叉树中每一个节点最多有只有两个子节点。根节点没有父节点，非空的二叉树只有一个父节点。叶子节点没有子节点。

二叉树是具有递归性质的数据结构。二叉树的根节点可能有子节点，子节点又是子树的根节点。所以往往使用递归的算法更加直观。

完全二叉树，除了最后一层节点，所有层的节点数达到最大值，最后一层的节点尽量向左边聚集。

## 深度优先搜索

二叉树的问题往往与遍历有关，遍历方式分别是：广度优先搜索和深度优先搜索。广度优先搜索通过队列实现；而深度优先搜索使用栈来实现。

深度优先搜索，根据处理父节点、左子节点和右子节点的顺序分别有：中序遍历、前序遍历和后序遍历。

### 中序遍历

左子树 -> 根节点 -> 右子树

递归代码：

```
public List<Integer> inorderTraverse(TreeNode root) {
    List<Integer> nodes = new LinkedList<>();
    dfs(root, nodes);
    return nodes;
}
private void dfs(TreeNode node, List<Integer> nodes) {
    if (root != null) {
        dfs(node.left, nodes);
        nodes.add(node.val);
        dfs(node.right, nodes);
    }
}
```

> 如果二叉树的深度（从根节点到叶节点的最长路径的长度）过大，会导致调用栈的溢出

迭代代码：

```
public List<Integer> inorderTraverse(TreeNode root) {
    List<Integer> nodes = new LinkedList<>();
    Stack<TreeNode> stack = new Stack<>();
    TreeNode cur = root;
    while (cur != null || !stack.empty()) {
        while (cur != null) {
            stack.push(cur);
            cur = cur.left;
        }
        cur = stack.pop();
        nodes.add(cur.val);
        cur = cur.right;
    }
    return nodes;
}
```

cur 代表当前遍历的节点。cur有左子树，顺着左子节点的指针向下移动，并沿途把节点添加到栈 stack 中。第二 while 循环结束后，
最左子节点在栈顶，将其出栈并遍历。由于是中序遍历，接着遍历的它的右子树，开始下一轮遍历，直到所有节点都遍历完为止。

### 前序遍历
根节点 -> 左子树 -> 右子树

递归代码：

```
public List<Integer> preorderTraversal(TreeNode root) {
    List<TreeNode> nodes = new LinkedList<>();
    dfs(root, nodes);
    return nodes;
}
private void dfs(TreeNode root, List<TreeNode> nodes) {
    if (root != null) {
        nodes.add(root.val);
        dfs(root.left, nodes);
        dfs(root.right, nodes);
    }
}
```

迭代代码：

```
public List<Integer> preorderTraversal(TreeNode root) {
    List<Integer> nodes = new LinkedList<>();
    Stack<TreeNode> stack = new Stack<>();
    TreeNode cur = root;
    while (cur != null || !stack.empty()) {
        while (cur != null) {
            nodes.add(cur.val);
            stack.push(cur);
            cur = cur.left;
        }
        cur = stack.pop();
        cur = cur.right;
    }
    return nodes;
}
```

> 与中序遍历类似，只是修改遍历当前节点的顺序。

### 后序遍历

左子树 -> 右子树 -> 根节点

```
public List<Integer> postorderTraversal(TreeNode root) {
    List<Integer nodes = new LinkedList<>();
    dfs(root, nodes);
    return nodes;
}
private void dfs(TreeNode root, List<TreeNode> nodes) {
    if (root != null) {
        dfs(root.left, nodes);
        dfs(root.right, nodes);
        nodes.add(root.val);
    }
}
```

迭代代码:

```
public List<Integer> postorderTraversal(TreeNode root) {
    List<Integer> nodes = new LinkedList<>();
    Stack<TreeNode> stack = new Stack<>();
    TreeNode cur = root;
    TreeNode prev = null;
    while (cur != null || !stack.empty()) {
        while (cur != null) {
            stack.push(cur);
            cur = cur.left;
        }
        cur = stack.peek();
        if (cur.right != null && cur.right != prev) {
            cur = cur.right;
        } else {
            stack.pop();
            nodes.add(cur.val);
            prev = cur;
            cur = null;
        }
    }
}
```

> 后序遍历比较复杂，当到达某一节点，要判断其右子树是否已被遍历过了。如果没有，前往其右子节点；如果有，遍历当前节点。
> 如果已遍历右子树，右子树最后被遍历的节点是右子树的根节点，也就是当前节点的右子节点。

深度优先搜索算法，时间复杂度 O(n)，设二叉树的深度为 d，空间复杂度 O(d)。二叉树中深度的最小值为 log2(n+1)，最大值为 n。

如何选择深度优先搜索？

* 二叉树序列化和反序列化使用**前序遍历**解决

* 根节点到叶节点的路径和向下路径的问题使用**前序遍历**解决

* 求进过某节点路径既前往左子树又前往右子树的路径使用**后序遍历**解决

* 二叉搜索树问题常用**中序遍历**解决

## 二叉搜索树

二叉搜索树的左子节点总是小于根节点，右子节点值总是大于根节点。
查找、添加和删除的平均时间复杂度为 O(logn)。

假如节点有n个，深度为d。在平衡情况下，深度 d 近似等于为 logn。

在极端情况下，深度等于 n-1。 查找、添加和删除的时间复杂度会从 O(logn)退化到 O(n)

对二叉搜索树使用中序遍历，则按照值从小到大的顺序遍历每一个节点。

### 平衡二叉搜索树

Java 提供了平衡二叉搜索树（红黑树）的实现，TreeSet 和 TreeMap。 
查找、添加和删除的时间复杂度为O(logn)。

TreeSet 常用函数：

<table>
    <tr><td>函数</td><td>功能</td></tr>
    <tr><td>ceiling</td><td>返回键大于或等于给定值的最小键；如果没有返回null</td></tr>
    <tr><td>floor</td><td>返回键小于或等于给定值的最大键；如果没有返回null</td></tr>
    <tr><td>higher</td><td>返回键大于给定值的最小键；如果没有返回null</td></tr>
    <tr><td>lower</td><td>返回键小于给定值的最大键；如果没有返回null</td></tr>
</table>

TreeMap 常用函数：

<table>
    <tr><td>函数</td><td>功能</td></tr>
    <tr><td>ceilingEntry/ceilingKey</td><td>返回键大于或等于给定值的最小映射/键；如果没有则返回null</td></tr>
    <tr><td>floorEntry/floorKey</td><td>返回键小于或等于给定值的最大映射/键；如果没有则返回null</td></tr>
    <tr><td>higherEntry/higherKey</td><td>返回键大于给定值的最小映射/键；如果没有则返回null</td></tr>
    <tr><td>lowerEntry/lowerKey</td><td>返回键小于给定值的最大映射/键；如果没有则返回null</td></tr>
</table>

## 题目

* [二叉树剪枝](src/main/java/io/dure/coding/tree/PruneTree.java)
* [序列化和反序列化二叉树](src/main/java/io/dure/coding/tree/Codec.java)
* [从根节点到叶节点的路径数字之和](src/main/java/io/dure/coding/tree/SumNumbers.java)
* [向下路径节点值之和](src/main/java/io/dure/coding/tree/PathSum.java)
* [节点值之和最大的路径](src/main/java/io/dure/coding/tree/MaxPathSum.java)
* [展开二叉搜索树](src/main/java/io/dure/coding/tree/IncreasingBST.java)
* [二叉搜索树的下一个节点](src/main/java/io/dure/coding/tree/InorderSuccessor.java)
* [所有大于或等于节点值之和](src/main/java/io/dure/coding/tree/ConvertBST.java)
* [二叉搜索树的迭代器](src/main/java/io/dure/coding/tree/BSTIterator.java)
* [二叉搜索树中两个节点值之和](src/main/java/io/dure/coding/tree/FindTarget.java)
* [值和下标之差都在给定范围内](src/main/java/io/dure/coding/tree/ContainsNearbyAlmostDuplicate.java)
* [日程表](src/main/java/io/dure/coding/tree/MyCalendar.java)
