package com.shenghaishxt.leetcode;
import com.shenghaishxt.structure.ListNode;

public class _0002_两数相加 {
    // 模拟加法进位相加，如果一个链表较短则在前面补0
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while (l1 != null || l2 != null) {
            int x = l1==null ? 0 : l1.val;
            int y = l2==null ? 0 : l2.val;
            int sum = x + y + carry;

            carry = sum / 10;
            cur.next = new ListNode(sum % 10);
            cur = cur.next;

            l1 = l1!=null ? l1.next : null;
            l2 = l2!=null ? l2.next : null;
        }
        if (carry == 1)
            cur.next = new ListNode(carry);
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(5);
//        l1.next = new ListNode(4);
//        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
//        l2.next = new ListNode(6);
//        l2.next.next = new ListNode(4);

        _0002_两数相加 Sol = new _0002_两数相加();
        ListNode res = Sol.addTwoNumbers(l1, l2);
        System.out.println();
    }
}
