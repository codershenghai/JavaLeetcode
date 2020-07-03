package com.shenghaishxt.leetcode;


public class _0006_Z字形变换 {

    public String convert(String s, int numRows) {
        if (s.length() == 0)
            return "";
        StringBuilder[] rows = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++)
            rows[i] = new StringBuilder("");

        boolean down = false;
        int loc = 0;
        for (int i = 0; i < s.length(); i++) {
            if (loc == 0 || loc == numRows-1)
                down = !down;
            rows[loc].append(s.charAt(i));
            if (numRows > 1)
                loc += (down ? 1 : -1);
        }

        StringBuilder res = new StringBuilder();
        for (int i = 0; i < numRows; i++)
            res.append(rows[i]);
        return res.toString();
    }

    public static void main(String[] args) {
        _0006_Z字形变换 Sol = new _0006_Z字形变换();
        String input = "AB";
        int numRows = 1;
        System.out.println(Sol.convert(input, numRows));
    }
}
