package com.shenghaishxt.easy;

import com.shenghaishxt.structure.ListNode;

public class _0206 {
    private ListNode reverseList1(ListNode head) {
        ListNode dummy = new ListNode(0);
        ListNode q;
        while (head != null) {
            q = head.next;
            head.next = dummy.next;
            dummy.next = head;
            head = q;
        }
        return dummy.next;
    }

    private ListNode reverseList2(ListNode head) {
        // https://leetcode-cn.com/problems/reverse-linked-list/solution/dong-hua-yan-shi-206-fan-zhuan-lian-biao-by-user74/
        // 1.递归终止的条件
        if (head == null || head.next == null)
            return head;
        // 2.找返回值
        ListNode p = reverseList2(head.next);
        // 3.本级递归应该做什么
        head.next.next = head;
        head.next = null;
        return p;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(3);
        l1.next.next.next = new ListNode(4);
        l1.next.next.next.next = new ListNode(5);
        l1.next.next.next.next.next = new ListNode(6);

        _0206 Sol = new _0206();
        ListNode res = Sol.reverseList2(l1);
        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }
    }
}
