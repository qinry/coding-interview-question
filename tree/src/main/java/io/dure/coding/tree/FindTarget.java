package io.dure.coding.tree;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class FindTarget {
    // O(n) time | O(n) space
//    public boolean findTarget(TreeNode root, int k) {
//        Set<Integer> set = new HashSet<>();
//        Stack<TreeNode> stack = new Stack<>();
//        TreeNode cur = root;
//        while (cur != null || !stack.empty()) {
//            while (cur != null) {
//                stack.push(cur);
//                cur = cur.left;
//            }
//            cur = stack.pop();
//            if (set.contains(k - cur.val)) {
//                return true;
//            }
//            set.add(cur.val);
//            cur = cur.right;
//        }
//        return false;
//    }
    // O(n) time | O(d) space
    public boolean findTarget(TreeNode root, int k) {
        if (root == null) {
            return false;
        }
        BSTIterator iterNext = new BSTIterator(root);
        BSTIteratorReversed iterPrev = new BSTIteratorReversed(root);

        // 初始化最小值
        int next = iterNext.next();
        // 初始化最大值
        int prev = iterPrev.prev();

        while (next != prev) {
            if (next + prev == k) {
                return true;
            } else if (next + prev < k) {
                next = iterNext.next();
            } else {
                prev = iterPrev.prev();
            }
        }
        return false;
    }
}
