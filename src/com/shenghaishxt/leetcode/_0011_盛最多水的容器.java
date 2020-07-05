package com.shenghaishxt.leetcode;

public class _0011_盛最多水的容器 {
    // 暴力
    public int maxArea1(int[] height) {
        int maxArea = 0;
        for (int i = 0; i < height.length; i++) {
            for (int j = i+1; j < height.length; j++) {
                int h = Math.min(height[i], height[j]);
                int l = j - i;
                maxArea = Math.max(maxArea, h * l);
            }
        }
        return maxArea;
    }

    // 双指针法，每次向内收窄短板
    public int maxArea2(int[] height) {
        int maxArea = 0, left = 0, right = height.length - 1;
        while (left < right) {
            int h = Math.min(height[left], height[right]);
            int l = right - left;
            maxArea = Math.max(maxArea, h * l);
            if (height[left] < height[right]) left++;
            else right--;
        }
        return maxArea;
    }

    public static void main(String[] args) {
        System.out.println(new _0011_盛最多水的容器().maxArea2(new int[] {1,8,6,2,5,4,8,3,7}));
    }
}
