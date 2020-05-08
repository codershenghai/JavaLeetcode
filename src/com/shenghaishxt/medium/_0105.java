package com.shenghaishxt.medium;

import com.shenghaishxt.structure.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class _0105 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return buildTreeHelper(preorder, 0, preorder.length-1,
                inorder, 0, inorder.length-1,
                map);
    }

    private TreeNode buildTreeHelper(int[] preorder, int preStart, int preEnd,
                                     int[] inorder, int inStart, int inEnd,
                                     Map<Integer, Integer> map) {
        if (preStart > preEnd || inStart > inEnd) return null;

        TreeNode root = new TreeNode(preorder[preStart]);

        // 寻找根节点在中序遍历序列中的位置
        int index = map.get(root.val);

        // 递归构造左子树和右子树
        int leftLength = index - inStart;
        root.left = buildTreeHelper(preorder, preStart+1, preStart+leftLength,
                inorder, inStart, index-1, map);
        root.right = buildTreeHelper(preorder, preStart+leftLength+1, preEnd,
                inorder, index+1, inEnd, map);
        return root;
    }

    public static void main(String[] args) {
        _0105 Sol = new _0105();
//        int[] pre = {1,2,4,7,3,5,6,8};
//        int[] in = {4,7,2,1,5,3,8,6};
        int[] pre = {1,2,3};
        int[] in = {3,2,1};
        TreeNode res = Sol.buildTree(pre, in);
        System.out.println(res);
    }
}
