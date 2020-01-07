package com.shenghaishxt.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class _0089 {
    private List<Integer> grayCode(int n) {
        // 1. 递归终止的条件
        if (n == 0) return new ArrayList<>(Collections.singletonList(0));

        // 2. 找返回值
        List<Integer> res = grayCode(n-1);

        // 3. 本级递归应该做什么
        for (int i = (int) (Math.pow(2, n-1)-1); i >= 0; i--)
            res.add((int) (res.get(i) + Math.pow(2, n-1)));
        return res;
    }

    public static void main(String[] args) {
        _0089 Sol = new _0089();
        List<Integer> res = Sol.grayCode(2);
        System.out.println(res);
    }
}
