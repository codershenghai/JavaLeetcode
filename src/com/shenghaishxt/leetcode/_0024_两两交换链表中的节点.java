package com.shenghaishxt.leetcode;

import com.shenghaishxt.structure.ListNode;

public class _0024_两两交换链表中的节点 {
    // 递归
    public ListNode swapPairs(ListNode head) {
        // 递归终止的条件
        if (head == null || head.next == null) return head;
        ListNode r = head.next;

        // 找返回值
        head.next = swapPairs(r.next);

        // 本级递归应该做什么
        head.next.next = head.next;
        return r;
    }

    // 参考0025 K个一组翻转链表
    public ListNode swapPairs1(ListNode head) {
        ListNode tail = head;

        // 剩余节点少于k，不反转
        for (int i = 0; i < 2; i++) {
            if (tail == null) return head;
            else tail = tail.next;
        }
        // 反转前k个元素
        ListNode newHead = reverse(head, tail);
        // 反转后这组的最后一个节点是head，下一轮开始的第一个节点是tail
        head.next = swapPairs(tail);
        return newHead;
    }

    private ListNode reverse(ListNode head, ListNode tail) {
        ListNode dummy = new ListNode(0);
        while (head != null && head != tail) {
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

        ListNode res = new _0024_两两交换链表中的节点().swapPairs(head);
        while (res != null) {
            System.out.print(res.val);
            res = res.next;
        }
    }
}
