package com.shenghaishxt.easy;

import com.shenghaishxt.structure.TreeNode;

public class _0100 {
    private boolean isSameTree(TreeNode p, TreeNode q) {
        // 1.递归终止的条件
        if (p == null && q==null)
            return true;
        if (p == null || q==null)
            return false;

        // 2.找返回值
        boolean left = isSameTree(p.left, q.left);
        boolean right = isSameTree(p.right, q.right);

        // 3.本级递归应该做什么
        return left && right && p.val == q.val;
    }

    public static void main(String[] args) {
        _0100 Sol = new _0100();

        TreeNode p = new TreeNode(1);
        p.left = new TreeNode(2);
        p.right = new TreeNode(1);

        TreeNode q = new TreeNode(1);
        q.left = new TreeNode(1);
        q.right = new TreeNode(2);

        System.out.println(Sol.isSameTree(p, q));
    }
}
