package com.shenghaishxt.leetcode;

public class _0026_删除排序数组中的重复项 {
    // 快慢指针
    public int removeDuplicates(int[] nums) {
        int low = 0, fast = 1;
        while (fast < nums.length) {
            if (nums[fast] != nums[low]) {
                nums[++low] = nums[fast];
            }
            fast++;
        }
        return low+1;
    }

    public static void main(String[] args) {
        System.out.println(new _0026_删除排序数组中的重复项().removeDuplicates(new int[] {1,1}));
        System.out.println(new _0026_删除排序数组中的重复项().removeDuplicates(new int[] {1,1,2}));
        System.out.println(new _0026_删除排序数组中的重复项().removeDuplicates(new int[] {0,0,1,1,1,2,2,3,3,4}));
    }
}
