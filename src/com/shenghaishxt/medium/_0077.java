package com.shenghaishxt.medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class _0077 {
    private List<List<Integer>> res = new ArrayList<>();

    private List<List<Integer>> combine(int n, int k) {
        backTrack(new Stack<>(), n, k, 1);
        return res;
    }

    private void backTrack(Stack<Integer> track, int n, int k, int start) {
        if (track.size() == k) {
            res.add(new ArrayList<>(track));
            return;
        }

        for (int i = start; i <= n; i++) {
            if (!track.empty() && track.peek() >= i)
                continue;
            track.push(i);
            backTrack(track, n, k, start+1);
            track.pop();
        }
    }

    public static void main(String[] args) {
        _0077 Sol = new _0077();
        int n = 4, k = 2;
        List<List<Integer>> res = Sol.combine(n, k);
        System.out.println(res);
    }
}
