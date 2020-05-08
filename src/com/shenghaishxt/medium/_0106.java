package com.shenghaishxt.medium;

import com.shenghaishxt.structure.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class _0106 {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return buildTreeHelper(inorder, 0, inorder.length-1,
                               postorder, 0, postorder.length-1,
                               map);
    }

    private TreeNode buildTreeHelper(int[] inorder, int inStart, int inEnd,
                                     int[] postorder, int postStart, int postEnd,
                                     Map<Integer, Integer> map) {
        if (postStart > postEnd || inStart > inEnd) return null;

        TreeNode root = new TreeNode(postorder[postEnd]);

        // 寻找根节点在中序遍历序列中的位置
        int index = map.get(root.val);

        // 递归构造左子树和右子树
        int leftLength = index - inStart;
        root.left = buildTreeHelper(inorder, inStart, index-1,
                                    postorder, postStart, postStart+leftLength-1,
                                    map);
        root.right = buildTreeHelper(inorder, index+1, inEnd,
                                     postorder, postStart+leftLength, postEnd-1,
                                     map);
        return root;
    }

    public static void main(String[] args) {
        _0106 Sol = new _0106();
        int[] inorder = {9,3,15,20,7};
        int[] postorder = {9,15,7,20,3};
        TreeNode res = Sol.buildTree(inorder, postorder);
        System.out.println(res);
    }
}
