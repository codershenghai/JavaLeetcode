package com.shenghaishxt.medium;

import java.util.ArrayList;
import java.util.List;

public class _0054 {
    private List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if (matrix.length == 0)
            return res;
        int upper = 0, down = matrix.length-1, left = 0, right = matrix[0].length-1;

        while (true) {
            // 移动到最右
            for (int i = left; i <= right; i++)
                res.add(matrix[upper][i]);
            // 重新设定上边界
            if (++upper > down) break;

            // 移动到最下
            for (int i = upper; i <= down; i++)
                res.add(matrix[i][right]);
            // 重新设定右边界
            if (--right < left) break;

            // 移动到最左
            for (int i = right; i >= left; i--)
                res.add(matrix[down][i]);
            // 重新设定下边界
            if (--down < upper) break;

            // 移动到最上
            for (int i = down; i >= upper; i--)
                res.add(matrix[i][left]);
            // 重新设置左边界
            if (++left > right) break;
        }
        return res;
    }

    public static void main(String[] args) {
        _0054 Sol = new _0054();
        int[][] matrix = {{1,2,3,4}, {5,6,7,8}, {9,10,11,12}, {13,14,15,16}};
        List<Integer> res = Sol.spiralOrder(matrix);
        System.out.println(res);
    }
}
