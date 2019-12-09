package com.shenghaishxt.easy;

public class _0152 {
    private int maxProduct(int[] nums) {
        int max_val = nums[0];
        int[] f = new int[nums.length];
        int[] g = new int[nums.length];
        f[0] = nums[0];
        g[0] = nums[0];

        // 遇到负数时，最小值乘上负数才是当前最大值，所以需要维护一个最小值数组
        // f[i] = max(f[i-1]*nums[i], nums[i])
        // g[i] = min(f[i-1]*nums[i], nums[i])
        for (int i=1; i<nums.length; i++) {
            if (nums[i] > 0) {
                f[i] = Math.max(f[i-1]*nums[i], nums[i]);
                g[i] = Math.min(g[i-1]*nums[i], nums[i]);
            } else {
                f[i] = Math.max(g[i-1]*nums[i], nums[i]);
                g[i] = Math.min(f[i-1]*nums[i], nums[i]);
            }
            if (f[i] > max_val)
                max_val = f[i];
        }
        return max_val;
    }

    public static void main(String[] args) {
        _0152 Sol = new _0152();
        int res = Sol.maxProduct(new  int[] {-3, 1, -2});
        System.out.println(res);
    }
}
