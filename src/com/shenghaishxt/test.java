package com.shenghaishxt;

import java.util.*;

public class test {
    public static void main(String[] args) {
        List<String> wordDict = new ArrayList<>();
        wordDict.add("111");
        wordDict.add("222");
        wordDict.add("333");
        System.out.println(wordDict);
        Collections.reverse(wordDict);
        System.out.println(wordDict);
    }
}
