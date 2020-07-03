package com.shenghaishxt.dp;

public class _0091 {
    /**
     * 解码方法
     */
    public int numDecodings(String s) {
        char[] chars = s.toCharArray();
        if (chars[0] == '0') return 0;
        int[] dp = new int[chars.length];
        dp[0] = 1;

        /**
         *  f[i] += f[i-1]   if '1' <= s_arr[i]-'0' <= '9'  (分开译码)
         *  f[i] += f[i-2]   if '10' <= 10*(s_arr[i-1]-'0')+(s_arr[i]-'0') <= '26' (合并译码)
         *
         *  解释：当s[i-1]与s[i]分开译码时，f[i] = f[i-1]
         *       当s[i-1]与s[i]合并译码时，f[i] = f[i-2]
         */
        for (int i = 1; i < chars.length; i++) {
            int num1 = chars[i] - '0';
            int num2 = (chars[i-1] - '0') * 10 + num1;
            if (num1 >= 1 && num1 <= 9) dp[i] += dp[i-1];
            if (num2 >= 10 && num2 <= 26) {
                if (i-2 < 0) dp[i] += 1;
                else dp[i] += dp[i-2];
            }
        }
        return dp[dp.length-1];
    }

    public static void main(String[] args) {
        System.out.println(new _0091().numDecodings("0"));
        System.out.println(new _0091().numDecodings("10"));
        System.out.println(new _0091().numDecodings("12"));
        System.out.println(new _0091().numDecodings("226"));
    }
}
