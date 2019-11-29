package com.shenghaishxt.easy;

import com.shenghaishxt.structure.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class _0226 {
    private TreeNode invertTree(TreeNode root) {
        // 1.递归终止的条件
        if (root == null)
            return null;
        // 2.找返回值
        TreeNode tmp = root.right;
        root.right = invertTree(root.left);
        root.left = invertTree(tmp);
        // 3.本级递归应该做什么
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(9);

        _0226 Sol = new _0226();
        TreeNode res = Sol.invertTree(root);

        // 层次遍历
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
