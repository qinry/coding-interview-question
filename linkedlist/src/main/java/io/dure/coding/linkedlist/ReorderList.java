package io.dure.coding.linkedlist;

public class ReorderList {
    public void reorderList(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode slow =dummy;
        ListNode fast = dummy;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next;
            if (fast.next != null) {
                fast = fast.next;
            }
        }
        ListNode temp = slow.next;
        slow.next = null;
        link(head, reversedList(temp), dummy);
    }

    private void link(ListNode node1, ListNode node2, ListNode dummy) {
        ListNode pre = dummy;
        while (node1 != null && node2 != null) {
            ListNode temp = node1.next;

            pre.next = node1;
            node1.next = node2;
            pre  = node2;

            node1 = temp;
            node2 = node2.next;
        }
        if (node1 != null) {
            pre.next = node1;
        }
    }

    private ListNode reversedList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;

    }
}
