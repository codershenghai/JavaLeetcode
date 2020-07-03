package com.shenghaishxt.easy;

public class _0125 {
    private boolean isPalindrome(String s) {
        // 将除字母、数字外的字符全部去除，且忽略大小写
        String str = s.replaceAll("[^a-z^A-Z^0-9]", "").toLowerCase();
        int head = 0, tail = str.length()-1;
        if (str.length() == 0)
            return true;
        while (head < tail) {
            if (str.charAt(head) == str.charAt(tail)) {
                head++;
                tail--;
            } else return false;
        }
        return true;
    }

    public static void main(String[] args) {
        _0125 Sol = new _0125();
        boolean res = Sol.isPalindrome("aa");
        System.out.println(res);

        String a = "";
        System.out.println(a.length());
    }
}
