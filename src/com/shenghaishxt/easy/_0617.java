package com.shenghaishxt.easy;

import com.shenghaishxt.structure.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class _0617 {
    private TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        // 1.递归终止的条件
        if (t1 == null && t2 == null)
            return null;
        else if (t1 == null)
            return t2;
        else if (t2 == null)
            return t1;
        // 2.找返回值
        t1.left = mergeTrees(t1.left, t2.left);
        t1.right = mergeTrees(t1.right, t2.right);
        // 3.本级递归应该做什么
        t1.val = t1.val + t2.val;
        return t1;
    }

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        t1.left = new TreeNode(3);
        t1.right = new TreeNode(2);
        t1.left.left = new TreeNode(5);

        TreeNode t2 = new TreeNode(2);
        t2.left = new TreeNode(1);
        t2.right = new TreeNode(3);
        t2.left.right = new TreeNode(4);
        t2.right.right = new TreeNode(7);

        _0617 Sol = new _0617();
        TreeNode res = Sol.mergeTrees(t1, t2);

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(res);
        while (queue.size() > 0) {
            TreeNode cur = queue.poll();
            System.out.println(cur.val);
            if (cur.left != null)
                queue.offer(cur.left);
            if (cur.right != null)
                queue.offer(cur.right);
        }
    }
}
