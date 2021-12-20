package io.dure.coding.linkedlist;


public class Insert {
    public Node insert(Node head, int insertVal) {
        Node node = new Node(insertVal);
        if (head == null) {
            head = node;
        } else if (head.next == null) {
            head.next = node;
            node.next = head;
        } else {
            insertCore(head, node);
        }
        return head;
    }

    private void insertCore(Node head, Node node) {
        Node cur = head;
        Node next = head.next;
        Node biggest = cur;
        // 查找插入节点前节点和后节点，找不到则确定最大值的节点
        while (!(cur.val <= node.val && node.val <= next.val)
                && next != head) {
            cur = next;
            next = next.next;
            // 遇到等值节点中，取其最后一个
            if (biggest.val <= cur.val) {
                biggest = cur;
            }
        }
        if (cur.val <= node.val && node.val <= next.val) {
            node.next = cur.next;
            cur.next = node;
        } else {
            node.next = biggest.next;
            biggest.next = node;
        }
    }
    class Node {
        public int val;
        public Node next;
        public Node(int val){
            this.val = val;
        }
    }
}
