package com.shenghaishxt.medium;

import java.util.ArrayDeque;
import java.util.Deque;

public class _0200 {
    public int numIslands(char[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    dfs(grid, i, j);
                    // bfs(grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    private void dfs(char[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >=grid[0].length || grid[i][j] != '1') return;
        grid[i][j] = 0; //将访问过的岛屿沉没

        dfs(grid, i+1, j);
        dfs(grid, i-1, j);
        dfs(grid, i, j+1);
        dfs(grid, i, j-1);
    }

    private void bfs(char[][] grid, int i, int j) {
        Deque<int[]> deque = new ArrayDeque<>();
        deque.addLast(new int[] {i, j});
        while (!deque.isEmpty()) {
            int[] cur = deque.pollFirst();
            int cur_i = cur[0], cur_j = cur[1];
            if (cur_i < 0 || cur_j < 0 || cur_i >= grid.length || cur_j >= grid[0].length || grid[cur_i][cur_j] == '0') continue;

            grid[cur_i][cur_j] = '0'; //将访问过的岛屿沉没
            deque.addLast(new int[] {cur_i+1, cur_j});
            deque.addLast(new int[] {cur_i-1, cur_j});
            deque.addLast(new int[] {cur_i, cur_j+1});
            deque.addLast(new int[] {cur_i, cur_j-1});
        }
    }

    public static void main(String[] args) {
        char[][] grid = {{'1','1','0','0','0'},{'1','1','0','0','0'},{'0','0','1','0','0'},{'0','0','0','1','1'}};
        int res = new _0200().numIslands(grid);
        System.out.println(res);
    }
}
