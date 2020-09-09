package com.shenghaishxt.leetcode;

public class _0345_反转字符串中的元音字母 {
    public String reverseVowels(String s) {
        int left = 0, right = s.length()-1;
        StringBuilder sb = new StringBuilder(s);
        while (left < right) {
            while (left < right && !isVowel(s.charAt(left))) {
                left++;
            }
            while (left < right && !isVowel(s.charAt(right))) {
                right--;
            }
            if (left < right) {
                char temp = s.charAt(left);
                sb.setCharAt(left++, s.charAt(right));
                sb.setCharAt(right--, temp);
            }
        }
        return sb.toString();
    }

    private boolean isVowel(char ch) {
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u'
                ||ch=='A'|| ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U';
    }

    public static void main(String[] args) {
//        System.out.println(new _0345_反转字符串中的元音字母().reverseVowels("hello"));
        System.out.println(new _0345_反转字符串中的元音字母().reverseVowels(".,"));
    }
}
