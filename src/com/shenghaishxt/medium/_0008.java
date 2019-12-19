package com.shenghaishxt.medium;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class _0008 {
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
    private int myAtoi(String str) {
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
        _0008 Sol = new _0008();
        String str = "42";
        System.out.println(Sol.myAtoi(str));
    }
}
