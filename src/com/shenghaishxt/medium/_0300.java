package com.shenghaishxt.medium;

import java.util.Arrays;

public class _0300 {
    // dp[i]表示以nums[i]这个数结尾的最长递增子序列的长度
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);

        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        int LIS = 0;
        for (int value : dp) {
            LIS = Math.max(LIS, value);
        }
        return LIS;
    }

    public static void main(String[] args) {
        System.out.println(new _0300().lengthOfLIS(new int[] {10,9,2,5,3,7,101,18}));
        System.out.println(new _0300().lengthOfLIS(new int[] {9,8,7,6,5}));
    }
}
