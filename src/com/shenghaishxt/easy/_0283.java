package com.shenghaishxt.easy;

public class _0283 {
    private void moveZeroes(int[] nums) {
        int fast = 0, slow = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[fast] != 0)
                nums[slow++] = nums[fast++];
            else
                fast++;
        }
        for (int i = slow; i < nums.length; i++) {
            nums[i] = 0;
        }
    }

    public static void main(String[] args) {
        _0283 Sol = new _0283();
        Sol.moveZeroes(new int[] {0,1,0,3,12});
    }
}
