package com.shenghaishxt.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 回溯算法的框架：
 * result = []
 * def backtrack(路径, 选择列表):
 *     if 满足结束条件:
 *         result.add(路径)
 *         return
 *
 *     for 选择 in 选择列表:
 *         做选择
 *         backtrack(路径, 选择列表)
 *         撤销选择
 */

public class _0046_全排列 {
    private List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        backTrack(nums, new ArrayList<>());
        return res;
    }

    private void backTrack(int[] nums, List<Integer> path) {
        if (path.size() == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int num : nums) {
            if (path.contains(num)) continue;
            path.add(num);
            backTrack(nums, path);
            path.remove(path.size()-1);
        }
    }

    // 最标准的回溯
    // 回溯法 = dfs+状态重置+剪枝
    // 参考 https://leetcode-cn.com/problems/permutations/solution/hui-su-suan-fa-python-dai-ma-java-dai-ma-by-liweiw/
    private List<List<Integer>> res2 = new ArrayList<>();
    public List<List<Integer>> permute2(int[] nums) {
        dfs(nums, new ArrayList<>(), new boolean[nums.length]);
        return res2;
    }

    private void dfs(int[] nums, List<Integer> path, boolean[] visited) {
        if (path.size() == nums.length) {
            res2.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) continue;
            path.add(nums[i]);
            visited[i] = true;
            dfs(nums, path, visited);
            path.remove(path.size()-1);
            visited[i] = false;
        }
    }

    public static void main(String[] args) {
        System.out.println(new _0046_全排列().permute2(new int[] {1,2,3}));
    }
}
