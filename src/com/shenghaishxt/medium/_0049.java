package com.shenghaishxt.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class _0049 {
    private List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] ca = str.toCharArray();
            Arrays.sort(ca);
            String key = String.valueOf(ca);
            if (!map.containsKey(key))
                map.put(key, new ArrayList<>());
            if (map.containsKey(key))
                map.get(key).add(str);
        }
        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        _0049 Sol = new _0049();
//        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        String[] strs = {};
        List<List<String>> res = Sol.groupAnagrams(strs);
        System.out.println(res);
    }
}
