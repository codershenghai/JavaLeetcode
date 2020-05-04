package com.shenghaishxt.medium;

import com.shenghaishxt.structure.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class _0113 {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        // Java 文档中 Stack 类建议使用 Deque 代替 Stack，注意：只使用栈的相关接口
        dfs(new ArrayDeque<>(), root, sum);
        return res;
    }

    public void dfs(Deque<Integer> path, TreeNode node, int sum) {
        if (node == null)
            return;
        sum -= node.val;
        path.addLast(node.val);
        if (sum == 0 && node.left == null && node.right == null) {
            res.add(new ArrayList<>(path));
            return;
        }

        if (node.left != null) {
            dfs(path, node.left, sum);
            path.removeLast();
        }

        if (node.right != null) {
            dfs(path, node.right, sum);
            path.removeLast();
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(11);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right.right.left = new TreeNode(5);
        root.right.right.right = new TreeNode(1);

        List<List<Integer>> res = new _0113().pathSum(root, 22);
        System.out.println(res);
    }
}
