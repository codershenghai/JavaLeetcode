package com.shenghaishxt.easy;

public class _0171 {
    private int titleToNumber(String s) {
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            int num = s.charAt(i) - 'A' + 1;
            res = res * 26 + num;
        }
        return res;
    }

    public static void main(String[] args) {
        _0171 Sol = new _0171();
        String s = "ZY";
        System.out.println(Sol.titleToNumber(s));
    }
}
