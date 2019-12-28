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
    private List<List<Integer>> res = new ArrayList<>();

    private List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates.length == 0)
            return new ArrayList<>();
        Arrays.sort(candidates);
        backTrack(new Stack<>(), candidates, target, 0);
        return res;
    }

    private void backTrack(Stack<Integer> cur, int[] candidates, int residue, int begin) {
        if (residue == 0) {
            res.add(new ArrayList<>(cur));
            return;
        }

        for (int i = begin; i < candidates.length && residue-candidates[i] >= 0; i++) {
            cur.push(candidates[i]);
            backTrack(cur, candidates, residue-candidates[i], i);
            cur.pop();
        }
    }

    public static void main(String[] args) {
        _0039 Sol = new _0039();
        int[] candidates = {2,3,6,7};
        int target = 7;
        List<List<Integer>> res = Sol.combinationSum(candidates, target);
        System.out.println(res);
    }
}
