package com.shenghaishxt.medium;

import java.util.HashMap;

public class _0012 {
    private String intToRoman(int num) {
        HashMap<Integer, String> map = new HashMap<>();
        int[] values = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String[] strings = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};

        StringBuilder res = new StringBuilder();
        for (int i = 0; i < values.length; i++) {
            int cur = num / values[i];
            num = num % values[i];
            if (cur == 0)
                continue;
            res.append(strings[i].repeat(Math.max(0, cur)));
        }
        return res.toString();
    }

    public static void main(String[] args) {
        _0012 Sol = new _0012();
        int num = 9;
        String res = Sol.intToRoman(num);
        System.out.println(res);
    }
}
