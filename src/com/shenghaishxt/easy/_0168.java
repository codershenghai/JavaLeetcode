package com.shenghaishxt.easy;

import java.util.ArrayList;

public class _0168 {
    // 实质为十进制转二十六进制

    /**
     * 实质为十进制转二十六进制。
     * 注意：有个难点在于26代表字母Z，但是26对26取余为0，没有任何一个字母表示0。
     * 因此在取余操作前先将n减去1。
     */
    private String convertToTitle(int n) {
        StringBuilder builder = new StringBuilder();
        while (n > 0) {
            builder.append((char) ((--n % 26) + 65));
            n /= 26;
        }
        return builder.reverse().toString();
    }

    public static void main(String[] args) {
        _0168 Sol = new _0168();
        int n = 28;
        System.out.println(Sol.convertToTitle(n));
    }
}
