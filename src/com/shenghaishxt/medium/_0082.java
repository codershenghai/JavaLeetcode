package com.shenghaishxt.medium;

import com.shenghaishxt.structure.ListNode;

public class _0082 {
    private ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;
        while (head != null && head.next != null) {
            if (head.val != head.next.val) {
                pre = head;
                head = pre.next;
            } else {
                while (head.next != null && head.val == head.next.val)
                    head = head.next;
                pre.next = head.next;
                head = head.next;
            }
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        _0082 Sol = new _0082();
        ListNode head = new ListNode(1);
        head.next = new ListNode(1);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(1);
        head.next.next.next.next = new ListNode(1);
        ListNode res = Sol.deleteDuplicates(head);

        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }
    }
}
