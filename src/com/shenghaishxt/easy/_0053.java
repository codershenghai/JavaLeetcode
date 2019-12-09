package com.shenghaishxt.easy;

import java.util.Arrays;

public class _0053 {
    private int maxSubArray(int[] nums) {
        int[] f = new int[nums.length];
        f[0] = nums[0];
        int max_val = nums[0];

        // f[i] = max(f[i-1]+nums[i], nums[i])
        for (int i=1; i<nums.length; i++) {
            f[i] = Math.max(f[i-1]+nums[i], nums[i]);
            if (f[i] > max_val)
                max_val = f[i];
        }
        return max_val;
    }

    public static void main(String[] args) {
        _0053 Sol = new _0053();
        System.out.println(Sol.maxSubArray(new int[] {1}));
        System.out.println(Sol.maxSubArray(new int[] {-2,1,-3,4,-1,2,1,-5,4}));
    }
}
