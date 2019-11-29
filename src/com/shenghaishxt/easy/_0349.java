package com.shenghaishxt.easy;

import com.shenghaishxt.structure.ListNode;

import java.util.*;

public class _0349 {
    private int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();

        for (int i : nums1)
            set1.add(i);
        for (int i : nums2)
            set2.add(i);

        ArrayList<Integer> res = new ArrayList<>();
        for (int i:set1) {
            if (set2.contains(i))
                res.add(i);
        }

        int size = res.size();
        Integer[] x = res.toArray(new Integer[size]);

        int[] output = new int[size];
        for (int i = 0; i < size; i++)
            output[i] = x[i];
        return output;
    }

    public static void main(String[] args) {
        _0349 Sol = new _0349();
        int[] res = Sol.intersection(new int[] {4,9,5}, new int[] {9,4,9,8,4});
        for (int i : res) {
            System.out.println(i);
        }
    }
}
