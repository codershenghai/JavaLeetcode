package com.shenghaishxt.easy;

import com.shenghaishxt.structure.TreeNode;

public class _0104 {
    private int maxDepth(TreeNode root) {
        // 1.找终止条件
        if (root == null)
            return 0;
        // 2.找返回值
        int left_depth = maxDepth(root.left);
        int right_depth = maxDepth(root.right);
        // 3.本级递归应该做什么
        return Math.max(left_depth, right_depth) + 1;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        _0104 Sol = new _0104();
        System.out.println(Sol.maxDepth(root));
    }
}
