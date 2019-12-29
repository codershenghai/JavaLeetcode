package com.shenghaishxt.medium;

import java.util.Stack;

public class _0060 {
    // 参考 https://leetcode-cn.com/problems/permutation-sequence/solution/hui-su-jian-zhi-python-dai-ma-java-dai-ma-by-liwei/https://leetcode-cn.com/problems/permutation-sequence/solution/hui-su-jian-zhi-python-dai-ma-java-dai-ma-by-liwei/
    private int[] factorial = {1, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880};

    private String getPermutation(int n, int k) {
        return dfs(n, k, new boolean[n], new Stack<Integer>());
    }

    private String dfs(int n, int k, boolean[] visited, Stack<Integer> path) {
        if (path.size() == n) {
            StringBuilder res = new StringBuilder();
            for (Integer i : path)
                res.append(i);
            return res.toString();
        }
        int ps = factorial[n-1-path.size()];
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                if (ps < k) {
                    k -= ps;
                    continue;
                }
                path.push(i+1);
                visited[i] = true;
                return dfs(n, k, visited, path);
            }
        }
        return "";
    }

    public static void main(String[] args) {
        _0060 Sol = new _0060();
        int n = 4, k = 9;
        String res = Sol.getPermutation(n, k);
        System.out.println(res);
    }
}
