package com.shenghaishxt.easy;

import java.util.HashSet;
import java.util.Set;

public class _0575 {
    private int distributeCandies(int[] candies) {
        // 比较糖果种类数量和妹妹手中最多的糖果数量。
        // 糖果总数为n，是偶数，弟弟和妹妹分得的糖果数目都是n/2。
        // 1. 如果糖果种类数大于n/2，则妹妹可以获得的最大糖果种类数为n/2(因为妹妹只有n/2个糖果) 。
        // 2. 如果糖果种类数小于n/2，则妹妹可以获得的最大糖果种类数为糖果的种类数(每种糖都至少给了妹妹一个)。
        Set<Integer> types = new HashSet<>();
        for (Integer candy : candies)
            types.add(candy);
        return Math.min(types.size(), candies.length/2);
    }

    public static void main(String[] args) {
        _0575 Sol = new _0575();
        System.out.println(Sol.distributeCandies(new int[] {1,1,2,3}));
    }
}
