package com.shenghaishxt.leetcode;

import com.shenghaishxt.structure.ListNode;

public class _0023_合并K个排序链表 {
    public ListNode mergeKLists(ListNode[] lists) {
        int k = lists.length;
        ListNode dummy = new ListNode(0);
        ListNode p = dummy;
        for (;;) {
            ListNode minNode = new ListNode(Integer.MAX_VALUE);
            int minPointer = -1;
            for (int i = 0; i < k; i++) {
                if (lists[i] == null) continue;
                if (lists[i].val < minNode.val) {
                    minNode = lists[i];
                    minPointer = i;
                }
            }
            if (minPointer == -1) break;
            p.next = minNode;
            p = p.next;
            lists[minPointer] = lists[minPointer].next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(5);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);

        ListNode l3 = new ListNode(2);
        l3.next = new ListNode(6);

        ListNode[] lists = new ListNode[] {l1, l2, l3};
        ListNode res = new _0023_合并K个排序链表().mergeKLists(lists);
        while (res != null) {
            System.out.print(res.val);
            res = res.next;
        }
    }
}
