package com.shenghaishxt.easy;

import com.shenghaishxt.structure.ListNode;

public class _0203 {
    private ListNode removeElements1(ListNode head, int val) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode p = dummy;

        while (head != null) {
            if (head.val == val) {
                head = head.next;
                p.next = head;
            }
            else {
                p = p.next;
                head = head.next;
            }
        }
        return dummy.next;
    }

    private ListNode removeElements2(ListNode head, int val) {
        // 1.递归终止的条件
        if (head == null) return null;
        // 2.找返回值
        head.next = removeElements2(head.next, val);
        // 3.本级递归应该做什么
        if (head.val == val)
            return head.next;
        else
            return head;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(6);
        l1.next.next.next = new ListNode(3);
        l1.next.next.next.next = new ListNode(4);
        l1.next.next.next.next.next = new ListNode(5);
        l1.next.next.next.next.next.next = new ListNode(6);

        _0203 Sol = new _0203();
        ListNode res = Sol.removeElements2(l1, 6);
        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }
    }
}
