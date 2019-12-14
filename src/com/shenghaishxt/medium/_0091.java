package com.shenghaishxt.medium;

public class _0091 {
    private int numDecodings(String s) {
        char[] s_arr = s.toCharArray();
        if (s_arr[0] == '0')
            return 0;
        int[] f = new int[s_arr.length];
        f[0] = 1;

        /**
         *  f[i] += f[i-1]   if '1' <= s_arr[i]-'0' <= '9'  (分开译码)
         *  f[i] += f[i-2]   if '10' <= 10*(s_arr[i-1]-'0')+(s_arr[i]-'0') <= '26' (合并译码)
         *
         *  解释：当s[i-1]与s[i]分开译码时，f[i] = f[i-1]
         *       当s[i-1]与s[i]合并译码时，f[i] = f[i-2]
         */
        for (int i = 1; i < s_arr.length; i++) {
            int num1 = s_arr[i]-'0';
            int num2 = 10*(s_arr[i-1]-'0') + (s_arr[i]-'0');

            if (num1 >= 1 && num1 <= 9)
                f[i] += f[i-1];
            if (num2 >= 10 && num2 <= 26) {
                if (i-2 < 0)
                    f[i] += 1;
                else f[i] += f[i-2];
            }
        }
        return f[s_arr.length - 1];
    }

    public static void main(String[] args) {
        _0091 Sol = new _0091();
        int res = Sol.numDecodings("100");
        System.out.println(res);
    }
}
