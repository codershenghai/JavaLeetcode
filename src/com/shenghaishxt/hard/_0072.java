package com.shenghaishxt.hard;

public class _0072 {
    /**
     * 两个字符串的动态规划问题
     * 一般都是用两个指针 i,j 分别指向两个字符串的最后
     * 然后一步步往前走，缩小问题的规模
     *
     * dp[i-1][j-1]：替换或跳过
     * dp[i-1][j]：删除
     * dp[i][j-1]：插入
     *
     * 状态转移方程：
     * dp[i][j] = dp[i-1][j-1]                                  if word[i] == word[j]
     * dp[i][j] = min(dp[i-1][j-1], dp[i-1][j], dp[i][j-1])     if word[i] != word[j]
     */
    private int minDistance(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        int[][] dp = new int[m+1][n+1];
        for (int i = 0; i <= m; i++)
            dp[i][0] = i;
        for (int i = 0; i <= n; i++)
            dp[0][i] = i;

        // word.charAt(0)指向字符串的第一位，因此dp数组偏移一位
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i-1) == word2.charAt(j-1))
                    dp[i][j] = dp[i-1][j-1];
                else
                    dp[i][j] = Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i][j-1])) + 1;
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        _0072 Sol = new _0072();
        String word1 = "fxpimu", word2 = "xwrs";
        System.out.println(Sol.minDistance(word1, word2));
    }
}
