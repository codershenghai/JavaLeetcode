package com.shenghaishxt.easy;

public class _0026 {
    // 快慢指针
    private int removeDuplicates(int[] nums) {
        int low = 0;
        for (int fast = 1; fast < nums.length; fast++) {
            if (nums[fast] != nums[low]){
                low++;
                nums[low] = nums[fast];
            }
        }
        return low+1;
    }

    public static void main(String[] args) {
        _0026 Sol = new _0026();
        int res = Sol.removeDuplicates(new int[]{0,0,1,1,1,2,2,3,3,4});
        System.out.println(res);
    }
}
