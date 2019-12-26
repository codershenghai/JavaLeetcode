package com.shenghaishxt.hard;

import java.util.Arrays;
import java.util.LinkedList;

public class _0057 {
    /**
     * 在一系列非重叠的区间中插入一个新的区间，可能还需要和原有的区间合并。
     * 可以对给定的区间集进行一个一个的遍历比较，那么会有两种情况，重叠或是不重叠。
     *
     * 如果不重叠，直接将新区间插入到对应的位置即可。
     * 如果重叠，比较复杂，有时候会有多个重叠，需要更新新区间的范围以便包含所有重叠。
     */
    private int[][] insert(int[][] intervals, int[] newInterval) {
        LinkedList<int[]> res = new LinkedList<>();
        int len = intervals.length, cur = 0;
        while (cur < len && intervals[cur][1] < newInterval[0])
            res.add(intervals[cur++]);

        while (cur < len && intervals[cur][0] <= newInterval[1]) {
            newInterval[0] = Math.min(newInterval[0], intervals[cur][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[cur][1]);
            cur++;
        }
        res.add(newInterval);
        while (cur < len)
            res.add(intervals[cur++]);

        int[][] resArr = new int[res.size()][2];
        for (int i = 0; i < res.size(); i++)
            resArr[i] = res.get(i);
        return resArr;
    }

    public static void main(String[] args) {
        _0057 Sol = new _0057();
        int[][] intervals = {{1,2}, {3,5}, {6,7}, {8,10}, {12,16}};
        int[] newInterval = {4,8};
        int[][] res = Sol.insert(intervals, newInterval);
        System.out.println(Arrays.deepToString(res));
    }
}
