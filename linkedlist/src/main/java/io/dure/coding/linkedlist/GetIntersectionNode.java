package io.dure.coding.linkedlist;

public class GetIntersectionNode {
    // O(m+n) time | O(1) space
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int count1 = countList(headA);
        int count2 = countList(headB);
        int delta = Math.abs(count1 - count2);
        ListNode longer = count1 > count2 ? headA: headB;
        ListNode shorter = count1 > count2 ? headB : headA;
        ListNode node1 = longer;
        for (int i = 0; i < delta; i++) {
            node1 = node1.next;
        }
        ListNode node2 = shorter;
        while (node1 != node2) {
            node1 = node1.next;
            node2 = node2.next;
        }
        return node1;
    }

    private int countList(ListNode head) {
        int count = 0;
        while (head != null) {
            head = head.next;
            count++;
        }
        return count;
    }
}
