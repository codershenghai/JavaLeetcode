package com.shenghaishxt.slidewindow;

import java.util.HashMap;
import java.util.Map;

public class _0076_最小覆盖子串 {
    public String minWindow(String s, String t) {
        // left和right是滑动窗口，start和end记录可行解，count代表符合要求的字符个数，minLen代表最小覆盖子串的长度
        int left = 0, right = 0, start = 0, end = 0, count = 0, minLen = Integer.MAX_VALUE;

        // need存储t的<字符, 出现次数>，window存储<s中与t中相同的字符, 出现次数>，同时初始化need
        Map<Character, Integer> need = new HashMap<>(), window = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        while (right < s.length()) {
            // 获取当前字符
            char c = s.charAt(right++);
            // 如果是t中字符，在window中添加，累计出现次数
            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (window.get(c).equals(need.get(c))) count++; //字符出现的次数符合要求，count代表符合要求的字符个数
            }

            // 所有字符出现的次数都符合要求，则获得了一个可行解
            while (count == need.size()) {
                // 更新结果
                if (right - left < minLen) {
                    start = left;
                    end = right;
                    minLen = end - start;
                }
                // 开始进行优化，即右移left，缩小区间
                c = s.charAt(left);
                // 如果当前要删除的字符在t中，那么更新window中这个字符对应出现的次数，如果更新后的次数小于t中出现的次数，那么符合要求的字符数减1
                if (need.containsKey(c)) {
                    window.put(c, window.getOrDefault(c, 1) - 1);
                    if (window.get(c) < need.get(c)) {
                        count--;
                    }
                }
                left++;
            }
        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(start, end);
    }

    public static void main(String[] args) {
        String res = new _0076_最小覆盖子串().minWindow("ADOBECODEBANC", "ABC");
        System.out.println(res);
    }
}
