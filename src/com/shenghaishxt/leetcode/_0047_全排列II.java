package com.shenghaishxt.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
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

public class _0047_全排列II {
    private List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        dfs(nums, new ArrayList<>(), new boolean[nums.length]);
        return res;
    }

    private void dfs(int[] nums, List<Integer> path, boolean[] visited) {
        if (path.size() == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!visited[i]) {
                if (i > 0 && nums[i] == nums[i-1] && visited[i-1]) continue;
                path.add(nums[i]);
                visited[i] = true;
                dfs(nums, path, visited);
                path.remove(path.size()-1);
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new _0047_全排列II().permuteUnique(new int[] {1,2,1}));
    }
}
