package com.shenghaishxt.medium;

import com.shenghaishxt.structure.TreeNode;

import java.util.ArrayList;
import java.util.List;

class BSTIterator {
    List<Integer> list;
    int index;

    public BSTIterator(TreeNode root) {
        this.list = new ArrayList<>();
        this.index = 0;
        inorder(root);
    }

    /** @return the next smallest number */
    public int next() {
        return this.list.get(this.index++);
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return this.index < this.list.size();
    }

    private void inorder(TreeNode root) {
        if (root == null) return;
        inorder(root.left);
        this.list.add(root.val);
        inorder(root.right);
    }
}

public class _0173 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(7);
        root.left = new TreeNode(3);
        root.right = new TreeNode(15);
        root.right.left = new TreeNode(9);
        root.right.right = new TreeNode(20);
        BSTIterator iterator = new BSTIterator(root);
        while (iterator.hasNext()) System.out.println(iterator.next());
    }
}
