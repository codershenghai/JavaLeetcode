package com.shenghaishxt.leetcode;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class _0008_字符串转换整数 {
    // 1.跳过前面的空格（如果有的话）
    // 2.判断第一个字符是不是正号，如果是的话，其后一定要接数字
    // 3.判断第一个字符是不是负号，如果是的话，保存标志
    // 4.开始遍历数字，使用 -'0'或Character.digit()得到数字，使用Math.addExact和try catch判断整型溢出
    // 5.如果不是数字，就结束这个过程，返回答案
    public int myAtoi1(String str) {
        if (str.equals(""))
            return 0;
        int index = 0, res = 0;
        boolean negative = false;
        while (index < str.length() && (str.charAt(index) == ' ')) index++;

        // +后面一定要接数字
        if (index < str.length() && str.charAt(index) == '+') {
            index++;
            if (index < str.length() && (str.charAt(index) < '0' || str.charAt(index) > '9'))
                return 0;
        }

        // 如果是-，保存标志
        if (index < str.length() && str.charAt(index) == '-') {
            if (index > 0 && str.charAt(index-1) == '+') return 0;
            negative = true;
            index++;
        }
        while (index < str.length() && str.charAt(index) >= '0' && str.charAt(index) <= '9') {
            try {
                res = Math.addExact(Math.multiplyExact(res, 10), str.charAt(index++)-'0');
            } catch (ArithmeticException e) {
                return negative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
        }
        return negative ? -res : res;
    }


    /**
     * 正则表达式：
     * ^：       匹配输入字符串开始的位置
     * [\+\-]：  代表一个+字符或-字符
     * \d：      一个数字
     * \D：      一个非数字字符
     * *：       前面一个字符的0个或多个
     * +：       前面一个字符的1个或多个
     * ?：       前面一个字符0个或一个
     * []：      字符集，匹配其中包含的任一字符
     */
    private int myAtoi2(String str) {
        str = str.trim();
        Pattern pattern = Pattern.compile("^[\\+\\-]?\\d+");
        Matcher matcher = pattern.matcher(str);
        int value = 0;
        if (matcher.find()) {
            try {
                value = Integer.parseInt(str.substring(matcher.start(), matcher.end()));
            } catch (NumberFormatException e) {
                value = str.charAt(0) == '-' ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
        }
        return value;
    }

    public static void main(String[] args) {
        _0008_字符串转换整数 Sol = new _0008_字符串转换整数();
        String str = "42";
        System.out.println(Sol.myAtoi1(str));
    }
}
