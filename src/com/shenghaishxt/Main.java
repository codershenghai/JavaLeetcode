package com.shenghaishxt;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        int countUpper = 0, countLower = 0;
        if (str.length() == 0) {
            System.out.println(0);
            return;
        }
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (Character.isUpperCase(ch)) countUpper++;
            else if (Character.isLowerCase(ch)) countLower++;
        }
        if (countUpper == countLower) {
            System.out.println(0);
            return;
        }
        System.out.println((countUpper - countLower) >> 1);
    }
}