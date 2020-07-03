package com.shenghaishxt.sort;

import java.util.Arrays;

/**
 * 数组中的第k个最大元素
 */
public class _0215 {
    // API
    public int findKthLargest1(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length-k];
    }

    // 快排
    public int findKthLargest2(int[] nums, int k) {
        int target = nums.length - k;
        int pivotPos = partition(nums, 0, nums.length-1);
        while (target < nums.length && pivotPos != target) {
            if (pivotPos > target) pivotPos = partition(nums, 0, pivotPos-1);
            else pivotPos = partition(nums, pivotPos+1, nums.length-1);
        }
        return nums[pivotPos];
    }

    private int partition(int[] nums, int left, int right) {
        int pivot = nums[left];
        while (left < right) {
            while (left < right && nums[right] >= pivot) right--;
            nums[left] = nums[right];
            while (left < right && nums[left] <= pivot) left++;
            nums[right] = nums[left];
        }
        nums[left] = pivot;
        return left;
    }

    public static void main(String[] args) {
        System.out.println(new _0215().findKthLargest2(new int[] {3,2,1,5,6,4}, 2));
        System.out.println(new _0215().findKthLargest2(new int[] {3,2,3,1,2,4,5,5,6}, 4));
    }
}
