package com.elminster;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class Leet778 {
    
    public static int swimInWater(final int[][] grid) {
        Queue<LeastPath> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(lp -> grid[lp.point[0]][lp.point[1]]));
        
        int N = grid.length;
        boolean[][] visited = new boolean[N][N];

        priorityQueue.offer(new LeastPath(new int[]{0, 0}, grid[0][0]));
        while (!priorityQueue.isEmpty()) {
            LeastPath lp = priorityQueue.poll();
            int[] point = lp.point;
            int leastPath = lp.leastPath;
            int row = point[0];
            int col = point[1];

            if (row == N - 1 && col == N - 1) {
                return leastPath;
            }
            if (visited(point, visited)) {
                continue;
            }
            visited[row][col] = true;

            orderPoint(row, col - 1, N, priorityQueue, grid, leastPath);
            orderPoint(row, col + 1, N, priorityQueue, grid, leastPath);
            orderPoint(row - 1, col, N, priorityQueue, grid, leastPath);
            orderPoint(row + 1, col, N, priorityQueue, grid, leastPath);
        }
        return -1;
    }

    static class LeastPath {

        public LeastPath(int[] point, int leastPath) {
            this.point = point;
            this.leastPath = leastPath;
        }
        int[] point;
        int leastPath;
    }

    private static void orderPoint(int row, int col, int N, Queue<LeastPath> priorityQueue, int[][] grid, int leastPath) {
        if (row >= 0 && row < N && col >= 0 && col < N) {
            priorityQueue.offer(new LeastPath(new int[] {row, col}, Math.max(grid[row][col], leastPath)));
        }
    }

    private static boolean visited(int[] point, boolean[][] visited) {
        return visited[point[0]][point[1]];
    }

    public static void main(String[] args) {
        int[][] grid = {{0, 2}, {1, 3}};
        System.out.println(swimInWater(grid));
        grid = new int[][]{{0, 1, 2, 3, 4}, {24, 23, 22, 21, 5}, {12, 13, 14, 15, 16}, {11, 17, 18, 19, 20}, {10, 9, 8, 7, 6}};
        System.out.println(swimInWater(grid));
    }
}
