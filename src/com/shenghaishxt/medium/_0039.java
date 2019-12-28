package com.shenghaishxt.medium;

import java.util.*;

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
public class _0039 {
    private Set<List<Integer>> res = new HashSet<>();

    private List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates.length == 0)
            return new ArrayList<>();
        ArrayList<Integer> cur = new ArrayList<>();

        backTrack(cur, candidates, target);
        return new ArrayList<>(res);
    }

    private void backTrack(ArrayList<Integer> cur, int[] candidates, int target) {
        if (getSum(cur) == target) {
            List<Integer> newCur = new ArrayList<>(cur);
            Collections.sort(newCur);
            res.add(new ArrayList<>(newCur));
            return;
        }

        for (int candidate : candidates) {
            if (getSum(cur) > target)
                return;
            cur.add(candidate);
            backTrack(cur, candidates, target);
            cur.remove(cur.size()-1);
        }
    }

    private int getSum(ArrayList<Integer> cur) {
        int sum = 0;
        for (int i : cur)
            sum += i;
        return sum;
    }

    public static void main(String[] args) {
        _0039 Sol = new _0039();
        int[] candidates = {1,2};
        int target = 4;
        List<List<Integer>> res = Sol.combinationSum(candidates, target);
        System.out.println(res);
    }
}
