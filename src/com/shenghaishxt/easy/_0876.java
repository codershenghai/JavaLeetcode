package com.shenghaishxt.easy;

import com.shenghaishxt.structure.ListNode;

public class _0876 {
    public ListNode middleNode(ListNode head) {
        if (head == null) return null;
        ListNode fast = head, low = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            low = low.next;
        }
        return fast.next == null ? low : low.next;
    }



    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
//        head.next.next = new ListNode(3);
//        head.next.next.next = new ListNode(4);
//        head.next.next.next.next = new ListNode(5);
//        head.next.next.next.next.next = new ListNode(6);

        ListNode res = new _0876().middleNode(head);
        System.out.println(res.val);
    }
}
