package com.shenghaishxt.medium;

import java.util.Arrays;

public class _0031 {
    public void nextPermutation(int[] nums) {
        if (nums.length < 2)
            return;
        // 从右往左找到第一个倒序的数字i
        boolean flag = true;
        int splitPos = 0;
        for (int i = nums.length-2; i >= 0; i--) {
            if (nums[i] < nums[i+1]) {
                splitPos = i+1;
                flag = false;
                break;
            }
        }
        // 如果已经全部是倒序，则对数组排序，返回最小的排列
        if (flag) {
            Arrays.sort(nums);
            System.out.println(Arrays.toString(nums));
            return;
        }
        // 找到右边最小的数字j（但是比i大，此时i是nums[splitPos-1]）
        int minPos = splitPos;
        for (int i = splitPos+1; i < nums.length; i++) {
            if (nums[i] > nums[splitPos-1] && nums[i] < nums[minPos]) {
                minPos = i;
            }
        }
        // 交换i和j
        int temp = nums[splitPos-1];
        nums[splitPos-1] = nums[minPos];
        nums[minPos] = temp;

        // 对后半部分进行排序
        int[] rear = Arrays.copyOfRange(nums, splitPos, nums.length);
        Arrays.sort(rear);
        for (int i = splitPos, j = 0; i < nums.length && j < rear.length; i++, j++) {
            nums[i] = rear[j];
        }
        System.out.println(Arrays.toString(nums));
    }

    public static void main(String[] args) {
        new _0031().nextPermutation(new int[]{1,3,2}); //[2,1,3]
        new _0031().nextPermutation(new int[]{5,1,1}); //[1,1,5]
        new _0031().nextPermutation(new int[]{2,3,1}); //[3,1,2]
        new _0031().nextPermutation(new int[]{3,2,1}); //[1,2,3]
        new _0031().nextPermutation(new int[]{1,2,3,4,5,6}); //[1,2,3,4,6,5]
        new _0031().nextPermutation(new int[]{1,5,3,2,1,6,5}); //[1,5,3,2,5,1,6]
    }
}
