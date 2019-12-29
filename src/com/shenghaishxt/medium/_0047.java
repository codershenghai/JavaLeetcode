package com.shenghaishxt.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class _0047 {
    // 参考 https://leetcode-cn.com/problems/permutations-ii/solution/hui-su-suan-fa-python-dai-ma-java-dai-ma-by-liwe-2/
    private List<List<Integer>> res = new ArrayList<>();

    private List<List<Integer>> permuteUnique(int[] nums) {
        if (nums.length == 0)
            return res;
        boolean[] visited = new boolean[nums.length];
        Arrays.sort(nums);
        dfs(new Stack<>(), nums, visited);
        return res;
    }

    private void dfs(Stack<Integer> path, int[] nums, boolean[] visited) {
        if (path.size() == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!visited[i]) {
                if (i > 0 && nums[i] == nums[i-1] && visited[i-1])
                    continue;
                path.push(nums[i]);
                visited[i] = true;
                dfs(path, nums, visited);
                path.pop();
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        _0047 Sol = new _0047();
        int[] nums = {1,1,2};
//        int[] nums = {3,3,0,3};
        List<List<Integer>> res = Sol.permuteUnique(nums);
        System.out.println(res);
    }
}
