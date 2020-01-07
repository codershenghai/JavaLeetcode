package com.shenghaishxt.medium;

public class _0079 {
    private boolean exist(char[][] board, String word) {
        int m = board.length, n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++)
                if (dfs(board, word, 0, i, j, visited))
                    return true;
        }
        return false;
    }

    private boolean dfs(char[][] board, String word, int idx, int i, int j, boolean[][] visited) {
        if (idx == word.length())
            return true;
        int m = board.length, n = board[0].length;
        if (i < 0 || j < 0 || i >= m || j >= n || visited[i][j] || board[i][j] != word.charAt(idx))
            return false;
        visited[i][j] = true;
        boolean res = dfs(board, word, idx+1, i-1, j, visited) ||
                      dfs(board, word, idx+1, i+1, j, visited) ||
                      dfs(board, word, idx+1, i, j+1, visited) ||
                      dfs(board, word, idx+1, i, j-1, visited);
        visited[i][j] = false;
        return res;
    }

    public static void main(String[] args) {
        char[][] board = {{'A','B','C','E'}, {'S','F','C','S'}, {'A','D','E','E'}};
        String word = "ABCES";
        _0079 Sol = new _0079();
        boolean res = Sol.exist(board, word);
        System.out.println(res);
    }
}
