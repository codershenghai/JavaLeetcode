package com.shenghaishxt.medium;

import java.util.ArrayList;
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
public class _0022 {

    private List<String> res = new ArrayList<>();

    private List<String> generateParenthesis(int n) {
        if (n == 0)
            return res;

        backTrack("", n, n);
        return res;
    }

    private void backTrack(String cur, int left, int right) {
        if (left == 0 && right == 0) {
            res.add(cur);
            return;
        }
        // 不需要for循环，因为选择列表中只有left和right
        if (left > 0)
            backTrack(cur+"(", left-1, right);
        if (right > 0 && left < right)
            backTrack(cur+")", left, right-1);
    }

    public static void main(String[] args) {
        _0022 Sol = new _0022();
        int n = 3;
        List<String> res = Sol.generateParenthesis(n);
        System.out.println(res);
    }
}
