package com.shenghaishxt.dp;

public class 回文最少分割 {
    public int palindromeMinCuts(String s) {
        if (s == null || s.length() == 0 || isPalindrome(s)) return 0;
        int[] dp = new int[s.length() + 1];

        // dp数组初始化，dp[i]代表前i个字符组成的字符串的最少分割数
        for (int i = 2; i <= s.length(); i++) {
            dp[i] = isPalindrome(s.substring(0, i)) ? 0 : i - 1;
        }
        // dp[i] = min(dp[i], dp[j]+1)
        for (int i = 2; i <= s.length(); i++) {
            for (int j = i - 1; j >= 1; j--) {
                if (isPalindrome(s.substring(j, i))) {
                    dp[i] = Math.min(dp[i], dp[j] + 1);
                }
            }
        }
        return dp[s.length()];
    }

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
        System.out.println(new 回文最少分割().palindromeMinCuts("ABCBAEEE"));
        System.out.println(new 回文最少分割().palindromeMinCuts("ABC"));
        System.out.println(new 回文最少分割().palindromeMinCuts("ABA"));
        System.out.println(new 回文最少分割().palindromeMinCuts("A"));
        System.out.println(new 回文最少分割().palindromeMinCuts(""));
    }
}
