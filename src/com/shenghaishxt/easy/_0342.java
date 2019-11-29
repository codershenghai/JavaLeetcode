package com.shenghaishxt.easy;

public class _0342 {
    private boolean isPowerOfFour1(int num) {
        if (num <= 0)
            return false;
        while (num % 4 == 0)
            num /= 4;
        return num == 1;
    }

    private boolean isPowerOfFour2(int num) {
        // 1.递归终止的条件
        if (num <= 0)
            return false;
        if (num == 1)
            return true;
        // 2.找返回值
        // 3.本级递归应该做什么
        if (num % 4 == 0)
            return isPowerOfFour2(num/4);
        else
            return false;
    }

    public static void main(String[] args) {
        _0342 Sol = new _0342();
        System.out.println(Sol.isPowerOfFour2(5));
    }
}
