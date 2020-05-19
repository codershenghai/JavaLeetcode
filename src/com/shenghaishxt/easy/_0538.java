package com.shenghaishxt.easy;

import com.shenghaishxt.structure.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class _0538 {

    List<Integer> list = new ArrayList<>();

    public TreeNode convertBST(TreeNode root) {
        inOrder(root);
        preOrder(root);
        return root;
    }

    // BST的中序遍历是递增序列
    private void inOrder(TreeNode root) {
        if (root == null) return;
        inOrder(root.left);
        list.add(root.val);
        inOrder(root.right);
    }

    // 先序遍历修改节点值
    private void preOrder(TreeNode root) {
        if (root == null) return;
        int sum = 0;
        for (int val : list) {
            if (val >= root.val) {
                sum += val;
            }
        }
        root.val = sum;
        preOrder(root.left);
        preOrder(root.right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(2);
        root.right = new TreeNode(13);
        TreeNode res = new _0538().convertBST(root);

        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.addLast(res);
        while (!deque.isEmpty()) {
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = deque.pollFirst();
                System.out.print(cur.val + " ");
                if (cur.left != null) deque.addLast(cur.left);
                if (cur.right != null) deque.addLast(cur.right);
            }
            System.out.println();
        }
    }
}
