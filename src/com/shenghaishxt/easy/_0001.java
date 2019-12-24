package com.shenghaishxt.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

// 输入的整数数组不是有序的，而且需要返回下标，因此不能用双指针法。
public class _0001 {
    // 暴力法
    private int[] twoSum1(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[] {i, j};
                }
            }
        }
        return null;
    }

    // HashMap
    private int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target-nums[i]))
                return new int[] {map.get(target - nums[i]), i};
            else {
                map.put(nums[i], i);
            }
        }
        return null;
    }

    public static void main(String[] args) {
        _0001 Sol = new _0001();
        int[] res = Sol.twoSum1(new int[] {2, 7, 11, 15}, 9);
        System.out.println(Arrays.toString(res));
    }
}
