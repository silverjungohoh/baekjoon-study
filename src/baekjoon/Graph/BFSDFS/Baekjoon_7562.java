package baekjoon.Graph.BFSDFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon_7562 {

    static int test, l, x1, y1, x2, y2;
    static int[][] grid;
    static boolean[][] visited;
    static int[] dx = {-2, -2, 2, 2, -1, -1, 1, 1};
    static int[] dy = {-1, 1, -1, 1, -2, 2, -2, 2};
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        test = Integer.parseInt(br.readLine());

        for (int i = 0; i < test; i++) {
            l = Integer.parseInt(br.readLine());
            grid = new int[l][l];
            visited = new boolean[l][l];

            st = new StringTokenizer(br.readLine());
            x1 = Integer.parseInt(st.nextToken());
            y1 = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            x2 = Integer.parseInt(st.nextToken());
            y2 = Integer.parseInt(st.nextToken());

            bfs(x1, y1);
            sb.append(grid[x2][y2]).append('\n');
        }
        System.out.println(sb);
    }

    public static void bfs(int x, int y) {
        Queue<Move> queue = new LinkedList<>();
        queue.offer(new Move(x, y));
        visited[x][y] = true;

        while (!queue.isEmpty()) {

            Move now = queue.poll();

            for (int i = 0; i < 8; i++) {
                int xx = now.x + dx[i];
                int yy = now.y + dy[i];

                if (checkRange(xx, yy) && !visited[xx][yy]) {
                    queue.offer(new Move(xx, yy));
                    visited[xx][yy] = true;
                    grid[xx][yy] = grid[now.x][now.y] + 1;
                }
            }
        }
    }

    public static boolean checkRange(int x, int y) {
        return (x >= 0 && x < l && y >= 0 && y < l);
    }
}

class Move {
    int x;
    int y;

    public Move(int x, int y) {
        this.x = x;
        this.y = y;
    }
}