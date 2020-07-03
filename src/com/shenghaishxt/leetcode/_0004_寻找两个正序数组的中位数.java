package com.shenghaishxt.leetcode;

import java.util.Arrays;

public class _0004_寻找两个正序数组的中位数 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] merge = new int[nums1.length+nums2.length];
        System.arraycopy(nums1, 0, merge, 0, nums1.length);
        System.arraycopy(nums2, 0, merge, nums1.length, nums2.length);
        Arrays.sort(merge);
        if ((merge.length & 1) == 1) return merge[merge.length >> 1];
        else return (double) (merge[merge.length >> 1] + merge[(merge.length >> 1) - 1]) / 2;
    }

    public static void main(String[] args) {
        System.out.println(new _0004_寻找两个正序数组的中位数().findMedianSortedArrays(
                new int[] {}, new int[] {1,2,3,4,5,6}
        ));
        System.out.println(new _0004_寻找两个正序数组的中位数().findMedianSortedArrays(
                new int[] {1, 3}, new int[] {2}
        ));
        System.out.println(new _0004_寻找两个正序数组的中位数().findMedianSortedArrays(
                new int[] {1, 2}, new int[] {3, 4}
        ));
    }
}
