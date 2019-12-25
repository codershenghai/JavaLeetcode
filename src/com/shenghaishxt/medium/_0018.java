package com.shenghaishxt.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _0018 {
    private List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        int len = nums.length;
        if (len < 4)
            return res;

        Arrays.sort(nums);
        for (int i = 0; i < len-3; i++) {
            // 当i的值与前面的值相等时忽略
            if (i > 0 && nums[i] == nums[i-1])
                continue;
            // 获取当前最小值，如果最小值比目标值大，说明后面越来越大的值全都比最大值大
            int minValue = nums[i] + nums[i+1] + nums[i+2] + nums[i+3];
            if (minValue > target)
                break;

            // 获取当前最大值，如果最大值比目标值小，则continue
            int maxValue = nums[i] + nums[len-1] + nums[len-2] + nums[len-3];
            if (maxValue < target)
                continue;

            for (int j = i+1; j < len-2; j++) {
                // 当j的值与前面的值相等时忽略
                if (j > i+1 && nums[j] == nums[j-1])
                    continue;

                int left = j+1, right = len-1;

                // 获取当前最小值，如果最小值比目标值大，说明后面越来越大的值全都比最大值大
                minValue = nums[i] + nums[j] + nums[left] + nums[left+1];
                if (minValue > target)
                    continue; // break

                // 获取当前最大值，如果最大值比目标值小，则continue
                maxValue = nums[i] + nums[j] + nums[right] + nums[right-1];
                if (maxValue < target)
                    continue;

                // left和right开始表演
                while (left < right) {
                    int sum = nums[i] + nums[j] + nums[left] + nums[right];
                    if (sum < target)
                        left++;
                    else if (sum > target)
                        right--;
                    else {
                        res.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        left++;
                        while (left < right && nums[left] == nums[left-1]) {
                            left++;
                        }
                        right--;
                        while (left < right && i < right && nums[right] == nums[right+1]) {
                            right--;
                        }
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        _0018 Sol = new _0018();
        int[] nums = {-3,-2,-1,0,0,1,2,3};  //8
        int target = 0;

//        int[] nums = {-1,0,-5,-2,-2,-4,0,1,-2};  //4
//        int target = -9;

        List<List<Integer>> res = Sol.fourSum(nums, target);
        System.out.println(res.size());
    }
}
