package com.shenghaishxt.medium;

import java.util.ArrayList;
import java.util.List;

public class _0078 {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        backtrace(nums, new ArrayList<>());
        return res;
    }

    private void backtrace(int[] nums, ArrayList<Integer> list) {
        if (!res.contains(list)) {
            res.add(new ArrayList<>(list));
        }
        for (int num : nums) {
            if (list.size()-1 >= 0 && num <= list.get(list.size()-1))
                continue;
            list.add(num);
            backtrace(nums, list);
            list.remove(list.size()-1);
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> res = new _0078().subsets(new int[] {1,2,3});
        System.out.println(res);
    }
}
