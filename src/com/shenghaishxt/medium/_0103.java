package com.shenghaishxt.medium;

import com.shenghaishxt.structure.TreeNode;

import java.util.*;

public class _0103 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) return new ArrayList<>();
        List<List<Integer>> res = new LinkedList<>();
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.addLast(root);
        boolean flag = true; //是否翻转的标志

        while (!deque.isEmpty()) {
            flag = !flag;
            int size = deque.size();
            List<Integer> layer = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = deque.pollFirst();

                layer.add(node.val);
                if (node.left != null) deque.addLast(node.left);
                if (node.right != null) deque.addLast(node.right);
            }
            if (flag) Collections.reverse(layer);
            res.add(layer);
        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        List<List<Integer>> res = new _0103().zigzagLevelOrder(root);
        System.out.println(res);
    }
}
