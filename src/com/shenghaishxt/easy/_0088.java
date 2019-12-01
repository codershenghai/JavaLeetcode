package com.shenghaishxt.easy;

public class _0088 {
    private void merge(int[] nums1, int m, int[] nums2, int n) {
        while (m>0 && n>0) {
            if (nums1[m-1] < nums2[n-1]) {
                nums1[m+n-1] = nums2[n-1];
                n--;
            }
            else {
                nums1[m+n-1] = nums1[m-1];
                m--;
            }
        }
        if (n>0)
            System.arraycopy(nums2, 0, nums1, 0, n);
    }

    public static void main(String[] args) {
        _0088 Sol = new _0088();

//        int[] nums1 = new int[] {1,2,3,0,0,0};
//        int[] nums2 = new int[] {2,5,6};
//        int m = 3, n = 3;

//        int[] nums1 = new int[] {0};
//        int[] nums2 = new int[] {1};
//        int m = 0, n = 1;

        int[] nums1 = new int[] {4,0,0,0,0,0};
        int[] nums2 = new int[] {1,2,3,5,6};
        int m = 1, n = 5;

        Sol.merge(nums1, m, nums2, n);
        for (int i : nums1)
            System.out.println(i);
    }
}
