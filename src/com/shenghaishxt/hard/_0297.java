package com.shenghaishxt.hard;

import com.shenghaishxt.structure.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class _0297 {
    public String serialize(TreeNode root) {
        StringBuilder builder = new StringBuilder();
        serializeHelper(root, builder);
        return builder.toString();
    }

    private void serializeHelper(TreeNode node, StringBuilder builder) {
        if (node == null) {
            builder.append("#,");
            return;
        }
        builder.append(node.val).append(',');
        serializeHelper(node.left, builder);
        serializeHelper(node.right, builder);
    }

    public TreeNode deserialize(String str) {
        return deserializeHelper(new StringBuilder(str));
    }

    private TreeNode deserializeHelper(StringBuilder builder) {
        // 递归终止条件
        if (builder.length() == 0)
            return null;

        // 处理空节点
        if (builder.charAt(0) == '#') {
            builder.delete(0,2);
            return null;
        }

        // 取出当前根节点的值存进num
        int index = builder.indexOf(",");
        int num = Integer.parseInt(builder.substring(0,index));
        builder.delete(0,index+1);

        // 先序遍历
        TreeNode root = new TreeNode(num);
        root.left = deserializeHelper(builder);
        root.right = deserializeHelper(builder);
        return root;
    }

    public static void main(String[] args) {
        _0297 Sol = new _0297();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        System.out.println(Sol.serialize(root));

//        TreeNode res = Sol.Deserialize("1,2,3,#,#,4,#,#,-5,#,#,");
//        TreeNode res = Sol.Deserialize("-1,0,1,");
        TreeNode res = Sol.deserialize("12,9,2,8,10,");
//        TreeNode res = Sol.Deserialize("#,");
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(res);
        while (!queue.isEmpty()) {
            TreeNode p = queue.poll();
            System.out.println(p.val);
            if (p.left != null)
                queue.offer(p.left);
            if (p.right != null)
                queue.offer(p.right);
        }
    }
}
