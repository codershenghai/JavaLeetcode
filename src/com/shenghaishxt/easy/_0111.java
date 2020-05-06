package com.shenghaishxt.easy;

import com.shenghaishxt.structure.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class _0111 {
    /*
    注意事项：
    1. 当前节点的左右子树有一个为空时，返回的应是非空子树的最小深度，而不是空子树深度0。
       若返回0相当于把当前节点认为成叶子节点，与此节点有非空子树矛盾。
    2. 当左右子树都不为空时，和maximum depth题一样，返回左右子树深度的最小值。
    3. 当左右子树都为空时，只有一个根节点的深度为1。
     */
    private int minDepth(TreeNode root) {
        // 1.找终止条件
        if (root == null)
            return 0;
        // 2.找返回值
        // 3.本级递归应该做什么
        else if (root.left == null && root.right == null)
            return 1;
        else if (root.left == null)
            return minDepth(root.right) + 1;
        else if (root.right == null)
            return minDepth(root.left) + 1;
        else
            return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
    }

    // BFS 框架，推荐用第二种方法
    public int minDepth2(TreeNode root) {
        if (root == null) return 0;

        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.addLast(root);
        int depth = 0;

        while (!deque.isEmpty()) {
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = deque.pollFirst();

                // 判断是否达到重点
                if (cur.left == null && cur.right == null)
                    return depth+1;
                if (cur.left != null) deque.addLast(cur.left);
                if (cur.right != null) deque.addLast(cur.right);
            }
            depth++;
        }
        return depth;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        _0111 Sol = new _0111();
        System.out.println(Sol.minDepth(root));
    }
}
