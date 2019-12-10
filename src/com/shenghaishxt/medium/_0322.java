package com.shenghaishxt.medium;

public class _0322 {
    private int coinChange(int[] coins, int amount) {
        int[] f = new int[amount+1];
        f[0] = 0;

        // f[i] = min(f[i - coins[j]]+1)
        for (int i = 1; i < amount+1; i++) {
            f[i] = Integer.MAX_VALUE;
            for (int coin : coins) {
                if (i-coin >= 0 && f[i - coin]!=Integer.MAX_VALUE)
                    f[i] = Math.min(f[i-coin] + 1, f[i]);
            }
        }
        return f[amount]==Integer.MAX_VALUE ? -1 : f[amount];
    }

    public static void main(String[] args) {
        _0322 Sol = new _0322();
        int res = Sol.coinChange(new int[] {2}, 3);
        System.out.println(res);
    }
}
