package com.shenghaishxt.easy;

import com.shenghaishxt.structure.TreeNode;

public class _0112 {
    private boolean hasPathSum(TreeNode root, int sum) {
        // 1.递归终止的条件
        if (root == null)
            return false;
        sum -= root.val;
        if (sum == 0 && root.left == null && root.right==null)
            return true;

        // 2.找返回值
        boolean left = hasPathSum(root.left, sum);
        boolean right = hasPathSum(root.right, sum);

        // 本级递归应该做什么
        return left || right;
    }

    public static void main(String[] args) {
        _0112 Sol = new _0112();
/*
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.right.right.right = new TreeNode(1);
*/

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);

        System.out.println(Sol.hasPathSum(root, 1));
    }
}
