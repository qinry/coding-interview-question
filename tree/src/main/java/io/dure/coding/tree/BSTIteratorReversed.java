package io.dure.coding.tree;

import java.util.Stack;

public class BSTIteratorReversed {
    public Stack<TreeNode> stack;
    public TreeNode cur;

    public BSTIteratorReversed(TreeNode root) {
        cur = root;
        stack = new Stack<>();
    }

    public int prev() {
        while (cur != null) {
            stack.push(cur);
            cur = cur.right;
        }
        cur = stack.pop();
        int val = cur.val;
        cur = cur.left;
        return val;
    }

    public boolean hasPrev() {
        return cur != null || !stack.empty();
    }
}
