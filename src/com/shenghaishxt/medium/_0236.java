package com.shenghaishxt.medium;

import com.shenghaishxt.structure.TreeNode;

import java.util.LinkedList;

public class _0236 {
    // 对树遍历两遍，找到包含p和q的两条路径，然后再对两条路径找最后一个相同的节点。

    LinkedList<LinkedList<TreeNode>> list = new LinkedList<>();

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        dfs(root, p, new LinkedList<>());
        dfs(root, q, new LinkedList<>());
        LinkedList<TreeNode> list1 = list.get(0);
        LinkedList<TreeNode> list2 = list.get(1);

        int i = 0, j = 0;
        while (i < list1.size() && j < list2.size()) {
            if (list1.get(i++) != list2.get(j++))
                return list1.get(i-2);
        }
        return list1.get(i-1);
    }

    public void dfs(TreeNode root, TreeNode target, LinkedList<TreeNode> path) {
        path.add(root);
        if (root.val == target.val) {
            list.add(new LinkedList<>(path));
            return;
        }
        if (root.left != null)
            dfs(root.left, target, path);
        if (root.right != null)
            dfs(root.right, target, path);
        path.remove(path.size()-1);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);
        TreeNode p = root.left.right.left;
        TreeNode q = root.left.right.right;
        System.out.println(new _0236().lowestCommonAncestor(root, p, q).val);
    }
}
