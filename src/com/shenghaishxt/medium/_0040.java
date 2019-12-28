package com.shenghaishxt.medium;

import java.util.*;

public class _0040 {
    private List<List<Integer>> res = new ArrayList<>();

    private List<List<Integer>> combinationSum2(int[] candidates, int target) {
        if (candidates.length == 0)
            return new ArrayList<>();
        Arrays.sort(candidates);
        backTrack(new ArrayList<>(), candidates, target, 0);
        return res;
    }

    private void backTrack(ArrayList<Integer> cur, int[] candidates, int residue, int begin) {
        if (residue == 0) {
            res.add(new ArrayList<>(cur));
            return;
        }

        for (int i = begin; i < candidates.length && residue-candidates[i] >= 0; i++) {
            if (i > begin && candidates[i] == candidates[i-1])
                continue;
            cur.add(candidates[i]);
            backTrack(cur, candidates, residue-candidates[i], i+1);
            cur.remove(cur.size()-1);
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
