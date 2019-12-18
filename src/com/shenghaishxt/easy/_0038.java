package com.shenghaishxt.easy;

public class _0038 {
    private String countAndSay(int n) {
        String preStr = "1";
        for (int i = 1; i < n; i++)
            preStr = say(preStr);
        return preStr;
    }

    private String say(String str) {
        char begin = str.charAt(0);
        int count = 1;
        StringBuilder builder = new StringBuilder();

        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) == begin)
                count++;
            else {
                builder.append(count).append(str.charAt(i-1));
                begin = str.charAt(i);
                count = 1;
            }
        }
        return builder.append(count).append(str.charAt(str.length()-1)).toString();
    }

    public static void main(String[] args) {
        _0038 Sol = new _0038();
        int n = 6;
        String res = Sol.countAndSay(n);
        System.out.println(res);
    }
}
