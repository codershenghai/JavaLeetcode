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
public class _0040 {
    private List<List<Integer>> res = new ArrayList<>();

    private List<List<Integer>> combinationSum2(int[] candidates, int target) {
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
            if (i > begin && candidates[i] == candidates[i-1])
                continue;
            cur.push(candidates[i]);
            backTrack(cur, candidates, residue-candidates[i], i+1);
            cur.pop();
        }
    }

    public static void main(String[] args) {
        _0040 Sol = new _0040();
        int[] candidates = {10,1,2,7,6,1,5};
        int target = 8;
        List<List<Integer>> res = Sol.combinationSum2(candidates, target);
        System.out.println(res);
    }
}
