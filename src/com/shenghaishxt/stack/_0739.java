package com.shenghaishxt.stack;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * 每日温度
 */
public class _0739 {
    // 暴力
    public int[] dailyTemperatures1(int[] T) {
        int[] res = new int[T.length];
        for (int i = 0; i < T.length; i++) {
            for (int j = i+1; j < T.length; j++) {
                if (T[j] > T[i] && j-i > res[i]) {
                    res[i] = j - i;
                    break;
                }
            }
        }
        return res;
    }

    // 栈
    public int[] dailyTemperatures2(int[] T) {
        Deque<Integer> deque = new ArrayDeque<>();
        int[] res = new int[T.length];
        int i = 0;
        while (i < T.length) {
            if (deque.isEmpty() || T[i] <= T[deque.peek()]) deque.push(i++);
            else if (T[i] > T[deque.peek()]) {
                res[deque.peek()] = i - deque.peek();
                deque.poll();
            }
        }
        return res;
    }



    public static void main(String[] args) {
        System.out.println(Arrays.toString(new _0739().dailyTemperatures2(new int[]{73, 74, 75, 71, 69, 72, 76, 73})));
    }
}
