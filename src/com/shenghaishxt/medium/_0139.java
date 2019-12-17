package com.shenghaishxt.medium;

import java.util.ArrayList;
import java.util.List;

public class _0139 {
    private boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length()+1];
        dp[0] = true;

        // dp[i] = dp[j] && wordDict.contains(s[j, i])
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordDict.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }

    public static void main(String[] args) {
        _0139 Sol = new _0139();
        List<String> wordDict = new ArrayList<>();
        wordDict.add("cats");
        wordDict.add("dog");
        wordDict.add("sand");
        wordDict.add("and");
        wordDict.add("cat");
        String s = "catsandog";
        boolean res = Sol.wordBreak(s, wordDict);
        System.out.println(res);
    }
}
