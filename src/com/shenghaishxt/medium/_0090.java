package com.shenghaishxt.medium;

import java.util.ArrayList;
import java.util.List;

public class _0090 {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        backtrace(nums, new ArrayList<>(), new boolean[nums.length]);
        return res;
    }

    private void backtrace(int[] nums, ArrayList<Integer> list, boolean[] visited) {
        if (!res.contains(list)) {
            res.add(new ArrayList<>(list));
        }
        for (int i = 0; i < nums.length; i++) {
            if (!visited[i]) {
                if (list.size()-1 >= 0 && nums[i] < list.get(list.size()-1))
                    continue;
                list.add(nums[i]);
                visited[i] = true;
                backtrace(nums, list, visited);
                list.remove(list.size()-1);
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> res = new _0090().subsets(new int[] {1,2,2});
        System.out.println(res);
    }
}
