package com.shenghaishxt.leetcode;

import com.shenghaishxt.structure.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class _0814_二叉树剪枝 {
    public TreeNode pruneTree(TreeNode root) {
        // 递归终止的条件
        if (root == null) return null;

        // 寻找递归的返回值
        root.left = pruneTree(root.left);
        root.right = pruneTree(root.right);

        // 本级递归应该做什么？
        // 怎么剪枝？在递归的过程中，如果当前节点的左右节点皆为空，且当前节点为0，就将当前节点剪掉
        if (root.left == null && root.right == null && root.val != 1) return null;
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(0);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(0);
        root.right = new TreeNode(1);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(1);

        TreeNode res = new _0814_二叉树剪枝().pruneTree(root);
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.addLast(res);
        while (!deque.isEmpty()) {
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = deque.pollFirst();
                System.out.print(node.val);
                if (node.left != null) deque.addLast(node.left);
                if (node.right != null) deque.addLast(node.right);
            }
            System.out.println("");
        }
    }
}
