package com.shenghaishxt.medium;

import com.shenghaishxt.structure.ListNode;

public class _0086 {
    // 将这个链表重新串一遍
    public ListNode partition(ListNode head, int x) {
        ListNode minList = new ListNode(0);
        ListNode maxList = new ListNode(0);
        ListNode p = head, minP = minList, maxP = maxList;
        while (p != null) {
            if (p.val < x) {
                minP.next = p;
                minP = minP.next;
            } else {
                maxP.next = p;
                maxP = maxP.next;
            }
            p = p.next;
        }
        maxP.next = null;
        minP.next = maxList.next;
        return minList.next;
    }
}
