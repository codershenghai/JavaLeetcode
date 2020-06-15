package com.shenghaishxt.slidewindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _0438_找到字符串中所有字母异位词 {
    public List<Integer> findAnagrams(String s, String p) {
        int left = 0, right = 0, count = 0;
        List<Integer> res = new ArrayList<>();

        Map<Character, Integer> need = new HashMap<>(), window = new HashMap<>();
        for (int i = 0; i < p.length(); i++) {
            char c = p.charAt(i);
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        while (right < s.length()) {
            char c = s.charAt(right++);
            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (window.get(c).equals(need.get(c))) {
                    count++;
                }
            }

            while (right - left >= p.length()) {
                if (count == need.size()) {
                    res.add(left);
                }
                c = s.charAt(left++);
                if (need.containsKey(c)) {
                    if (window.get(c).equals(need.get(c))) {
                        count--;
                    }
                    window.put(c, window.get(c) - 1);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new _0438_找到字符串中所有字母异位词().findAnagrams("cbaebabacd", "abc"));
        System.out.println(new _0438_找到字符串中所有字母异位词().findAnagrams("abab", "ab"));
    }
}
