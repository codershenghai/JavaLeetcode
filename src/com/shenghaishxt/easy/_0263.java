package com.shenghaishxt.easy;

public class _0263 {
    private boolean isUgly(int num) {
        if (num <= 0)
            return false;
        int[] primeFactor = new int[] {2,3,5};
        for (int i : primeFactor)
            while (num % i == 0)
                num /= i;
        return num == 1;
    }

    public static void main(String[] args) {
        _0263 Sol = new _0263();
        System.out.println(Sol.isUgly(14));
    }
}
