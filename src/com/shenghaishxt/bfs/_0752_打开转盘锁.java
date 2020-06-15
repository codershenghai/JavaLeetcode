package com.shenghaishxt.bfs;

import java.util.*;

public class _0752_打开转盘锁 {
    public int openLock(String[] deadends, String target) {
        Set<String> deads = new HashSet<>(Arrays.asList(deadends));
        Set<String> visited = new HashSet<>();
        Deque<String> deque = new ArrayDeque<>();

        int step = 0;
        deque.addLast("0000");
        visited.add("0000");

        while (!deque.isEmpty()) {
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                String cur = deque.pollFirst();

                // 判断是否到达终点
                if (deads.contains(cur)) continue;
                if (cur.equals(target)) return step;

                // 四位数字的每位数字的相邻节点加入队列，每位数字都可以向上或者向下拨
                for (int j = 0; j < 4; j++) {
                    String up = plusOne(cur, j);
                    String down = minusOne(cur, j);
                    if (!visited.contains(up)) {
                        deque.addLast(up);
                        visited.add(up);
                    }
                    if (!visited.contains(down)) {
                        deque.addLast(down);
                        visited.add(down);
                    }
                }
            }
            step++;
        }
        return -1;
    }

    private String plusOne(String s, int j) {
        StringBuilder sb = new StringBuilder(s);
        if (sb.charAt(j) == '9') sb.setCharAt(j, '0');
        else sb.setCharAt(j, (char) (sb.charAt(j) + 1));
        return sb.toString();
    }

    private String minusOne(String s, int j) {
        StringBuilder sb = new StringBuilder(s);
        if (sb.charAt(j) == '0') sb.setCharAt(j, '9');
        else sb.setCharAt(j, (char) (sb.charAt(j) - 1));
        return sb.toString();
    }

    public static void main(String[] args) {
        String[] deadends = new String[] {"0201","0101","0102","1212","2002"};
        String target = "0202";
        System.out.println(new _0752_打开转盘锁().openLock(deadends, target));
    }
}
