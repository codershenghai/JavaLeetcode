package com.shenghaishxt.medium;

import java.util.Arrays;

public class _0016 {
    // 排序+双指针
    private int threeSumClosest(int[] nums, int target) {
        int dist = nums[0] + nums[1] + nums[2];
        int len = nums.length;
        Arrays.sort(nums);
        for (int i = 0; i < len; i++) {
            int left = i + 1, right = len - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (Math.abs(target - sum) < Math.abs(target - dist))
                    dist = sum;
                if (sum - target > 0)
                    right--;
                else if (sum - target < 0)
                    left++;
                else return sum;
            }
        }
        return dist;
    }

    public static void main(String[] args) {
        _0016 Sol = new _0016();
        int[] nums = {1,1,-1};
        int target = 2;
        System.out.println(Sol.threeSumClosest(nums, target));
    }
}
