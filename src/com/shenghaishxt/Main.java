package com.shenghaishxt;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int q = sc.nextInt();

        List<List<Integer>> lists = new ArrayList<>();
        int[][] map = new int[n+1][n+1];

        int i, j;
        int a, b, c;

        //第一次初始化图（填充默认值）
        for (i = 0; i < n+1; i++) {
            for (j = 0; j < n+1; j++) {
                map[i][j] = 0x3f3f3f3f;
                if (i == j)
                    map[i][j] = 0;
            }
        }

        //真正的初始化（根据输入值）
        for (i = 0; i < m ; i++) {
            a = sc.nextInt();
            b = sc.nextInt();
            c = sc.nextInt();
            map[a][b] = c;
            map[b][a] = c;
        }

        //初始化query
        for (int k = 0; k < q; k++) {
            List<Integer> list = new ArrayList<>();
            list.add(sc.nextInt());
            list.add(sc.nextInt());
            lists.add(list);
        }

        //计算两个城市最短距离
        int k;
        for (k = 0; k < n+1; k++) {
            for (i = 0; i < n+1; i++) {
                for (j = 0; j < n+1; j++) {
                    if (map[i][j] > map[i][k] + map[k][j])
                        map[i][j] = map[i][k] + map[k][j];
                }
            }
        }

        // 遍历query
        for (List<Integer> list : lists) {
            int x = list.get(0);
            int y = list.get(1);
            if (map[x][y] == 0x3f3f3f3f) {
                System.out.println(-1);
            } else System.out.println(map[x][y]);
        }

        //遍历计算出最大值，并显示矩阵记录结果
//        int res, max = 0;
//        for (i = 1; i <= n+1; i++) {
//            for (j = 1; j <= n+1; j++) {
//                System.out.print(map[i][j]+" ");
//                if ((res = map[i][j]) > max)
//                    max = res;
//            }
//            System.out.println();
//        }
    }
}