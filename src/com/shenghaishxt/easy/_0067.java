package com.shenghaishxt.easy;

public class _0067 {
    private String addBinary(String a, String b) {
        // 将较短的字符串用0补齐，然后从末尾进行遍历
        StringBuilder res = new StringBuilder();
        int carry = 0;
        for (int i = a.length()-1, j = b.length()-1; i >=0 || j >=0; i--, j--) {
            int sum = carry;
            sum += i >= 0 ? a.charAt(i)-'0' : 0;
            sum += j >= 0 ? b.charAt(j)-'0' : 0;
            res.append(sum % 2);
            carry = sum / 2;
        }
        res.append(carry==1 ? carry : "");
        return res.reverse().toString();
    }

    public static void main(String[] args) {
        _0067 Sol = new _0067();
        String res = Sol.addBinary("1010", "1011");
        System.out.println(res);
    }
}
