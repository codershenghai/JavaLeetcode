package com.shenghaishxt.easy;

import com.shenghaishxt.structure.ListNode;

public class _0083 {
    private ListNode deleteDuplicates1(ListNode head) {
        ListNode p = head;
        if (head == null)
            return null;
        while (p.next != null) {
            if (p.val == p.next.val)
                p.next = p.next.next;
            else
                p = p.next;
        }
        return head;
    }

    private ListNode deleteDuplicates2(ListNode head) {
        // 1.找终止条件
        if (head == null || head.next == null)
            return head;
        // 2.找返回值
        // 3.本级递归应该做什么
        if (head.val == head.next.val)
            head = deleteDuplicates2(head.next);
        else
            head.next = deleteDuplicates2(head.next);
        return head;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(1);
        l1.next.next = new ListNode(2);
        l1.next.next.next = new ListNode(3);
        l1.next.next.next.next = new ListNode(3);

        _0083 Sol = new _0083();
        ListNode res = Sol.deleteDuplicates2(l1);
        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }
    }
}
