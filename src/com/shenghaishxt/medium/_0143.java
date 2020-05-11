package com.shenghaishxt.medium;

import com.shenghaishxt.structure.ListNode;

public class _0143 {
    public void reorderList(ListNode head) {
        // 寻找链表中点，leetcode876
        if (head == null) return;
        ListNode fast = head, low = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            low = low.next;
        }
        ListNode middle = low.next;
        low.next = null;

        // 翻转后半部分链表，leetcode206
        middle = reverse(middle);

        // 将翻转后的后半部分链表按间隔插入前半部分链表
        ListNode p1 = head, p2 = middle, nextP1, nextP2;
        while (p1 != null && p2 != null) {
            nextP1 = p1.next;
            nextP2 = p2.next;
            p2.next = p1.next;
            p1.next = p2;
            p1 = nextP1;
            p2 = nextP2;
        }
    }

    private ListNode reverse(ListNode head) {
        ListNode dummy = new ListNode(0);
        while (head != null) {
            ListNode r = head.next;
            head.next = dummy.next;
            dummy.next = head;
            head = r;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
//        head.next.next.next.next = new ListNode(5);
//        head.next.next.next.next.next = new ListNode(6);

        new _0143().reorderList(head);
        while (head != null) {
            System.out.print(head.val);
            head = head.next;
        }
    }
}
