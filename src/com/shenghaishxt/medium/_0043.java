package com.shenghaishxt.medium;

import java.util.ArrayList;
import java.util.Stack;

public class _0043 {
    // 首先从num2的末尾开始，num1从末尾开始对num2的最后一个数字做乘法，定义一个字符串数组保存这些中间结果
    // 这里有点绕...举例吧，乘数是num1，被乘数是num2，是先对num1进行循环的
    // 那么就设num1中的数字为a，num2的数字为b
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0"))
            return "0";
        if (num1.length() < num2.length()) {
            String temp = num1;
            num1 = num2;
            num2 = temp;
        }

        ArrayList<StringBuilder> tempRes = new ArrayList<>();
        int count = 0; // 当前外层循环的次数
        for (int i = num2.length()-1; i >= 0; i--) {
            int carry = 0;
            count++;
            StringBuilder sb = new StringBuilder();
            for (int j = num1.length()-1; j>=0; j--) {
                int a = Integer.parseInt(String.valueOf(num1.charAt(j)));
                int b = Integer.parseInt(String.valueOf(num2.charAt(i)));
                int multiRes = a * b + carry;
                carry = multiRes / 10;
                if (j == 0)
                    sb.insert(0, multiRes);
                else sb.insert(0, multiRes % 10);
            }
            sb.append("0".repeat(Math.max(0, count - 1)));
            tempRes.add(sb);
        }
        return add(tempRes);
    }

    // 先全部塞到栈里面去吧，方便操作
    public String add(ArrayList<StringBuilder> sbs) {
        int maxLength = sbs.get(sbs.size()-1).length();
        StringBuilder res = new StringBuilder();

        ArrayList<Stack<Character>> stacks = new ArrayList<>();
        for (StringBuilder builder : sbs) {
            Stack<Character> stack = new Stack<>();
            for (int j = 0; j < builder.length(); j++) {
                stack.add(builder.charAt(j));
            }
            stacks.add(stack);
        }
        int carry = 0;
        for (int i = 0; i < maxLength; i++) {
            int addRes = 0;
            for (Stack<Character> stack : stacks) {
                if (stack.isEmpty())
                    continue;
                addRes += Integer.parseInt(String.valueOf(stack.pop()));
            }
            addRes += carry;
            carry = addRes / 10;
            if (i == maxLength - 1)
                res.insert(0, addRes);
            else res.insert(0, addRes % 10);
        }
        return res.toString();
    }

    public static void main(String[] args) {
        System.out.println(new _0043().multiply("999", "999"));
    }
}
