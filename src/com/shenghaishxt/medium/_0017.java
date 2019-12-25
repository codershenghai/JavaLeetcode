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
public class _0017 {
    private String[] letterMap = {
            "",
            "",
            "abc",  //2
            "def",  //3
            "ghi",  //4
            "jkl",  //5
            "mno",  //6
            "pqrs", //7
            "tuv",  //8
            "wxyz"  //9
    };
    private List<String> res = new ArrayList<>();
    private List<String> letterCombinations(String digits) {
        if (digits.equals(""))
            return res;
        StringBuilder sb = new StringBuilder();

        backTrack(sb, digits, 0);
        return res;
    }

    private void backTrack(StringBuilder sb, String digits, int index) {
        if (sb.length() == digits.length()) {
            res.add(sb.toString());
            return;
        }
        String letters = letterMap[digits.charAt(index) - '0'];
        for (int i = 0; i < letters.length(); i++) {
            sb.append(letters.charAt(i));
            backTrack(sb, digits, index+1);
            sb.deleteCharAt(sb.length()-1);
        }
    }

    public static void main(String[] args) {
        _0017 Sol = new _0017();
        String digits = "23";
        System.out.println(Sol.letterCombinations(digits));
    }
}
