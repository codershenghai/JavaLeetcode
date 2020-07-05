package com.shenghaishxt.leetcode;

import com.shenghaishxt.structure.ListNode;

public class _0025_K个一组翻转链表 {
    // 递归
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode tail = head;

        // 递归终止的条件。剩余节点少于k，不反转
        for (int i = 0; i < k; i++) {
            if (tail == null) return head;
            else tail = tail.next;
        }
        // 反转前k个元素
        ListNode newHead = reverse(head, tail);
        // 反转后这组的最后一个节点是head，下一轮开始的第一个节点是tail
        head.next = reverseKGroup(tail, k);
        return newHead;
    }

    private ListNode reverse(ListNode head, ListNode tail) {
        ListNode dummy = new ListNode(0);
        while (head != null && head != tail) {
            ListNode r = head.next;
            head.next = dummy.next;
            dummy.next = head;
            head = r;
        }
        return dummy.next;
    }
}
