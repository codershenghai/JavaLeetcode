package com.shenghaishxt.leetcode;

import com.shenghaishxt.structure.ListNode;

public class _0021_合并两个有序链表 {
    // 递归
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // 1.递归终止的条件
        if (l1 == null && l2 == null)
            return null;
        if (l1 == null)
            return l2;
        if (l2 == null)
            return l1;
        // 2.找返回值
        // 3.本级递归应该做什么
        if (l1.val <= l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        }
        else {
            l2.next = mergeTwoLists(l2.next, l1);
            return l2;
        }
    }

    // 循环
    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null)
            return null;
        if (l1 == null)
            return l2;
        if (l2 == null)
            return l1;
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        if (l1 == null) cur.next = l2;
        else cur.next = l1;
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);

        ListNode res = new _0021_合并两个有序链表().mergeTwoLists2(l1, l2);
        while (res != null) {
            System.out.print(res.val);
            res = res.next;
        }
    }
}
