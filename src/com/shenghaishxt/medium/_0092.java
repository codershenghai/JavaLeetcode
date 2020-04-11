package com.shenghaishxt.medium;

import com.shenghaishxt.structure.ListNode;

public class _0092 {
    // 使用count记录已经反转的节点位置，及时停止反转
    public ListNode reverseBetween(ListNode head, int m, int n) {
        int count = 1; //初始位置为1
        ListNode dummy = new ListNode(0);
        ListNode pre = dummy, r = dummy;
        pre.next = head;
        while (head != null) {
            if (count < m) {
                head = head.next;
                pre = pre.next;
                count++;
            } else if (count >= m && count <= n) {
                // 到达m时，做反转前的准备(将pre.next置空，此时pre指向反转位置的前一个节点)
                if (count == m) {
                    pre.next = null;
                }
                r = head.next;
                head.next = pre.next;
                pre.next = head;
                head = r;
                count++;
            } else break;
        }

        // 将最右边的链表连接上
        while (pre.next != null) {
            pre = pre.next;
        }
        pre.next = r;
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(3);
        l1.next.next.next = new ListNode(4);
        l1.next.next.next.next = new ListNode(5);
        l1.next.next.next.next.next = new ListNode(6);
        ListNode res = new _0092().reverseBetween(l1, 1, 6);

        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }
    }
}
