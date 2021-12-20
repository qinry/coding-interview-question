package io.dure.coding.tree;

import java.util.Stack;

public class BSTIterator {
    private Stack<TreeNode> stack;
    private TreeNode cur;
    public BSTIterator(TreeNode root) {
        cur = root;
        stack = new Stack<>();
    }
    // O(1) time | O(d) space
    public boolean hasNext() {
        return cur != null || !stack.empty();
    }
    // O(1) time | O(d) space
    public int next() {
        while (cur != null) {
            stack.push(cur);
            cur = cur.left;
        }
        cur = stack.pop();
        int val = cur.val;
        cur = cur.right;
        return val;
    }

}
