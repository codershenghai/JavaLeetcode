package com.shenghaishxt.hard;

public class _0042 {

    // 暴力法 时间复杂度O(N^2)，空间复杂度O(1)
    // water[i] = min(左边最高的柱子高度, 右边最高的柱子高度) - height[i]
    private int trap1(int[] height) {
        int water = 0;
        for (int i = 0; i < height.length; i++) {
            int left = 0, right = 0;

            for (int j = 0; j <= i; j++)
                left = Math.max(left, height[j]);

            for (int j = height.length-1; j >= i; j--)
                right = Math.max(right, height[j]);

            if (left > 0 && right > 0)
                water += Math.min(left, right) - height[i];
        }
        return water;
    }

    // 备忘录优化 时间复杂度O(n)，空间复杂度O(n)
    private int trap2(int[] height) {
        int len = height.length, water = 0;
        if (len == 0)
            return water;

        // left_max[i]和right_max[i]分别表示位置i左边和右边最高的数组长度
        int[] left_max = new int[len], right_max = new int[len];
        left_max[0] = height[0];
        right_max[len-1] = height[len-1];
        for (int i = 1; i < len; i++)
            left_max[i] = Math.max(left_max[i-1], height[i]);
        for (int i = len-2; i >= 0; i--)
            right_max[i] = Math.max(right_max[i+1], height[i]);

        for (int i = 0; i < len; i++)
            water += Math.min(left_max[i], right_max[i]) - height[i];
        return water;
    }

    public static void main(String[] args) {
        _0042 Sol = new _0042();
//        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        int[] height = {};
        int res = Sol.trap2(height);
        System.out.println(res);
    }
}
