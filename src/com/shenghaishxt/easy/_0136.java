package com.shenghaishxt.easy;

public class _0136 {
    private static int singleNumber(int[] nums){
        /*
            异或
            交换律：a^b^c <=> a^c^b
            任何数与0异或为原来的数 0^n => n
            相同的数异或为0 n^n => 0
         */
        int res = 0;
        for (int num : nums) {
            res ^= num;
        }
        return res;
    }

    public static void main(String[] args) {
        Integer res = singleNumber(new int[] {4,1,2,1,2});
        System.out.println(res);
    }
}
