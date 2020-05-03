package com.shenghaishxt.easy;

import com.shenghaishxt.structure.TreeNode;

public class _0543 {
    int maxLength = Integer.MIN_VALUE;

    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null)
            return 0;
        int temp = maxDepth(root);
        return maxLength;
    }

    private int maxDepth(TreeNode root) {
        if (root == null)
            return 0;
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        if (left + right > maxLength)
            maxLength = left + right;
        return Math.max(left, right) + 1;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        int res = new _0543().diameterOfBinaryTree(root);
        System.out.println(res);
    }
}
