package com.shenghaishxt.leetcode;

import java.util.*;

/**
 * 首先对传入的每个字符串进行排序，使用排序后的字符串作为key（这样可以去重），List<String>作为value存入map
 */
public class _0049_字母异位词分组 {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] ca = str.toCharArray();
            Arrays.sort(ca);
            String key = String.valueOf(ca);
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            if (map.containsKey(key)) {
                map.get(key).add(str);
            }
        }
        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        String[] strs = new String[] {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(new _0049_字母异位词分组().groupAnagrams(strs));
    }
}
