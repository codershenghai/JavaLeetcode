package com.shenghaishxt.medium;

import com.shenghaishxt.structure.ListNode;

public class _0061 {
    private ListNode rotateRight(ListNode head, int k) {
        ListNode last = head;
        int length = 1;
        while (last.next != null) {
            last = last.next;
            length++;
        }
        last.next = head;

        return last;
    }

    public static void main(String[] args) {
        _0061 Sol = new _0061();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        int k = 4;
        ListNode res = Sol.rotateRight(head, k);

        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }
    }
}
