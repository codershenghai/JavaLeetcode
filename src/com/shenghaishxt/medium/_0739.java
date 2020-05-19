package com.shenghaishxt.medium;

import java.util.Arrays;

public class _0739 {
    // 暴力
    public int[] dailyTemperatures(int[] T) {
        int[] res = new int[T.length];
        for (int i = 0; i < T.length; i++) {
            for (int j = i+1; j < T.length; j++) {
                if (T[j] > T[i] && j-i > res[i]) {
                    res[i] = j - i;
                    break;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new _0739().dailyTemperatures(new int[] {73, 74, 75, 71, 69, 72, 76, 73})));
    }
}
