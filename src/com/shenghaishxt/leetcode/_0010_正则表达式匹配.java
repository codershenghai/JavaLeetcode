package com.shenghaishxt.leetcode;

public class _0010_正则表达式匹配 {
    public boolean isMatch(String s, String p) {
        int sLength = s.length(), pLength = p.length();
        if (sLength == 0 && pLength == 0)
            return true;
        boolean[][] dp = new boolean[sLength+1][pLength+1];

        // 边界条件：
        // 初始化dp数组，两个空字符串一定匹配，故dp[0][0]=true
        // p为空时，两个字符串一定不匹配，故dp[i][0] = false
        // s为空且p中对应元素为星号时，p中的星号可以让星号前面一个元素消失，故dp[0][j]=dp[0][j-2]
        dp[0][0] = true;
        for (int j = 1; j <= pLength; j++) {
            if (p.charAt(j-1) == '*')
                dp[0][j] = dp[0][j-2];
        }

        for (int i = 1; i <= sLength; i++) {
            for (int j = 1; j <= pLength; j++) {
                // 若s对应元素与p对应元素相等，即s[i-1] == p[j-1]
                if (s.charAt(i-1) == p.charAt(j-1))
                    dp[i][j] = dp[i-1][j-1];

                    // 若s对应元素与p对应元素不相等，即s[i-1] != p[j-1]
                else {
                    // 当p中对应字符为点时，相当于s[i-1] == p[j-1]
                    if (p.charAt(j-1) == '.')
                        dp[i][j] = dp[i-1][j-1];

                        // 当p中对应字符为星号时，分情况讨论
                    else if (p.charAt(j-1) == '*') {
                        // 只有在s当前元素与p中星号前面的一个元素匹配时，让星号匹配1个或n个前面的那个字符
                        if (s.charAt(i-1) == p.charAt(j-2) || p.charAt(j-2) == '.')
                            dp[i][j] = dp[i][j-1] || dp[i-1][j];
                        // 不论s当前元素与p中星号前面的一个元素是否匹配，都将星号和星号前面的一个字符删除，让星号匹配0个前面的那个字符
                        dp[i][j] = dp[i][j] || dp[i][j-2];
                    }

                    // p中对应字符不为点也不为星号，两个字符一定不相等
                    else dp[i][j] = false;
                }
            }
        }
        return dp[sLength][pLength];
    }
}
