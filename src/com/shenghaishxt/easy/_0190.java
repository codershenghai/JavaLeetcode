package com.shenghaishxt.easy;

public class _0190 {
    private int reverseBits(int n) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            res <<= 1;
            res += n & 1;
            n >>= 1;
        }
        return res;
    }

    public static void main(String[] args) {
        _0190 Sol = new _0190();
        System.out.println(Sol.reverseBits(Integer.valueOf("00000010100101000001111010011100", 2)));
    }
}
