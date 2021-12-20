package io.dure.coding.sorting;

import java.util.PriorityQueue;

public class MergeKLists {
    // O(nlogk) time | O(k) space
//    public ListNode mergeKLists(ListNode[] lists) {
//        ListNode dummy = new ListNode(0);
//        ListNode cur = dummy;
//        PriorityQueue<ListNode> minHeap = new PriorityQueue<>(
//                (e1, e2) -> e1.val - e2.val
//        );
//        for (ListNode list : lists) {
//            if (list != null) {
//                minHeap.offer(list);
//            }
//        }
//
//        while (!minHeap.isEmpty()) {
//            ListNode least = minHeap.poll();
//            cur.next = least;
//            cur = cur.next;
//            if (least.next != null) {
//                minHeap.offer(least.next);
//            }
//        }
//        return dummy.next;
//    }

    // O(nlogk) time | O(logk) space
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        return mergeList(lists, 0, lists.length);
    }

    private ListNode mergeList(ListNode[] lists, int start, int end) {
        if (start + 1 >= end) {
            return lists[start];
        }
        int mid = start + (end - start) / 2;
        ListNode head1 = mergeList(lists, start, mid);
        ListNode head2 = mergeList(lists, mid, end);
        return merge(head1, head2);
    }
    public ListNode merge(ListNode head1, ListNode head2) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while (head1 != null && head2 != null) {
            if (head1.val < head2.val) {
                cur.next = head1;
                head1 = head1.next;
            } else {
                cur.next  = head2;
                head2 = head2.next;
            }
            cur = cur.next;
        }
        cur.next = head1 == null ? head2 : head1;
        return dummy.next;
    }
}
