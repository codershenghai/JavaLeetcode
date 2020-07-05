package com.shenghaishxt.leetcode;

import com.shenghaishxt.structure.ListNode;

public class _0019_删除链表的倒数第N个节点 {
    // 两次遍历，第一次遍历得到链表长度，从而计算出倒数第N个节点是正数的第几个节点。
    // 然后第二次遍历将这个节点删除。
    public ListNode removeNthFromEnd1(ListNode head, int n) {
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

    // 一次遍历(快慢指针)
    public ListNode removeNthFromEnd2(ListNode head, int n) {
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
        _0019_删除链表的倒数第N个节点 Sol = new _0019_删除链表的倒数第N个节点();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        ListNode res = Sol.removeNthFromEnd2(head, 5);
        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }
    }
}
