package com.shenghaishxt.easy;

public class _0121 {
    // 暴力法
    private int maxProfit1(int[] prices) {
        int max_profit = 0;
        for (int i = 0; i < prices.length; i++) {
            for (int j = i+1; j < prices.length; j++) {
                if (prices[j] - prices[i] > max_profit)
                    max_profit = prices[j] - prices[i];
            }
        }
        return max_profit;
    }

    // https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/solution/yi-ge-fang-fa-tuan-mie-6-dao-gu-piao-wen-ti-by-l-3/
    private int maxProfit2(int[] prices) {
        return 0;
    }

    public static void main(String[] args) {
        _0121 Sol = new _0121();
        System.out.println(Sol.maxProfit2(new int[] {7,1,5,3,6,4}));
    }
}
