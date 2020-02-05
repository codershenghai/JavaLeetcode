package com.shenghaishxt.easy;

import java.util.Arrays;

public class _0189 {
    private void rotate(int[] nums, int k) {
        int temp, previous;
        for (int i = 0; i < k; i++) {
            previous = nums[nums.length-1];
            for (int j = 0; j < nums.length; j++) {
                temp = nums[j];
                nums[j] = previous;
                previous = temp;
            }
        }
        System.out.println(Arrays.toString(nums));
    }

    public static void main(String[] args) {
        _0189 Sol = new _0189();
        int[] nums = {1,2,3,4,5,6,7};
        int k = 3;
        Sol.rotate(nums, k);
    }
}
