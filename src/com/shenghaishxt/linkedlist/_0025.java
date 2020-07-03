package com.shenghaishxt.linkedlist;

import com.shenghaishxt.structure.ListNode;

/**
 * K个一组反转链表
 */
public class _0025 {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode tail = head;

        // 剩余节点少于k，不反转
        for (int i = 0; i < k; i++) {
            if (tail == null) return head;
            else tail = tail.next;
        }
        // 反转前k个元素
        ListNode newHead = reverse(head, tail);
        // 反转后这组的最后一个节点是head，下一轮开始的第一个节点是tail
        head.next = reverseKGroup(tail, k);
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
        head.next.next.next.next = new ListNode(5);

        ListNode res = new _0025().reverseKGroup(head, 2);
        while (res != null) {
            System.out.print(res.val);
            res = res.next;
        }
    }
}
