package com.shenghaishxt.easy;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class _0169 {
    private static int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num)+1);
            } else {
                map.put(num, 1);
            }
        }
        for (Integer key : map.keySet()) {
            if (map.get(key) > nums.length / 2)
                return key;
        }
        return -1;
    }

    public static void main(String[] args) {
        Integer res = majorityElement(new int[] {2,2,1,1,1,2,2});
        System.out.println(res);
    }
}
