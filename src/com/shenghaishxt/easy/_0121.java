package com.shenghaishxt.easy;

public class _0121 {
    // 动态规划
    private int maxProfit(int[] prices) {
        if (prices.length == 0)
            return 0;
        int[] dp = new int[prices.length];
        int maxPro = 0;
        dp[0] = 0;

        // dp[i] = max(dp[i-1] + prices[i] - price[i-1], 0)
        for (int i = 1; i < prices.length; i++) {
            dp[i] = Math.max(dp[i-1] + prices[i] - prices[i-1], 0);
            maxPro = Math.max(maxPro, dp[i]);
        }
        return maxPro;
    }

    public static void main(String[] args) {
        _0121 Sol = new _0121();
        System.out.println(Sol.maxProfit(new int[] {7,6,4,3,1}));
    }
}
