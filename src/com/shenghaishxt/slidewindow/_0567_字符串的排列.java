package com.shenghaishxt.slidewindow;

import java.util.HashMap;
import java.util.Map;

public class _0567_字符串的排列 {
    public boolean checkInclusion(String s1, String s2) {
        int left = 0, right = 0, count = 0;

        Map<Character, Integer> need = new HashMap<>(), window = new HashMap<>();
        for (int i = 0; i < s1.length(); i++) {
            char c = s1.charAt(i);
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        while (right < s2.length()) {
            char c = s2.charAt(right++);
            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (window.get(c).equals(need.get(c))) {
                    count++;
                }
            }

            while (right - left >= s1.length()) {
                if (count == need.size()) {
                    return true;
                }
                c = s2.charAt(left++);
                if (need.containsKey(c)) {
                    if (window.get(c).equals(need.get(c))) {
                        count--;
                    }
                    window.put(c, window.get(c) - 1);
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new _0567_字符串的排列().checkInclusion("ab", "eidbaooo"));
    }
}
