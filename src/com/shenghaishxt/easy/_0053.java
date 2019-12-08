package com.shenghaishxt.easy;

import java.util.Arrays;

public class _0053 {
    // 暴力法, 超出时间限制
    private int maxSubArray1(int[] nums) {
        int max_sum = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length+1; i++) {
            for (int j = i+1; j < nums.length+1; j++) {
                int[] sub_arr = Arrays.copyOfRange(nums, i, j);
                int sum = 0;
                for (int k = 0; k < sub_arr.length; k++) {
                    sum += sub_arr[k];
                }
                if (sum > max_sum) max_sum = sum;
            }
        }
        return max_sum;
    }

    // 动态规划
    // https://leetcode-cn.com/problems/maximum-subarray/solution/xiang-xi-jie-du-dong-tai-gui-hua-de-shi-xian-yi-li/
    // https://leetcode-cn.com/problems/maximum-subarray/solution/zui-da-zi-xu-he-cshi-xian-si-chong-jie-fa-bao-li-f/
    private int maxSubArray2(int[] nums) {
        int max_ending_here = nums[0], max_sum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            max_ending_here = Math.max(nums[i], max_ending_here + nums[i]);
            max_sum = Math.max(max_ending_here, max_sum);
        }
        return max_sum;
    }

    public static void main(String[] args) {
        _0053 Sol = new _0053();
        System.out.println(Sol.maxSubArray2(new int[] {1}));
        System.out.println(Sol.maxSubArray2(new int[] {-2,1,-3,4,-1,2,1,-5,4}));
    }
}
