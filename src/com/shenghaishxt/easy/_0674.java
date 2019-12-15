package com.shenghaishxt.easy;

public class _0674 {
    private int findLengthOfLCIS(int[] nums) {
        if (nums.length == 0)
            return 0;
        int[] f = new int[nums.length];
        f[0] = 1;
        int res = f[0];

        // f[i] = max(1, f[i-1]+1)
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i-1])
                f[i] = f[i-1] + 1;
            else f[i] = 1;
            res = Math.max(f[i], res);
        }
        return res;
    }

    public static void main(String[] args) {
        _0674 Sol = new _0674();
        System.out.println(Sol.findLengthOfLCIS(new int[] {2,2,2,2,2}));
    }
}
