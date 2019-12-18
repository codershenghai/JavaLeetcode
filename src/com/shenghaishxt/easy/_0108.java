package com.shenghaishxt.easy;

import com.shenghaishxt.structure.TreeNode;

import java.util.Arrays;

public class _0108 {
    /**
     * 二分法
     * 二叉搜索树的中序遍历是递增序列
     */
    private TreeNode sortedArrayToBST(int[] nums) {
        // 递归终止的条件
        int len = nums.length;
        if (len == 0) return null;

        // 找返回值
        // 本级递归应该做什么
        TreeNode root = new TreeNode(nums[len/2]);
        root.left = sortedArrayToBST(Arrays.copyOfRange(nums, 0, len/2));
        root.right = sortedArrayToBST(Arrays.copyOfRange(nums, len/2+1, len));
        return root;
    }

    public static void main(String[] args) {
        _0108 Sol = new _0108();
        int[] nums = new int[] {-10,-3,0,5,9};
        TreeNode root = Sol.sortedArrayToBST(nums);

        System.out.println(root);
    }
}
