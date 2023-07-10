package baekjoon.Graph.BFSDFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 최소 이동 횟수, 이동할 수 없는 경우에는 -1
 * (r-2, c-1), (r-2, c+1), (r, c-2), (r, c+2), (r+2, c-1), (r+2, c+1)로 이동
 */

public class Baekjoon_16948 {

    static int n, r1, c1, r2, c2;
    static int[][] grid;
    static boolean[][] visited;
    static int[] dx = {-2, -2, 0, 0, 2, 2};
    static int[] dy = {-1, 1, -2, 2, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        grid = new int[n][n];
        visited = new boolean[n][n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        r1 = Integer.parseInt(st.nextToken());
        c1 = Integer.parseInt(st.nextToken());
        r2 = Integer.parseInt(st.nextToken());
        c2 = Integer.parseInt(st.nextToken());

        bfs(r1, c1);
        System.out.println(grid[r2][c2] == 0 ? -1 : grid[r2][c2]);
    }

    public static void bfs(int x, int y) {
        Queue<Chess> queue = new LinkedList<>();
        queue.offer(new Chess(x, y));
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            Chess now = queue.poll();

            for (int i = 0; i < dx.length; i++) {
                int xx = now.x + dx[i];
                int yy = now.y + dy[i];

                if (checkRange(xx, yy) && !visited[xx][yy]) {
                    visited[xx][yy] = true;
                    grid[xx][yy] = grid[now.x][now.y] + 1;
                    queue.offer(new Chess(xx, yy));
                }
            }
        }
    }

    public static boolean checkRange(int x, int y) {
        return (x >= 0 && x < n && y >= 0 && y < n);
    }
}

class Chess {
    int x;
    int y;

    public Chess(int x, int y) {
        this.x = x;
        this.y = y;
    }
}