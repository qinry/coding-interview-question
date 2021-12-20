package io.dure.coding.linkedlist;

public class IsPalindrome {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        // 偶数个，fast到尾节点, slow到链表中部
        // 奇数个，fast到倒数第二个，slow到链表中部的前一个节点
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode secondHead = slow.next;
        // 确定链表长度是奇数个的后半断的头节点
        if (fast.next != null) {
            secondHead = slow.next.next;
        }
        slow.next = null;
        return equals(reverseList(head), secondHead);
    }

    private boolean equals(ListNode node1, ListNode node2) {
        while (node1 != null &&  node2 != null) {
            if (node1.val != node1.val) {
                return false;
            }
            node1 = node1.next;
            node2 = node2.next;
        }
        return node1 == null && node2 == null;
    }

    public ListNode reverseList(ListNode head) {
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
