package com.shenghaishxt.easy;

import java.util.Arrays;

public class _0053 {
    // 动态规划
    public int maxSubArray(int[] nums) {
        if (nums.length == 0) return 0;
        int[] dp = new int[nums.length];
        dp[0] = nums[0];

        // dp[i]定义为以nums[i]为结尾的最大子数组和
        // dp[i]有两种选择，要么与前面的相邻子数组连接，形成一个和更大的子数组；要么自成一派，自己成为一个子数组。
        // dp[i] = max(nums[i], nums[i]+dp[i-1])
        for (int i = 1; i < dp.length; i++) {
            dp[i] = Math.max(nums[i], nums[i] + dp[i-1]);
        }
        return Arrays.stream(dp).max().getAsInt();
    }


    // 贪心
    private int maxSubArray2(int[] nums) {
        int max_val = Integer.MIN_VALUE, sum = 0;

        for (int num : nums) {
            sum += num;
            max_val = Math.max(max_val, sum);
            if (sum < 0)
                sum = 0;
        }
        return max_val;
    }

    public static void main(String[] args) {
        _0053 Sol = new _0053();
        System.out.println(Sol.maxSubArray(new int[] {1}));  // 1
        System.out.println(Sol.maxSubArray(new int[] {-1}));  // -1
        System.out.println(Sol.maxSubArray(new int[] {-2,1}));  // 1
        System.out.println(Sol.maxSubArray(new int[] {-2,1,-3,4,-1,2,1,-5,4}));  // 6
    }
}
