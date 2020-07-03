package com.shenghaishxt.tree;

import com.shenghaishxt.structure.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉搜索树中第k小的元素
 */
public class _0230 {
    List<Integer> list = new ArrayList<>();
    public int kthSmallest(TreeNode root, int k) {
        inorder(root);
        return list.get(k-1);
    }

    private void inorder(TreeNode root) {
        if (root == null) return;
        inorder(root.left);
        list.add(root.val);
        inorder(root.right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.left.right = new TreeNode(2);
        System.out.println(new _0230().kthSmallest(root, 1));
    }
}
