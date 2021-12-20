package io.dure.coding.tree;

import java.util.Stack;

public class InorderSuccessor {
    // O(n) time | O(n) space
//    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
//        Stack<TreeNode> stack = new Stack<>();
//        TreeNode cur = root;
//        boolean found = false;
//        while (cur != null || !stack.empty()) {
//            while (cur != null) {
//                stack.push(cur);
//                cur = cur.left;
//            }
//            cur = stack.pop();
//            if (found) {
//                break;
//            } else if (cur == p) {
//                found = true;
//            }
//            cur = cur.right;
//        }
//        return cur;
//    }

    // O(d) time | O(1) space
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        TreeNode cur = root;
        TreeNode result = null;
        while (cur != null) {
            if (cur.val > p.val) {
                result = cur;
                cur = cur.left;
            } else {
                cur = cur.right;
            }
        }
        return result;
    }

}
