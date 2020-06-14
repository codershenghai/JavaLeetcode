package com.shenghaishxt.dp;

import java.util.Arrays;

public class _0053_最大子序和 {
    public int maxSubArray(int[] nums) {
        if (nums.length == 0) return 0;
        int[] dp = new int[nums.length];
        dp[0] = nums[0];

        // dp[i]定义为以nums[i]为结尾的最大子数组和
        // dp[i]有两种选择，要么与前面的相邻子数组连接，形成一个和更大的子数组；要么自成一派，自己成为一个子数组。
        // dp[i] = max(nums[i], nums[i]+dp[i-1])
        for (int i = 1; i < dp.length; i++) {
            dp[i] = Math.max(nums[i], dp[i-1] + nums[i]);
        }
        return Arrays.stream(dp).max().getAsInt();
    }

    public static void main(String[] args) {
        System.out.println(new _0053_最大子序和().maxSubArray(new int[] {-2,1,-3,4,-1,2,1,-5,4}));
    }
}
