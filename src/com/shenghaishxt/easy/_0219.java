package com.shenghaishxt.easy;

import java.util.HashMap;

public class _0219 {
    // 线性滑动窗口(暴力)
    private boolean containsNearbyDuplicate1(int[] nums, int k) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < i+k+1 && j < nums.length; j++) {
                if (nums[i] == nums[j])
                    return true;
            }
        }
        return false;
    }

    private boolean containsNearbyDuplicate2(int[] nums, int k) {
        // 哈希表
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i]) && (i-map.get(nums[i]) <= k)){
                return true;
            }
            map.put(nums[i], i);
        }
        return false;
    }

    public static void main(String[] args) {
        _0219 Sol = new _0219();
        boolean res = Sol.containsNearbyDuplicate2(new int[] {1,2,3,1,2,3}, 2);
        System.out.println(res);
    }
}
