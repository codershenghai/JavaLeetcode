package com.shenghaishxt.medium;

public class _0055 {
    // 动态规划
    private boolean canJump1(int[] nums) {
        boolean[] f = new boolean[nums.length];
        f[0] = true;

        // f[i] = f[j] && j+nums[j] >= i
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (f[j] && j+nums[j] >= i) {
                    f[i] = true;
                    break;
                }
            }
        }
        return f[nums.length-1];
    }

    // 贪心
    private boolean canJump2(int[] nums) {
        // 遍历数组，找到能够达到的最远距离
        int longest_dist = 0;
        for (int i = 0; i < nums.length-1; i++) {
            if (i > longest_dist)
                return false;
            longest_dist = Math.max(longest_dist, i+nums[i]);
        }
        return longest_dist >= nums.length-1;
    }

    public static void main(String[] args) {
        _0055 Sol = new _0055();
        System.out.println(Sol.canJump2(new int[] {0,2,3}));
    }
}
