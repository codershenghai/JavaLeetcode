package com.shenghaishxt.medium;

public class _0162 {
    // 找最大值的下标，时间复杂度为O(n)
    public int findPeakElement1(int[] nums) {
        int maxValue = Integer.MIN_VALUE, index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > maxValue) {
                maxValue = nums[i];
                index = i;
            }
        }
        return index;
    }

    // 二分法，时间复杂度为log(n)
    public int findPeakElement(int[] nums) {
        int left = 0, right = nums.length-1, mid;
        while (left < right) {
            mid = (left + right) >> 1;
            if (nums[mid] > nums[mid+1]) right = mid;
            else left = mid + 1;
        }
        return left;
    }

    public static void main(String[] args) {
        int res1 = new _0162().findPeakElement(new int[] {1,2,3,1});
        int res2= new _0162().findPeakElement(new int[] {1,2,3});
        int res3= new _0162().findPeakElement(new int[] {1,2});
        int res4= new _0162().findPeakElement(new int[] {2,1});
        int res5= new _0162().findPeakElement(new int[] {1});
        System.out.println(res1);
    }
}
