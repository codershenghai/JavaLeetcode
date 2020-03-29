package com.shenghaishxt.medium;

public class _0029 {
    public int divide(int dividend, int divisor) {
        // 对边界条件单独判断
        if (dividend == Integer.MIN_VALUE && divisor == 1) return Integer.MIN_VALUE;
        if (dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE;

        long a = dividend, b = divisor;
        boolean flag = (a < 0 && b < 0) || (a > 0 && b > 0); //两个数符号不一样的时候结果为负数
        if (dividend < 0) a = -a;
        if (divisor < 0) b = -b;

        int res = (int) divideLong(a, b);
        return flag ? res : -res;
    }

    // 算一算被除数里有多少个除数（使用递归进行翻倍计算）
    public long divideLong(long a, long b) {
        if (a < b)
            return 0;
        long count = 1, testB = b;
        while ((testB << 1) <= a) {
            testB <<= 1;
            count <<= 1;
        }
        return count + divideLong(a-testB, b);
    }

    public static void main(String[] args) {
        System.out.println(new _0029().divide(Integer.MIN_VALUE, -2));
    }
}
