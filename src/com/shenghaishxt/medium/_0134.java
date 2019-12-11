package com.shenghaishxt.medium;

public class _0134 {
    private int canCompleteCircuit(int[] gas, int[] cost) {
        // 如果无法环绕一周，那么gas[i]-cost[i]的差值累加必然小于0
        // 否则，就是能够环绕一周。

        int total = 0, sum = 0, start = 0;

        for (int i = 0; i < gas.length; i++) {
            total += gas[i] - cost[i];
            if (sum >= 0)
                sum += gas[i] - cost[i];
            else {
                start = i;
                sum = gas[i] - cost[i];
            }
        }
        return total >= 0 ? start : -1;
    }

    public static void main(String[] args) {
        _0134 Sol = new _0134();
        int[] gas = new int[] {2,3,4};
        int[] cost = new int[] {3,4,3};
        System.out.println(Sol.canCompleteCircuit(gas, cost));
    }
}
