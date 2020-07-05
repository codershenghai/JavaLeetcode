package com.shenghaishxt.leetcode;

import java.util.HashMap;

public class _0012_整数转罗马数字 {
    // 罗马数字包含七种字符：I， V， X， L，C，D 和 M
    // 将这七种字符和六种特例按照从大到小的顺序存储进数组
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
        _0012_整数转罗马数字 Sol = new _0012_整数转罗马数字();
        int num = 9;
        String res = Sol.intToRoman(num);
        System.out.println(res);
    }
}
