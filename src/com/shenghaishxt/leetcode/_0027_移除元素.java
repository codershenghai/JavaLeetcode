package com.shenghaishxt.leetcode;

public class _0027_移除元素 {
    public int removeElement(int[] nums, int val) {
        int cur = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[cur++] = nums[i];
            }
        }
        return cur;
    }

    public static void main(String[] args) {
        System.out.println(new _0027_移除元素().removeElement(new int[] {3,2,2,3}, 2));
        System.out.println(new _0027_移除元素().removeElement(new int[] {0,1,2,2,3,0,4,2}, 2));
    }
}
