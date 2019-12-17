package com.shenghaishxt.easy;

public class _0122 {
    // 动态规划
    private int maxProfit1(int[] prices) {
        if (prices.length == 0)
            return 0;
        int[] dp = new int[prices.length];
        dp[0] = 0;

        // dp[i] = max(dp[i-1] + price[i] - price[i-1], dp[i-1])
        for (int i = 1; i < prices.length; i++)
            dp[i] = Math.max(dp[i-1] + prices[i] - prices[i-1], dp[i-1]);
        return dp[prices.length-1];
    }

    // 贪心
    private int maxProfit2(int[] prices) {
        int maxPro = 0;
        for (int i = 1; i < prices.length; i++) {
            int diff = prices[i] - prices[i-1];
            if (diff > 0)
                maxPro += diff;
        }
        return maxPro;
    }

    public static void main(String[] args) {
        _0122 Sol = new _0122();
        System.out.println(Sol.maxProfit2(new int[] {7,1,5,3,6,4}));
    }
}
