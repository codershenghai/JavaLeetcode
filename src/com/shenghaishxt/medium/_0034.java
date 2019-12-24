package com.shenghaishxt.medium;

import java.util.Arrays;

public class _0034 {
    // 暴力遍历
    private int[] searchRange1(int[] nums, int target) {
        int begin = -1, end = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                begin = i;
                break;
            }
        }

        for (int i = nums.length-1; i > -1; i--) {
            if (nums[i] == target) {
                end = i;
                break;
            }
        }
        return new int[] {begin, end};
    }

    // 二分查找
    private int[] searchRange2(int[] nums, int target) {
        int left = leftBound(nums, target);
        int right = rightBound(nums, target);
        return new int[] {left, right};
    }

    private int leftBound(int[] nums, int target) {
        if (nums.length == 0)
            return -1;
        int left = 0, right = nums.length;
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] >= target)
                right = mid;
            else if (nums[mid] < target)
                left = mid + 1;
        }
        if (left == nums.length)
            return -1;
        return nums[left] == target ? left : -1;
    }

    private int rightBound(int[] nums, int target) {
        if (nums.length == 0)
            return -1;
        int left = 0, right = nums.length;
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] <= target)
                left = mid + 1;
            else if (nums[mid] > target)
                right = mid;
        }
        if (right == 0)
            return -1;
        return nums[right-1] == target ? right-1 : -1;
    }

    public static void main(String[] args) {
        _0034 Sol = new _0034();
        int[] nums = new int[] {1};
        int target = 0;
        int[] res = Sol.searchRange2(nums, target);
        System.out.println(Arrays.toString(res));
    }
}
