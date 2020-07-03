package com.shenghaishxt.linkedlist;

import com.shenghaishxt.structure.ListNode;

public class _0024 {
    public ListNode swapPairs(ListNode head) {
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

        ListNode res = new _0024().swapPairs(head);
        while (res != null) {
            System.out.print(res.val);
            res = res.next;
        }
    }
}
