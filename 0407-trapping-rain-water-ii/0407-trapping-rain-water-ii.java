import java.util.*;

class Solution {
    public int trapRainWater(int[][] heightMap) {
        if (heightMap == null || heightMap.length == 0 || heightMap[0].length == 0) return 0;
        int m = heightMap.length, n = heightMap[0].length;
        if (m <= 2 || n <= 2) return 0;

        return calculateUsingHeap(heightMap);
    }

    private int calculateUsingHeap(int[][] heightMap) {
        int m = heightMap.length, n = heightMap[0].length;
        boolean[][] visited = new boolean[m][n];
        PriorityQueue<Cell> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.h));

        for (int i = 0; i < m; i++) {
            pq.offer(new Cell(i, 0, heightMap[i][0]));
            visited[i][0] = true;
            pq.offer(new Cell(i, n - 1, heightMap[i][n - 1]));
            visited[i][n - 1] = true;
        }
        for (int j = 1; j < n - 1; j++) { 
            pq.offer(new Cell(0, j, heightMap[0][j]));
            visited[0][j] = true;
            pq.offer(new Cell(m - 1, j, heightMap[m - 1][j]));
            visited[m - 1][j] = true;
        }

        int water = 0;
        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};

        while (!pq.isEmpty()) {
            Cell cur = pq.poll();
            for (int[] d : dirs) {
                int nx = cur.r + d[0];
                int ny = cur.c + d[1];
                if (nx >= 0 && nx < m && ny >= 0 && ny < n && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    int neighH = heightMap[nx][ny];

                    if (cur.h > neighH) {
                        water += cur.h - neighH;
                    }

                    pq.offer(new Cell(nx, ny, Math.max(neighH, cur.h)));
                }
            }
        }

        return water;
    }

    static class Cell {
        int r, c, h;
        Cell(int r, int c, int h){ this.r = r; this.c = c; this.h = h; }
    }
}
