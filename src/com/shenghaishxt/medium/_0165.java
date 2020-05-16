package com.shenghaishxt.medium;

public class _0165 {
    public int compareVersion(String version1, String version2) {
        String[] nums1Arr = version1.split("\\.");
        String[] nums2Arr = version2.split("\\.");

        int num1, num2;
        for (int i = 0; i < nums1Arr.length || i < nums2Arr.length; i++) {
            num1 = i < nums1Arr.length ? Integer.parseInt(nums1Arr[i]) : 0;
            num2 = i < nums2Arr.length ? Integer.parseInt(nums2Arr[i]) : 0;
            if (num1 < num2) return -1;
            else if (num1 > num2) return 1;
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(new _0165().compareVersion("0.1", "1.1")); //-1
        System.out.println(new _0165().compareVersion("1.0.1", "1")); //1
        System.out.println(new _0165().compareVersion("7.5.2.4", "7.5.3")); //-1
        System.out.println(new _0165().compareVersion("1.01", "1.001")); //0
        System.out.println(new _0165().compareVersion("1.0", "1.0.0")); //0
    }
}
