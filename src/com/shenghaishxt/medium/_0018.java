package com.shenghaishxt.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _0018 {
    private List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            // 剪枝 and 去重
            if (nums[i] > target)
                break;
            if (i > 0 && nums[i] == nums[i-1])
                continue;

            for (int j = i+1; j < len; j++) {
                // 剪枝 and 去重
                if (nums[j] > target)
                    break;
                if (j > 1 && nums[j] == nums[j-1])
                    continue;

                int left = j+1, right = len-1;
                while (left < right) {
                    int sum = nums[i] + nums[j] + nums[left] + nums[right];
                    if (sum < target)
                        left++;
                    else if (sum > target)
                        right--;
                    else {
                        res.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        while (left < right && nums[left] == nums[left+1])
                            left++;
                        while (left < right && nums[right] == nums[right-1])
                            right--;
                        left++;
                        right--;
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        _0018 Sol = new _0018();
        int[] nums = {0,0,0,0};
        int target = 0;
        List<List<Integer>> res = Sol.fourSum(nums, target);
        System.out.println(res);
    }
}
