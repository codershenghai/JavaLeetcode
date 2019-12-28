package com.shenghaishxt.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class _0047 {
    // 参考 https://leetcode-cn.com/problems/permutations-ii/solution/hui-su-suan-fa-python-dai-ma-java-dai-ma-by-liwe-2/
    private List<List<Integer>> res = new ArrayList<>();
    private boolean[] used;

    private List<List<Integer>> permuteUnique(int[] nums) {
        used = new boolean[nums.length];
        Arrays.sort(nums);
        backTrack(new Stack<>(), nums);
        return res;
    }

    private void backTrack(Stack<Integer> cur, int[] nums) {
        if (cur.size() == nums.length) {
            res.add(new ArrayList<>(cur));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!used[i]) {
                // 剪枝的效果是去重
                if (i > 0 && nums[i] == nums[i-1] && used[i-1])
                    continue;
                used[i] = true;
                cur.push(nums[i]);
                backTrack(cur, nums);
                cur.pop();
                used[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        _0047 Sol = new _0047();
//        int[] nums = {1,1,2};
        int[] nums = {3,3,0,3};
        List<List<Integer>> res = Sol.permuteUnique(nums);
        System.out.println(res);
    }
}
