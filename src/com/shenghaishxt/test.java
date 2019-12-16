package com.shenghaishxt;

import java.util.*;

public class test {
    public static void main(String[] args) {
        List<List<Integer>> ansList = new ArrayList<>();
        ansList.add(new ArrayList<>());
        ansList.get(0).add(1);

        ansList.add(new ArrayList<>());
        ansList.get(1).add(2);
        ansList.get(1).add(2);

        System.out.println(ansList);
    }
}
