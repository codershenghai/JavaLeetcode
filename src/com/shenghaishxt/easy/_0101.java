package com.shenghaishxt.easy;

import com.shenghaishxt.structure.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class _0101 {
    private boolean isSymmetric1(TreeNode root) {
        // 直接造个新的树与自己比较！
        // 什么时候为对称二叉树？(1)根节点有相同的值。(2)每个树的右子树与另一个树的左子树镜像对称。
        return helper(root, root);
    }

    private boolean helper(TreeNode t1, TreeNode t2) {
//      1.找终止条件(两个二叉树都为空时返回True，只有一个为空时返回False)
        if (t1 == null && t2 == null)
            return true;
        if (t1 == null || t2 == null)
            return false;
//      2.找返回值(返回子树是否为对称二叉树)
//      3.本级递归应该做什么(1.判断根节点的值是否相等 2.判断A的右子树和B的左子树是否对称 3.判断A的左子树和B的右子树是否对称)
        return t1.val == t2.val && helper(t1.left, t2.right) && helper(t1.right, t2.left);
    }

    private boolean isSymmetric2(TreeNode root) {
        // 使用队列进行迭代
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode t1 = queue.poll();
            TreeNode t2 = queue.poll();
            if (t1 == null && t2 == null)
                continue;
            if (t1 == null || t2 == null)
                return false;
            if (t1.val != t2.val)
                return false;
            queue.offer(t1.left);
            queue.offer(t2.right);
            queue.offer(t1.right);
            queue.offer(t2.left);
        }
        return true;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(9);
        root.left = new TreeNode(-42);
        root.right = new TreeNode(-42);
        root.left.right = new TreeNode(76);
        root.right.left = new TreeNode(76);
        root.left.right.right = new TreeNode(13);

        _0101 Sol = new _0101();
        System.out.println(Sol.isSymmetric2(root));
    }
}
