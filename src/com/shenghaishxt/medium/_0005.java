package com.shenghaishxt.medium;

public class _0005 {
    // 暴力法，超出时间限制
    private String longestPalindrome1(String s) {
        int max_str = 0;
        String longest_str = "";
        for (int i = 0; i < s.length()+1; i++) {
            for (int j = i+1; j < s.length()+1; j++) {
                String cur_str = s.substring(i, j);
                if (isPalindrome(cur_str) && cur_str.length()>max_str) {
                    max_str = cur_str.length();
                    longest_str = cur_str;
                }
            }
        }
        return longest_str;
    }

    // 转化为求最长公共子串(动态规划)
    private String longestPalindrome2(String s) {
        String s_inv = new StringBuffer(s).reverse().toString();
        return s_inv;
    }

    // 求最长公共子串(Longest common substring problem)
    private String LCS(String s1, String s2) {
        return s1;
    }

    // 判断是否为回文串
    private boolean isPalindrome(String s) {
        int head = 0, tail = s.length() - 1;
        while (head < tail) {
            if (s.charAt(head) == s.charAt(tail)) {
                head++;
                tail--;
            } else return false;
        }
        return true;
    }

    public static void main(String[] args) {
        _0005 Sol = new _0005();
        System.out.println(Sol.longestPalindrome2("cbbd"));
    }
}
