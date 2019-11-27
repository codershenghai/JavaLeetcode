package com.shenghaishxt.easy;

public class _0191 {
    private static int hammingWeight1(int n) {
        // 使用位掩码来检查数字的第i位
        int res = 0;
        int mask = 1;
        for (int i = 0; i < 32; i++) {
            if ((n & mask) != 0){
                res++;
            }
            mask <<= 1;
        }
        return res;
    }

    private static int hammingWeight2(int n) {
        // 不断将n和1进行与运算，判断n的最低位是否为1
        int res = 0;
        for (int i = 0; i < 32; i++) {
            if ((n & 1) != 0){
                res++;
            }
            n >>= 1;
        }
        return res;
    }

    public static void main(String[] args) {
        Integer res = hammingWeight2(3);
        System.out.println(res);
    }
}
