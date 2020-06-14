package com.shenghaishxt.bfs;

import com.shenghaishxt.easy._0111;
import com.shenghaishxt.structure.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class _0111_二叉树的最小深度 {
    public int minDepth(TreeNode root) {
        if (root == null) return 0;

        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.addLast(root);
        int depth = 0;

        while (!deque.isEmpty()) {
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = deque.pollFirst();

                // 判断是否达到叶子节点
                if (cur.left == null && cur.right == null) return depth + 1;
                if (cur.left != null) deque.addLast(cur.left);
                if (cur.right != null) deque.addLast(cur.right);
            }
            depth++;
        }
        return depth;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        System.out.println(new _0111_二叉树的最小深度().minDepth(root));
    }
}
