package com.shenghaishxt.medium;


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

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

class Permute1 {
    private List<List<Integer>> res = new ArrayList<>();

    List<List<Integer>> permute(int[] nums) {
        ArrayList<Integer> track = new ArrayList<>();
        backTrack(track, nums);
        return res;
    }

    private void backTrack(ArrayList<Integer> track, int[] nums) {
        if (track.size() == nums.length) {
            res.add(new ArrayList<>(track));
            return;
        }
        for (int num : nums) {
            // 这种剪枝方法对于测试用例是[1,1]的返回结果为空
            if (track.contains(num))
                continue;

            track.add(num); //做选择
            backTrack(track, nums); //backtrack
            track.remove(track.size()-1); //撤销选择
        }
    }
}

class Permute2 {
    // 回溯法 = dfs+状态重置+剪枝
    // 参考 https://leetcode-cn.com/problems/permutations/solution/hui-su-suan-fa-python-dai-ma-java-dai-ma-by-liweiw/
    private List<List<Integer>> res = new ArrayList<>();

    List<List<Integer>> permute(int[] nums) {
        if (nums.length == 0)
            return res;
        boolean[] visited = new boolean[nums.length];
        dfs(new Stack<>(), nums, visited);
        return res;
    }

    private void dfs(Stack<Integer> path, int[] nums,  boolean[] visited) {
        if (path.size() == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!visited[i]) {
                path.push(nums[i]);
                visited[i] = true;
                dfs(path, nums, visited);
                path.pop();
                visited[i] = false;
            }
        }
    }
}

public class _0046 {
    public static void main(String[] args) {
        Permute1 Sol = new Permute1();
        int[] nums = new int[] {1,2,3};
        List<List<Integer>> res = Sol.permute(nums);
        System.out.println(res);
    }
}
