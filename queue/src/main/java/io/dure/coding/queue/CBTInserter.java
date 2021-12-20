package io.dure.coding.queue;

import java.util.LinkedList;
import java.util.Queue;

public class CBTInserter {
    private Queue<TreeNode> queue;
    public TreeNode root;
    // O(n) time | O(n) space
    public CBTInserter(TreeNode root) {
        this.root = root;
        this.queue = new LinkedList<>();
        queue.offer(root);
        while (queue.peek().left != null && queue.peek().right != null) {
            TreeNode node = queue.poll();
            queue.offer(node.left);
            queue.offer(node.right);
        }

    }
    // O(1) time
    public int insert(int val){
        TreeNode parent = queue.peek();
        TreeNode node = new TreeNode(val);

        if (parent.left == null) {
            parent.left = node;
        } else {
            parent.right = node;

            queue.poll();
            queue.offer(parent.left);
            queue.offer(parent.right);
        }

        return parent.val;
    }
    // O(1) time
    public TreeNode getRoot() {
        return this.root;
    }

}
