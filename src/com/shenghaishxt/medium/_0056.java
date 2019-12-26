package com.shenghaishxt.medium;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class _0056 {
    private static class Interval {
        int start, end;
        Interval(int[] interval) {
            this.start = interval[0];
            this.end = interval[1];
        }
        int[] toArray() {
            return new int[] {this.start, this.end};
        }
    }

    private static class IntervalComparator implements Comparator<Interval> {
        @Override
        public int compare(Interval a, Interval b) {
            return Integer.compare(a.start, b.start);
        }
    }

    private int[][] merge(int[][] intervals) {
        List<Interval> intervalsList = new LinkedList<>();
        for (int[] interval : intervals)
            intervalsList.add(new Interval(interval));
        intervalsList.sort(new IntervalComparator());

        LinkedList<Interval> merged = new LinkedList<>();
        for (Interval interval : intervalsList) {
            if (merged.isEmpty() || merged.getLast().end < interval.start)
                merged.add(interval);
            else merged.getLast().end = Math.max(merged.getLast().end, interval.end);
        }

        int[][] res = new int[merged.size()][2];
        for (int i = 0; i < merged.size(); i++)
            res[i] = merged.get(i).toArray();

        return res;
    }

    public static void main(String[] args) {
        _0056 Sol = new _0056();
        int[][] intervals = {{1,4}, {1,5}};
        int[][] res = Sol.merge(intervals);
        System.out.println(Arrays.deepToString(res));
    }
}
