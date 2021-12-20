package io.dure.coding.linkedlist;

public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode head1, ListNode head2) {
        head1 = reverseList(head1);
        head2 = reverseList(head2);
        ListNode reversedHead = addReversed(head1, head2);
        return reverseList(reversedHead);
    }

    private ListNode addReversed(ListNode head1, ListNode head2) {
        ListNode dummy = new ListNode(0);
        ListNode sumNode = dummy;
        int carry = 0;
        // 同时扫描两个链表，直到全部扫完
        // 同时在新链表尾部添加求和节点
        while (head1 != null || head2 != null) {
            // 先到链表末端的，取0
            int sum = (head1 == null ? 0 : head1.val)
                    + (head2 == null ? 0 : head2.val) + carry;
            carry = sum >= 10 ? 1 : 0;
            sum = sum >= 10 ? sum - 10 : sum;
            ListNode newNode = new ListNode(sum);

            sumNode.next = newNode;
            sumNode = sumNode.next;

            head1 = head1 == null ? null : head1.next;
            head2 = head2 == null ? null : head2.next;
        }
        // 存在进位
        if (carry > 0) {
            sumNode.next = new ListNode(carry);
        }
        return dummy.next;
    }

    private ListNode reverseList(ListNode head) {
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
