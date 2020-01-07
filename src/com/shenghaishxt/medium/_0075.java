package com.shenghaishxt.medium;

import java.util.Arrays;

public class _0075 {
    // 三指针一次遍历
    private void sortColors(int[] nums) {
        int cur = 0, left = 0, right = nums.length-1;
        while (cur <= right) {
            if (nums[cur] == 2) {
                int temp = nums[cur];
                nums[cur] = nums[right];
                nums[right--] = temp;
            }
            else if (nums[cur] == 0) {
                int temp = nums[cur];
                nums[cur++] = nums[left];
                nums[left++] = temp;
            }
            else cur++;
        }
    }

    public static void main(String[] args) {
        _0075 Sol = new _0075();
        int[] nums = {2,0,2,1,1,0};
        Sol.sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }
}
