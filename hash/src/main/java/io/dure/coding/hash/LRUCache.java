package io.dure.coding.hash;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    ListNode head;
    ListNode tail;
    Map<Integer, ListNode> map;
    int cap;

    public LRUCache(int capacity) {
        head = new ListNode(-1, -1);
        tail = new ListNode(-1, -1);
        head.next = tail;
        tail.prev = head;
        map = new HashMap<>();
        cap = capacity;
    }
    // 注意插入或更新操作，哈希表和链表都要操作
    // O(1) time | O(1) space
    public void put(int key, int val) {
        if (map.containsKey(key)) {
            moveToTail(map.get(key), val);
        } else {
            if (map.size() == cap) {
                ListNode toBeDeleted = head.next;
                deleteNode(toBeDeleted);
                map.remove(toBeDeleted.key);
            }
            ListNode node = new ListNode(key, val);
            insertToTail(node);
            map.put(key, node);
        }
    }
    // O(1) time | O(1) space
    public int get(int key) {
        ListNode node = map.get(key);
        if (node == null) {
            return -1;
        }
        moveToTail(node, node.val);
        return node.val;
    }

    private void moveToTail(ListNode node, int val) {
        deleteNode(node);
        node.val = val;
        insertToTail(node);
    }

    private void deleteNode(ListNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
    private void insertToTail(ListNode node) {
        tail.prev.next = node;
        node.prev = tail.prev;
        node.next = tail;
        tail.prev = node;
    }
    static class ListNode {
        public int key;
        public int val;
        public ListNode prev;
        public ListNode next;

        public ListNode(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }
}
