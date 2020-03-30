package com.shenghaishxt.medium;

import com.shenghaishxt.structure.ListNode;

public class _0061 {
    // 思路是找到旋转后的头结点，将链表分为两半，然后重组链表
    // 1.先移到最后，用tail保存原链表的尾节点，顺便求出链表长度，并对k取余。
    // 2.求倒数第k+1个节点。
    // 3.将末尾连到头上。
    // 4.设置倒数第k+1个节点的next为头结点，然后设置倒数第k+1个节点的next为空。
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null)
            return null;

        // 1.先移到最后，用tail保存原链表的尾节点，顺便求出链表长度，并对k取余。
        ListNode tail = head;
        int length = 1;
        while (tail.next != null) {
            tail = tail.next;
            length++;
        }
        k = k % length;

        // 2.求倒数第k+1个节点。
        ListNode p = head, pHelper = head;
        while (k-- >= 0) {
            assert pHelper != null;
            pHelper = pHelper.next;
        }
        while (pHelper != null) {
            p = p.next;
            pHelper = pHelper.next;
        }

        // 3.将末尾连到头上。
        tail.next = head;

        // 4.设置倒数第k+1个节点的next为头结点，然后设置倒数第k+1个节点的next为空，最后返回头结点。
        head = p.next;
        p.next = null;
        return head;
    }

    public static void main(String[] args) {
        _0061 Sol = new _0061();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        int k = 4;
        ListNode res = Sol.rotateRight(head, k);

        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }
    }
}
