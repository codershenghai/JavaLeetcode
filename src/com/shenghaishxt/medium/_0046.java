package com.shenghaishxt.medium;


import java.util.ArrayList;
import java.util.List;

public class _0046 {
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
    private List<List<Integer>> res = new ArrayList<>();

    private List<List<Integer>> permute(int[] nums) {
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
            // 剪枝
            if (track.contains(num))
                continue;

            // 做选择
            track.add(num);

            // backtrack
            backTrack(track, nums);

            // 撤销选择
            track.remove(track.size()-1);
        }
    }

    public static void main(String[] args) {
        _0046 Sol = new _0046();
        int[] nums = new int[] {1,2,3};
        List<List<Integer>> res = Sol.permute(nums);
        System.out.println(res);
    }
}
