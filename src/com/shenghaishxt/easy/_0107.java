package com.shenghaishxt.easy;

import com.shenghaishxt.medium._0102;
import com.shenghaishxt.structure.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _0107 {
    /**
     *  BFS广度优先搜索(非递归)
     *  和_0102类似，从头添加数组即可。
     *  尽量不要用Collections.reverse()！
     */
    private List<List<Integer>> levelOrderBottomBFS(TreeNode root) {
        List<List<Integer>> ansList = new ArrayList<>();
        if (root == null) return ansList;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            List<Integer> arr = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                arr.add(cur.val);
                if (cur.left != null) queue.offer(cur.left);
                if (cur.right != null) queue.offer(cur.right);
            }
            ansList.add(0, arr);
        }
        return ansList;
    }

    private List<List<Integer>> levelOrderBottomDFS(TreeNode root) {
        List<List<Integer>> ansList = new ArrayList<>();
        DFS(root, 0, ansList);
        return ansList;
    }

    private void DFS(TreeNode root, int level, List<List<Integer>> ansList) {
        if (root == null) return;
        if (level == ansList.size())
            ansList.add(0, new ArrayList<>());
        ansList.get(ansList.size()-1-level).add(root.val);

        DFS(root.left, level+1, ansList);
        DFS(root.right, level+1,ansList);
    }

    public static void main(String[] args) {
        _0107 Sol = new _0107();

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        List<List<Integer>> list = Sol.levelOrderBottomDFS(root);
        System.out.println(list);
    }
}
