package com.shenghaishxt.medium;

import com.shenghaishxt.structure.TreeNode;

import java.util.*;

public class _0102 {
    // BFS广度优先搜索(非递归)
    private List<List<Integer>> levelOrderBFS(TreeNode root) {
        List<List<Integer>> ansList = new ArrayList<>();
        if (root == null)
            return ansList;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> arr = new ArrayList<>();
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                arr.add(cur.val);
                if (cur.left != null)
                    queue.offer(cur.left);
                if (cur.right != null)
                    queue.offer(cur.right);
            }
            ansList.add(arr);
        }
        return ansList;
    }

    // DFS深度优先搜索(递归)
    private List<List<Integer>> levelOrderDFS(TreeNode root) {
        List<List<Integer>> ansList = new ArrayList<>();
        DFS(root, 0, ansList);
        return ansList;
    }

    private void DFS(TreeNode root, int level, List<List<Integer>> ansList) {
        if (root == null)
            return;
        if (level == ansList.size())
            ansList.add(new ArrayList<>());
        ansList.get(level).add(root.val);

        DFS(root.left, level+1, ansList);
        DFS(root.right, level+1, ansList);
    }

    public static void main(String[] args) {
        _0102 Sol = new _0102();

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        List<List<Integer>> list = Sol.levelOrderDFS(root);
        System.out.println(list);
    }
}
