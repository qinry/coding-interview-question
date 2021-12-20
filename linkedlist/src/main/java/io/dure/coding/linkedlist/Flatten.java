package io.dure.coding.linkedlist;

public class Flatten {
    public Node flatten(Node head) {
        flattenGetTail(head);
        return head;
    }

    private Node flattenGetTail(Node head) {
        Node node = head;
        Node tail = null;
        while (node != null) {
            Node next = node.next;
            // 存在子链表展开子链表
            if (node.child != null) {
                Node child = node.child;
                Node childTail = flattenGetTail(child);

                node.child = null; // 要清除当前节点的子链表的指针
                node.next = child;
                child.prev = node;
                childTail.next = next;
                if (next != null) {
                    next.prev = childTail;
                }
                tail = childTail;
            } else {
                tail = node;
            }
            node = next;
        }
        return tail;
    }

    class Node {
        public int val;
        public Node next;
        public Node prev;
        public Node child;
        public Node(int val) {
            this.val = val;
        }
    }
}
