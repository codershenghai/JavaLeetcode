package com.shenghaishxt.medium;

import com.shenghaishxt.structure.ListNode;

public class _0019 {
    // 两次遍历
    private ListNode removeNthFromEnd1(ListNode head, int n) {
        int length = 0;
        ListNode p = head;
        while (p != null) {
            length++;
            p = p.next;
        }

        int pos = length - n + 1;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;

        while (pos > 1 && pre.next != null) {
            head = head.next;
            pre = pre.next;
            pos--;
        }
        pre.next = head.next;
        return dummy.next;
    }

    // 一次遍历(使用两个指针保持恒定的间隔)
    private ListNode removeNthFromEnd2(ListNode head, int n) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode left = dummy, right = dummy;
        for (int i = 0; i <= n; i++)
            right = right.next;

        while (right != null) {
            right = right.next;
            left = left.next;
        }
        left.next = left.next.next;
        return dummy.next;
    }

    public static void main(String[] args) {
        _0019 Sol = new _0019();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        int n = 5;
        ListNode res = Sol.removeNthFromEnd2(head, n);
        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }
    }
}
