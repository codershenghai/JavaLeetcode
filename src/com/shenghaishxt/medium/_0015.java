package com.shenghaishxt.medium;

import java.util.*;

public class _0015 {
    // 排序+双指针
    private List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int len = nums.length;
        Arrays.sort(nums);
        for (int i = 0; i < len; i++) {
            // 若当前数字大于0，则三数一定大于0
            if (nums[i] > 0)
                break;

            // 去重
            if (i > 0 && nums[i] == nums[i-1])
                continue;

            // 双指针遍历
            int left = i + 1, right = len - 1;
            while (left < right) {
                if (nums[i] + nums[left] + nums[right] < 0)
                    left++;
                else if (nums[i] + nums[left] + nums[right] > 0)
                    right--;
                else {
                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    // 去重
                    while (left < right && nums[left] == nums[left+1])
                        left++;
                    while (left < right && nums[right] == nums[right-1])
                        right--;

                    left++;
                    right--;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        _0015 Sol = new _0015();
        int[] nums = {0,0,0,0};
        List<List<Integer>> res = Sol.threeSum(nums);
        System.out.println(res);
    }
}
