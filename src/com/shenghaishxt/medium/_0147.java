package com.shenghaishxt.medium;

import com.shenghaishxt.structure.ListNode;

public class _0147 {
    public ListNode insertionSortList(ListNode head) {
        if (head == null)
            return null;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = head, p = head.next; //p之前的元素排序已完成

        while (p != null) {
            if (p.val < pre.val) {
                ListNode temp = dummy;
                while (temp.next.val < p.val) temp = temp.next;
                pre.next = p.next;
                p.next = temp.next;
                temp.next = p;
                p = pre.next;
            } else {
                p = p.next;
                pre = pre.next;
            }
        }
        return dummy.next;
    }


    public static void main(String[] args) {
        ListNode l1 = new ListNode(6);
        l1.next = new ListNode(5);
        l1.next.next = new ListNode(3);
        l1.next.next.next = new ListNode(1);
        l1.next.next.next.next = new ListNode(8);
        l1.next.next.next.next.next = new ListNode(7);
        l1.next.next.next.next.next.next = new ListNode(2);
        l1.next.next.next.next.next.next.next = new ListNode(4);
        ListNode res = new _0147().insertionSortList(l1);

        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }
    }
}
